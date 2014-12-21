#!/usr/bin/python

n = input();
for i in range(0, n):
	length = input();
	L1 = raw_input().split();
	L1 = map(int, L1);
	L1.sort();
	L2 = raw_input().split();
	L2 = map(int, L2);
	L2.sort();
	sum = 0;
	for n1, n2 in zip(L1, L2):sum = sum + (n1*n2);
	print sum; 