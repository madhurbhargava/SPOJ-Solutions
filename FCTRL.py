#!/usr/bin/python
		
def Z(n):
	count = 0;
	loopcount = 1;
	quot = n;
	while quot >= 1 and n >= 5:
		quot = n/(5**loopcount);
		loopcount = loopcount + 1;
		count = count+quot;
			
	return count;
		
n = input();
for i in range(0, n):
	num = int(raw_input());
	print Z(num);
	
	 