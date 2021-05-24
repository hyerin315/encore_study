from django.contrib import admin
from books.models import Book, Author, Publisher #3개의 클래스 import

#admin 등록
admin.site.register(Book)
admin.site.register(Author)
admin.site.register(Publisher)