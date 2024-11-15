# 2 6
# 2 90
# 80 98
# 91 10
# 92 11
# 93 12
# 94 13
# 95 14
# 96 15

import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
up_down = {}
for _ in range(N+M):
    k, v = map(int, input().split())
    up_down[k] = v

q = deque([(1, 0)])  # (위치, 주사위 굴린 횟수)
visited = [False] * 101

while q:
    x, moves = q.popleft()

    if x == 100:
        print(moves)
        break

    for i in range(1, 7):
        nx = x + i
        if nx > 100:
            continue
        
        if nx in up_down:
            nx = up_down[nx]

        if not visited[nx]:
            visited[nx] = True
            q.append((nx, moves + 1))