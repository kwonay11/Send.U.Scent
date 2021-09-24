from django.contrib import admin
# from .models import Perfume
from .models import Test

# Register your models here.
# class PerfumeAdmin(admin.ModelAdmin):
#     list_display = ('pk', 'perfume_id', 'title')

class TestAdmin(admin.ModelAdmin):
    list_display = ('pk', 'perfume_id', 'title', 'longevity',)

# admin.site.register(Perfume, PerfumeAdmin)
admin.site.register(Test, TestAdmin)
