from rest_framework import serializers
from .models import Perfume
class TestResultSerializer(serializers.ModelSerializer):
    class Meta:
        model = Perfume
        fields = '__all__'