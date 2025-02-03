import sys
from collections import deque 

input = sys.stdin.readline
N, K = map(int, input().split())

gp = list(map(int, input().split()))
q = deque()

for i in range(K):
    q.append(gp[i])

total_max = sum(q)
total_now = total_max

for i in range(K, N):
    now = gp[i]
    q.append(now)
    total_now += now
    total_now -= q.popleft()
    total_max = max(total_max, total_now)

print(total_max)