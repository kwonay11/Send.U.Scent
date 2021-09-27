from django.urls import path
from . import views

app_name = 'detail'

urlpatterns = [
    path('<int:perfume_id>/', views.detail, name='detail'),
    path('<int:perfume_id>/review/', views.review, name='review'),
]
