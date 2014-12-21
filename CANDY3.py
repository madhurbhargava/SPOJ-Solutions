#!/usr/bin/python

n = input();
for i in range(0, n):
	raw_input();
	children = input();
	candy = 0;
	for j in range(0, children):
		candy += input();
	if(candy%children == 0):
		print "YES";
	else:
		print "NO";