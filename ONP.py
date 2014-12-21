#!/usr/bin/python
n = input();
index = 0;
for i in range(0, n):
	str = raw_input();
	index = 0;
	count  = 0;
	res="";
	L = [];
	while index < len(str):
		letter = str[index]
		if letter.isalpha():
			res+=letter;
		elif letter == "(":
			count += 1;
		elif letter == ")":
			count -= 1;
			res+=L.pop();	
		else:
			L.append(letter);
		
		index = index + 1;
		
	print res;