from django.urls import path
from . import views

app_name = 'tests'
urlpatterns = [
    path('',views.tests),
    path('result/',views.tests_result),
]