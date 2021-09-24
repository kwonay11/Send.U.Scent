from django.db.models import fields
from rest_framework import serializers
from .models import PerfumeResult

class PerfumeResult(serializers.ModelSerializer):
    class Meta:
        model = PerfumeResult
        fields = '__all__'