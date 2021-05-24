from django.shortcuts import render
import requests
import pandas as pd
import xml.etree.ElementTree as ET
# Create your views here.

def covid19(end_date='20210521'): # end_date='20210521' : default 값
    key = "WRvGBkn9UEtw%2BAsg0tYo210Etxvb1QEcAX%2BwfWvOxVGYJkh1CNZ%2FY4QFa0r7j4bhT4NjPu7z1i1ck8ZgsKMt2Q%3D%3D"
    url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=WRvGBkn9UEtw%2BAsg0tYo210Etxvb1QEcAX%2BwfWvOxVGYJkh1CNZ%2FY4QFa0r7j4bhT4NjPu7z1i1ck8ZgsKMt2Q%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20200310&endCreateDt={}"
    r = requests.get(url.format(end_date))
    print(r.url)

    root = ET.fromstring(r.text)
    total = []
    items = root.iter(tag='item')
    for element in items:
        # print(element.find("accDefRate").text)
        covid_dict = {}
        for x in element:
            covid_dict[x.tag] = x.text
        total.append(covid_dict)
    df = pd.DataFrame(total)
    df = df.where(~(df == "null"), None)
    global df2
    df2 = df.copy()
    df.sort_values(by=['stateDt'], ascending=False, inplace=True)
    df['decideCnt'] = df['decideCnt'].astype(int)
    df['일별확진자'] = df['decideCnt'].astype(int).diff(-1)
    rt = df[['createDt', '일별확진자']].copy()
    rt['일별확진자'] = rt['일별확진자'].shift(1)
    rt.dropna(inplace=True)
    rt['createDt'] = rt['createDt'].apply(lambda x: x[:10])
    return rt

def main_view(request): #메인뷰 실행
    querydict = request.GET.copy()
    mylist = querydict.lists()
    
    for x in mylist: #장고에서 사용하는 객체를 for문 통해서 데이터를 갖고옴
        result = covid19((x[1][0])) #원하는 날짜를 result에 넣어줌

    total = 0

    #result = covid19()  # 데이터를 갖고옴
    rows = list(zip(result['createDt'].tolist(), result['일별확진자'].tolist())) #하나의 row로 생성 (첫번째 row에 있는 것들이 첫번째로, 두번째에 있는 것들이 두번쨰로)
    total = sum(result['일별확진자'].tolist()) #일별확진자가 모두 더해진 합계

    total_amount = format(int(total), ',')
    values = {'rows' : rows, 'total' : total_amount}
    return render(request, 'covid19.html', values)