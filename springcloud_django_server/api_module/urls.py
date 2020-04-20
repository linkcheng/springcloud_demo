#!/usr/bin/env python3
# -*- coding: UTF-8 -*-
from django.urls import path

from .views import *


urlpatterns = [
    path('health/', health),
    path('index/', index),
    path('', index),
    path('book/<int:pk>', BookAPIView.as_view())
]
