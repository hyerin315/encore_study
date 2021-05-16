from django.contrib import admin
from polls.models import Question, Choice

# admin에 테이블 등록

admin.site.register(Question)
admin.site.register(Choice)