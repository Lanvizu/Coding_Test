import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = list(map(float, input().split()))

q_1 = deque()
q_2 = deque()
# 절댓값 큰 수 먼저 넣기
for i in range(N):
    number = graph[i]
    if number < 0:
        q_1.append(number)
    else:
        q_2.appendleft(number)

result = []
total = float('inf')

if q_1:
    first1 = q_1.pop()
    if q_1:
        second1 = q_1.pop()
        total = first1 + second1
        result = [second1, first1]
        q_1.append(second1)
    q_1.append(first1)

if q_2:
    first2 = q_2.pop()
    if q_2:
        second2 = q_2.pop()
        result = first2 + second2
        if result < abs(total):
            total = result
            result = [first2, second2]
        q_2.append(second2)
    q_2.append(first2)


if q_1 and q_2:

    now_1 = q_1.popleft()
    now_2 = q_2.popleft()

    while 1:
        now = now_1 + now_2
        if abs(now) < abs(total):
            total = now
            result = [now_1, now_2]
        if abs(now_1) >= abs(now_2):
            if q_1:
                now_1 = q_1.popleft()
            elif q_2:
                now_2 = q_2.popleft()
            else:
                break
        else:
            if q_2:
                now_2 = q_2.popleft()
            elif q_1:
                now_1 = q_1.popleft()
            else:
                break
print(*result)