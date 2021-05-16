from django.db import models

# 테이블 생성 - 파이썬 문법을 통해 자동 생성

class Question(models.Model):
    question_text = models.CharField(max_length=200) #Char필드 크기를 200으로 하겠다
    pub_date = models.DateTimeField('date published')

    def __str__(self):
        return self.question_text

class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)

    def __str__(self):
        return self.choice_text

