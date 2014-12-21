#!/usr/bin/python

L = [];
while 1:
	try:
		var = raw_input();
	except EOFError:
		break
	if(len(var) > 0):
		L.append(int(var));
	else:
		break;
	
for item in L:
	if item == 42:
		break;
	print item;

