#!/usr/bin/env python3
# -*- coding: UTF-8 -*-
"""
@author: Link
@module: views
@date: 2020-04-20
"""
from rest_framework.decorators import api_view, APIView
from rest_framework.response import Response
from django.http import JsonResponse, Http404


@api_view(['GET'])
def health(request):
    """
    返回健康状态
    """
    return JsonResponse({
        "status": "UP"
    })


@api_view(['GET'])
def index(request):
    """
    返回健康状态
    """
    return Response('It works.')


class BookAPIView(APIView):
    DATA = [
        {
           "id": 1,
           "btitle": "射雕英雄传",
           "bpub_date": "1980-05-01",
           "bread": 12,
           "bcomment": 34,
           "image": ""
        }, {
           "id": 2,
           "btitle": "天龙八部",
           "bpub_date": "1986-07-24",
           "bread": 36,
           "bcomment": 40,
           "image": ""
        }, {
           "id": 3,
           "btitle": "笑傲江湖",
           "bpub_date": "1995-12-24",
           "bread": 20,
           "bcomment": 80,
           "image": ""
        }, {
           "id": 4,
           "btitle": "雪山飞狐",
           "bpub_date": "1987-11-11",
           "bread": 58,
           "bcomment": 24,
           "image": ""
        }, {
           "id": 5,
           "btitle": "西游记",
           "bpub_date": "1988-01-01",
           "bread": 10,
           "bcomment": 10,
           "image": "booktest/xiyouji.png"
        }, {
           "id": 6,
           "btitle": "水浒传",
           "bpub_date": "1992-01-01",
           "bread": 10,
           "bcomment": 11,
           "image": ""
        }, {
           "id": 7,
           "btitle": "红楼梦",
           "bpub_date": "1990-01-01",
           "bread": 0,
           "bcomment": 0,
           "image": ""
        }
    ]

    def get(self, req, pk, format=None):
        if pk < 1 or pk > len(self.DATA):
            raise Http404

        return JsonResponse(self.DATA[pk-1], json_dumps_params={"ensure_ascii": False})
