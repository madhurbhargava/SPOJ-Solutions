#!/usr/bin/python

def occurrences(string, sub):
    count = start = 0;
    while 1:
        start = string.find(sub, start) + 1;
        if start > 0:
            count+=1;
        else:
            return count;

n = input();
for i in range(0, n):
	num = input();
	str = raw_input().strip();
	print num, occurrences(str, "TTT"), occurrences(str, "TTH"), occurrences(str, "THT"), occurrences(str, "THH"), occurrences(str, "HTT"),occurrences(str, "HTH"), occurrences(str, "HHT"), occurrences(str, "HHH");