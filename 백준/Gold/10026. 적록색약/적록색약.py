from collections import deque
import sys

sys.setrecursionlimit(10**6)

n = int(input())
tt = [(list(input().strip())) for _ in range(n)]

dx = [-1 , +1 , 0 , 0]
dy = [0, 0, -1, +1]

RG_count = 0
count = 0

def dfs(x, y, tt, visited, target):
    if visited[x][y] or tt[x][y] != target:
        return
    visited[x][y] = True

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        dfs(nx, ny, tt, visited, target)
    


# 정상인 출력
visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            count += 1
            dfs(i, j, tt, visited, "R")
            
            dfs(i, j, tt, visited, "G")
            
            dfs(i, j, tt, visited, "B")

visited = [[False] * n for _ in range(n)]

# 적록색약
for i in range(n):
    for j in range(n):
        if tt[i][j] == "G":
            tt[i][j] = "R"

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            RG_count += 1

            dfs(i, j, tt, visited, "R")
            
            dfs(i, j, tt, visited, "B")

print(count, RG_count)
