#!/usr/bin/python

n = input();
for i in range(0, n):
	raw_input();
	l = raw_input().split();
	index = -1;
	for j in range(0, len(l)):
		if 'machula' in l[j]:
			index = j;
			break;
	#print l;
	#print index;
	if index == 0 :
		l[0] = str(int(l[4]) - int(l[2]));
	elif index == 2:
		l[2] = str(int(l[4]) - int(l[0]));
	else:
		l[4] = str(int(l[0]) + int(l[2]));
	print l[0], l[1], l[2], l[3], l[4]; 		
	
			