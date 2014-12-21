def fctrl(n):
	if n==0:
		return 1;
	else:
		return n*fctrl(n-1);
			
	
		
n = input();
for i in range(0, n):
	L = raw_input().split();
	print L;