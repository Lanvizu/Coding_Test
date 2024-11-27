import sys
from collections import deque
input = sys.stdin.readline
q1 = deque()
q2 = deque()
q1.extend(input()[:-1])
N = int(input())
now = len(q1)

def L():
    if q1:
        q2.appendleft(q1.pop())

def D():
    if q2:
        q1.append(q2.popleft())

def B():
    if q1:
        q1.pop()

def P(x):
    q1.append(x)

for _ in range(N):
    input_str = list(map(str,input().split()))
    if input_str[0] == 'P':
        P(input_str[1])
    elif input_str[0] == 'L':
        L()
    elif input_str[0] == 'D':
        D()
    else:
        B()
result = ''.join(q1 + q2)
print(result)