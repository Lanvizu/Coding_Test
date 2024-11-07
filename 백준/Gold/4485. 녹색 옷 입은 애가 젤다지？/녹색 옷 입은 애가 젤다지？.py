import sys
from collections import deque
input = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def min_bfs(N, graph):
    q = deque()
    min_visited = [[100001] * N for _ in range(N)]
    min_visited[0][0] = graph[0][0]
    q.append([0,0])
    while q:
        now = q.popleft()
        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]
            if nx < 0 or ny < 0 or nx > N-1 or ny > N-1:
                continue
            graph_now = min_visited[now[0]][now[1]] + graph[nx][ny]
            if graph_now < min_visited[nx][ny]:
                min_visited[nx][ny] = graph_now
                q.append([nx,ny])

    return min_visited[N-1][N-1]

count = 1
while 1:
    N = int(input())
    if N == 0:
        break
    graph = [list(map(int, input().split())) for _ in range(N)]
    result = min_bfs(N, graph)
    print(f"Problem {count}: {result}")
    count += 1