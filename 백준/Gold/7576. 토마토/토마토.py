# 1을 기준으로 BFS -> 토마토 익는 기능
# 0을 기준으로 BFS -> 벽인 경우는 continue/ 주변이 모두 -1 인경우
# 하나의 BFS 함수에서 두가지의 기능을 구현
import sys
from collections import deque

m, n= map(int, input().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dx = [-1, +1, 0, 0]
dy = [0, 0, -1, +1]

q = deque([])
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            q.append([i,j])

def bfs():
    while q:
        x, y = q.popleft()

        for a in range(4):
            nx = x + dx[a]
            ny = y + dy[a]

            if 0 <= nx < n and 0 <= ny < m:
                if graph[nx][ny] == 0:
                    graph[nx][ny] = graph[x][y] + 1
                    q.append([nx,ny])

bfs()
day = 0
flag = True

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            flag = False
            break
        day = max(day, graph[i][j])

if flag == True:
    print(day-1)
else:
    print(-1)