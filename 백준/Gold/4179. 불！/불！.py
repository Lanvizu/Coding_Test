import sys
from collections import deque
input = sys.stdin.readline

R, C = map(int,input().split())

graph = []
visited = [[False]*C for _ in range(R)]
fire_q = deque()

dx = [1,-1,0,0]
dy = [0,0,1,-1]
min_count = float('inf')

J = None
for i in range(R):
    input_str = list(map(str,input().rstrip()))
    graph.append(input_str)
    for j in range(C):
        if input_str[j] == 'J':
            J = (i,j)
        elif input_str[j] == 'F':
            fire_q.append((i,j))

visited[J[0]][J[1]] = True

# 불 퍼짐
def fire_move():
    for _ in range(len(fire_q)):
        x, y = fire_q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < R and 0 <= ny < C and graph[nx][ny] == '.':
                graph[nx][ny] = 'F'
                fire_q.append((nx, ny))

# BFS로 다시 진행
def BFS():
    global min_count
    q = deque()
    q.append((J[0], J[1], 1))
    # 일단 불을 먼저 진행
    while q:
        fire_move()
        ex = []
        while q:
            J_now = q.popleft()
            count = J_now[2]
            for i in range(4):
                nx = J_now[0] + dx[i]
                ny = J_now[1] + dy[i]
                if 0 <= nx < R and 0 <= ny < C:
                    if graph[nx][ny] == '.' and not visited[nx][ny]:
                        visited[nx][ny] = True
                        ex.append((nx,ny,count+1))
                else:
                    min_count = min(count, min_count)

        for a in ex:
            q.append(a)
BFS()
if min_count == float('inf'):
    print('IMPOSSIBLE')
else:
    print(min_count)