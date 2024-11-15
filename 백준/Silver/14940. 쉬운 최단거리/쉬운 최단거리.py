import sys
from collections import deque
input = sys.stdin.readline

dx = [1,-1,0,0]
dy = [0,0,1,-1]
x,y = -1,-1

N, M = map(int, input().split())
graph = []
for i in range(N):
    input_list = list(map(int, input().split()))
    for j in range(M):
        if input_list[j] == 2:
            x, y = i, j
    graph.append(input_list)

def bfs():
    q = deque()
    q.append([0,x,y])
    graph[x][y]= 0
    while q:
        nn, nx, ny = q.popleft()
        for i in range(4):
            tx, ty = nx + dx[i], ny + dy[i]
            if tx < 0 or tx >= N or ty < 0 or ty >= M:
                continue

            now = graph[tx][ty]
            if now == 1 or nn+1 < now:
                q.append([nn+1,tx,ty])
                graph[tx][ty] = nn + 1

bfs()

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            graph[i][j] = -1
        elif abs(i - x) + abs(j - y) == 1 and graph[i][j] != 0:
            graph[i][j] = 1
    print(*graph[i])
