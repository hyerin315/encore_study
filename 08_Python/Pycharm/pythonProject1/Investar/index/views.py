from django.shortcuts import render

# Create your views here.
def main_view(requset):
    return render(requset, 'index.html')

