from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def solution(maps):
    answer = 0
    n = len(maps)
    m = len(maps[0])
    S = [-1, -1]
    L = [-1, -1]
    for i in range(n):
        for j in range(m):
            now = maps[i][j]
            if now == 'S':
                S = [i, j]
            if now == 'L':
                L = [i, j]
            if S[0] != -1 and L[0] != -1:
                break
        if S[0] != -1 and L[0] != -1:
            break
    LT = bfsL(maps, S)
    if LT == None:
        answer = -1
    else:
        ET = bfsE(maps, L)
        if ET == None:
            answer = -1
        else:
            answer = LT + ET
    return answer

def bfsL(maps, S):
    n = len(maps)
    m = len(maps[0])
    visited = [[0] * m for _ in range(n)]
    q = deque()
    q.append([S[0], S[1], 0])
    visited[S[0]][S[1]] = -1
    while q:
        now = q.popleft()
        if maps[now[0]][now[1]] == 'L':
            return visited[now[0]][now[1]]
        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >=m:
                continue
            if visited[nx][ny] != 0:
                continue
            if maps[nx][ny] == 'X':
                continue
            visited[nx][ny] = now[2] + 1
            q.append([nx,ny,now[2]+1])
            
def bfsE(maps, L):
    n = len(maps)
    m = len(maps[0])
    visited = [[0] * m for _ in range(n)]
    q = deque()
    q.append([L[0], L[1], 0])
    visited[L[0]][L[1]] = -1
    while q:
        now = q.popleft()
        if maps[now[0]][now[1]] == 'E':
            return visited[now[0]][now[1]]
        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >=m:
                continue
            if visited[nx][ny] != 0:
                continue
            if maps[nx][ny] == 'X':
                continue
            visited[nx][ny] = now[2] + 1
            q.append([nx,ny,now[2]+1])
    