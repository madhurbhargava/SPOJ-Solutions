#!/usr/bin/python

n = input();

for i in range(0, n):
	num1, num2 = raw_input().strip().split();
	num = int(num1[::-1]) + int(num2[::-1]);
	print int((str(num))[::-1]);