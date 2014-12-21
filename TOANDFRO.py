#!/usr/bin/python

while 1:
	col = input();
	if(col == 0):
		break;
	str = raw_input();
	L = map(''.join, zip(*[iter(str)]*col));
	for i in range(len(L)):
		if i%2 != 0:
			L[i] = L[i][::-1];
	start = 0;
	message = '';
	for i in range(0, col):
		for j in range(len(L)):
			buffer = L[j];
			message += buffer[start];
		start += 1;
	print message;
