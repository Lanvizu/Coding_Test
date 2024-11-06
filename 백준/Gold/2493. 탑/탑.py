import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = list(map(int, input().split()))
target_list = [0] * N
q = deque()

for i in range(N):
    while q:
        if q[-1][1] > graph[i]:
            target_list[i] = q[-1][0] + 1
            break
        else:
            q.pop()
    q.append([i, graph[i]])
print(*target_list)