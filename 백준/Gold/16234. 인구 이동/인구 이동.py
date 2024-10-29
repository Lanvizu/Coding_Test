# 초기 설정
import sys
from collections import deque
input = sys.stdin.readline
N,L,R = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def BFS(start_x, start_y, graph, visited):
    global change
    q = deque()
    # 큐 -> 현재 x, 현재 y, 현재 인구수
    q.append([start_x, start_y])
    visited[start_x][start_y] = True
    total_sum = graph[start_x][start_y]
    # 조건 만족한 인구수
    count = 1
    # 이동 나라 리스트
    target_country = []
    target_country.append([start_x, start_y])
    while q:
        now = q.popleft()
        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue

            if visited[nx][ny]:
                continue

            result = abs(graph[nx][ny] - graph[now[0]][now[1]])

            if result < L or result > R:
                continue

            # 조건에 만족한 경우 큐에 추가
            q.append([nx, ny])
            visited[nx][ny] = True
            count += 1
            total_sum += graph[nx][ny]
            target_country.append([nx,ny])
            change = True
    if change:
        mean_sum = int(total_sum / count)
        for target in target_country:
            graph[target[0]][target[1]] = mean_sum

# 인구 이동 여부
change = True
# 인구 이동 횟수
answer = 0
# 인구 이동 시 반복
while change:
    change = False
    visited = [[False] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if visited[i][j]:
                continue
            BFS(i,j,graph, visited)
    if change:
        answer += 1
print(answer)