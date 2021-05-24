from django.db import models

class Book(models.Model): #책 테이블
    title = models.CharField(max_length=100)

    authors = models.ManyToManyField('Author') #여러명의 저자를 가진 책(한 저자에게 여러 책)이 있을 수 있으므로 N:N

    # 상대 테이블의 레코드가 삭제될 대 본 테이블에서의 동작을 지정
    # -> CASCADE 옵션값의 의미는 Publisher 테이블의 특정 레코드가 삭제되면,
    #    그 레코드에 연결된 Book 테이블의 레코드도 삭제됨을 의미
    publisher = models.ForeignKey('Publisher', on_delete=models.CASCADE) #여러 책들이 하나의 출판사에서 발행되었을 수 있으므로 N:1 관계
    publication_date = models.DateField()

    def __str__(self): #admin에서 깨지지 않고 보이기 위해서 적어줘야함
        return self.title

class Author(models.Model): #저자 테이블
    name = models.CharField(max_length=50)
    salutation = models.CharField(max_length=100)
    email = models.EmailField()

    def __str__(self):
        return self.name

class Publisher(models.Model): #출판사 테이블
    name = models.CharField(max_length=50)
    address = models.CharField(max_length=100)
    website = models.URLField()

    def __str__(self):
        return self.name