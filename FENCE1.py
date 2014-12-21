#!/usr/bin/python

while 1:
	num = input();
	if num == 0:
		break;
	else:
		print "%.2f" % round(float(num*num)/(float(2)*float(3.1415926)), 2);
	