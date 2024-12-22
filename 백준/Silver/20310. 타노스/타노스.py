import sys
input = sys.stdin.readline

li = list(input())
zero, one = li.count('0')//2, li.count('1')//2
for _ in range(zero):
    li.pop(-li[::-1].index('0')-1)
for _ in range(one):
    li.pop(li.index('1'))
print(''.join(li))