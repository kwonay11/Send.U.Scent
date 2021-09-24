from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.shortcuts import render, get_object_or_404, get_list_or_404
from .models import Test
from .serializers import TestListSerializer


@api_view(['GET'])
def detail(request, perfume_id):
    perfume = get_object_or_404(Test, perfume_id=perfume_id)
    if request.method == 'GET':
        serializer = TestListSerializer(perfume)
        print(serializer)
        return Response(serializer.data)


def review(request, perfume_id):
    pass