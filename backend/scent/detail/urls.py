from django.urls import path
from . import views

app_name = 'detail'

urlpatterns = [
    path('<int:perfume_id>/', views.detail, name='detail'),
    path('<int:perfume_id>/review/', views.review, name='review'),
    path('rec1/<int:perfume_id>/', views.rec1, name='rec1'),
    path('rec2/', views.rec2, name='rec2'),
]
