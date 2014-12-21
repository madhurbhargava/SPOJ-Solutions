#!/usr/bin/python
import math;

while 1:
	num1, num2 = raw_input().strip().split();
	n1 = int(num1);
	n2 = int(num2);
	if n1 == -1 and n2 == -1:
		break;
	elif n1 == 0 and n2 == 0:
		print n1;
	elif n1 == 0 or n2 == 0:
		if n1 == 0:
			print n2;
		else:
			print n1;
	elif n1 == n2:
		print 1;
	else:
		if n2 > n1:
			n1, n2 = n2, n1;
		print int(math.ceil(float(float(n1)/float(n2+1))));