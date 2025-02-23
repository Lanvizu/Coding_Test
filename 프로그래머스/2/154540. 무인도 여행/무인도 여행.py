from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[False] * 100 for _ in range(100)]

def solution(maps):
    answer = []
    n = len(maps)
    m = len(maps[0])
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 'X' or visited[i][j]:
                continue
            answer.append(bfs(i, j, maps, n, m))
    if not answer:
        answer.append(-1)
    else:
        answer.sort()
    return answer

def bfs(x, y, maps, n, m):
    q = deque()
    q.append([x,y])
    result = int(maps[x][y])
    visited[x][y] = True
    while q:
        a,b = q.popleft()
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if visited[nx][ny] or maps[nx][ny] == 'X':
                continue
            q.append([nx,ny])
            result += int(maps[nx][ny])
            visited[nx][ny] = True
    return result
    
            