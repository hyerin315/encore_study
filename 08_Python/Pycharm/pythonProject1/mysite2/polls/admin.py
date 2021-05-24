from django.contrib import admin
from polls.models import Question, Choice

# admin에 테이블 등록

#선택지 박스 생성
#class ChoiceInline(admin.StackedInline): #템플릿 1) 각각 박스 생성
class ChoiceInline(admin.TabularInline): #템플릿 2) 하나의 박스 생성
    model = Choice
    extra = 2

#date와 question text 순서 바꾸기
#question text 박스 펼치기/접기로 변경
class QuestionAdmin(admin.ModelAdmin):
    #fields = ['pub_date', 'question_text']
    fieldsets = [
        ('Question Statement', {'fields' : ['question_text']}),
        ('Date Information', {'fields' : ['pub_date'], 'classes' : ['collapse']})
    ]
    inlines = [ChoiceInline]
    list_display = ('question_text', 'pub_date') #목차 정렬할 수 있도록 탭 생성
    list_filter = ['pub_date'] #필터 생성
    search_fields = ['question_text'] #검색엔진 생성

admin.site.register(Question, QuestionAdmin)
admin.site.register(Choice)