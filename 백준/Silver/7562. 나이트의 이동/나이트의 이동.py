from collections import deque

dx = [1, 1, -1, -1, 2, 2, -2, -2]
dy = [2, -2, 2, -2, 1, -1, 1, -1]

def bfs(visited, l):
    while q:
        x, y = q.popleft()

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= l or ny < 0 or ny >= l:
                continue
            if visited[nx][ny]:
                continue
            graph[nx][ny] = min(graph[nx][ny], graph[x][y] + 1)
            visited[nx][ny] = True
            q.append([nx,ny])

n = int(input())
for _ in range(n):
    l = int(input())
    now = list(map(int, input().split()))
    dest = list(map(int, input().split()))

    graph = [[222222] * l for _ in range(l)]
    graph[now[0]][now[1]] = 0
    visited = [[False] * l for _ in range(l)]
    q = deque([])
    q.append([now[0],now[1]])
    visited[now[0]][now[1]] = True
    bfs(visited, l)
    print(graph[dest[0]][dest[1]])