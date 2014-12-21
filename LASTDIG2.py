#!/usr/bin/python

def modExp(base, exp, modvar):
    binary = "{0:b}".format(exp);
    res = 1;
    while len(binary) != 0:
    	if (binary[len(binary)-1]=='1'):
    		res=(res*base)%modvar;
    	binary=binary[:len(binary)-1];
    	base=(base*base)%modvar;
    return res;

n = input();
for i in range(0, n):
	num1, num2 = raw_input().strip().split();
	res = modExp(int(num1), int(num2), 10);
	print res;
	