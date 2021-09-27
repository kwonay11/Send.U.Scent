from rest_framework import serializers
from .models import PerfumeResult
class TestResultSerializer(serializers.ModelSerializer):
    class Meta:
        model = PerfumeResult
        fields = '__all__'