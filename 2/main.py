import sys
lines = []
depth = 0
hor = 0
aim = 0
with open(sys.argv[1], 'r') as f:
	lines = f.readlines()
# print(lines)

count = 0
for line in lines:
	count +=1
	x = line.split(" ")
	if 'forward' in x[0]:
		y = int(x[1])
		z = aim * int(x[1])
		depth += z
		hor += y
	elif 'up' in x[0]:
		y = int(x[1])
		aim -= y
	elif 'down' in x[0]:
		y = int(x[1])
		aim += y
print(depth)
print(hor)
ans = depth * hor
print(ans)
