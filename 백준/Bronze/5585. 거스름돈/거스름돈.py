n = int(input())
total = 1000 - n
answer = 0
a = total//500
answer += a
total -= 500 * a

b = total // 100
answer += b
total -= 100*b

c= total // 50
answer +=c
total -= 50*c

d= total // 10
answer +=d
total -= 10*d
e= total // 5
answer +=e
total -= 5*e
f= total // 1
answer += f
print(answer)
