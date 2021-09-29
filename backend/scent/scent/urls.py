from django.contrib import admin
from django.urls import path,include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('scent/api/detail/', include('detail.urls')),
    path('scent/tests/', include('tests.urls')),
]
