def add(a, b):
	if type(a) is int and type(b) is int:
		print (a + b)
	else:
		print ('invalid input')

num1 = input('enter the first number:')
num2 = input('enter the second number:')
add(num1, num2)
