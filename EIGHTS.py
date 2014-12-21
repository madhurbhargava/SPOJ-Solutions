#!/usr/bin/python

t = input();
for i in range(0, t):
	num = input();
	res = 0;
	if num == 1:
		res = 1 * 192;
	else:
		res = ((num-1)*250)+192; 
	print res;
	
	