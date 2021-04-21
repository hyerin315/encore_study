var app = new Vue({
    el: '#app-t1',
    data: {
        value: 0,
        isChecked: true,
        header: '우유 급식 안내 및 설문조사',
        messages: ['학부모님 안녕하십니까?', 
                   '학부모님의 가정에 언제나 다복함이 가득하시길 바라며, 건강 유의하시기 바랍니다.',
                   '2021학년도 우유급식에 대한 안내말씀을 드리고자 합니다.'],
        message1: '- 우유공급업체 : 00우유',
        message2: '- 우유 종류 및 금액(아래 원하시는 우유 종류에 체크해주시길 바랍니다)',

        websiteList: [ '서울우유(우유류)', '롯데푸드(요거트류)'],
        urlList: ['http://www.seoulmilk.co.kr/enterprise/product/product_list.sm?subname=02', 'http://www.lottefoods.co.kr/product/product.asp?c1=M0000&c2=&c3=&schWord='],

        label1: '기본 우유 / 1500원',
        label2: '요구르트 / 2200원',
        label3: '프리미엄 / 2500원',
        label4: '기타 / 1900원',
        milkList: ['흰우유', '저지방 우유', '고칼슘 우유', '1등급 우유'],
        yogurtList: ['떠먹는 요거트', '마시는 요거트', '과일 요거트'],
        premiumList: ['초코 우유', '바나나 우유', '딸기 우유', '비요뜨', '윌'],
        etcList: ['짜요짜요', '베지밀', '검은콩두유'],
        text1: '기본 우유를 선택하셨습니다. 납부하실 금액은 월/30,000원(개 당) 입니다.',
        text2: '요구르트를 선택하셨습니다. 납부하실 금액은 월/44,000원(개 당) 입니다.',
        text3: '프리미엄를 선택하셨습니다. 납부하실 금액은 월/50,000원(개 당) 입니다.',
        text4: '기타를 선택하셨습니다. 납부하실 금액은 월/38,000원(개 당) 입니다.',
        text5: '우유를 선택해주세요',
        value1: '신청 학생 이름',
        num: 1,
        minus: 1,
        plus: 1,
        label5: '-',
        label6: '+'
    },

    methods: {
        onClickCheckButton: function (e) {
            this.isChecked = e.target.checked
        },

        onClickMinus: function () {
            this.num -= this.minus;

            if(this.num <= 0)
            {
                this.num =0;
            }
        },
        onClickPlus: function() {
            this.num += this.plus;
        }
    }
});
