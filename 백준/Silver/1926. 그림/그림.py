import sys
from collections import deque

n, m = map(int, input().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dx = [-1, +1, 0, 0]
dy = [0, 0, -1, +1]

def bfs(x, y, count, visited):
    queue = deque()
    queue.append((x,y))

    visited[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx > n-1 or ny > m-1:
                continue
            if graph[nx][ny] == 0:
                continue
            if visited[nx][ny]:
                continue

            visited[nx][ny] = True
            count += 1
            # print(nx, ny, count)
            queue.append((nx,ny))

    return count

visited = [[False] * m for _ in range(n)]
result = 0
count = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 and not visited[i][j]:
            result = max(result, bfs(i, j, 1, visited))
            count += 1

print(count)
print (result)