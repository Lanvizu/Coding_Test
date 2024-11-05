import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(input()[:M]) for _ in range(N)]
visited_0 = [[1000001]*M for _ in range(N)]
visited_1 = [[1000001]*M for _ in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs():
    q = deque()
    # [x,y,이동 횟수, 벽 부순 여부]
    now = [0,0,1,0]
    q.append(now)
    visited_0[0][0] = 1
    visited_1[0][0] = 1
    while q:
        now = q.popleft()
        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]
            if nx < 0 or ny < 0 or nx > N-1 or ny > M-1:
                continue
            now_count = now[2] + 1

            # 기회를 쓴 경우
            if now[3] == 1:
                if graph[nx][ny] =='1':
                    continue
                else:
                    if now_count < visited_1[nx][ny]:
                        now_1 = [nx,ny,now_count, 1]
                        visited_1[nx][ny] = now_count
                        q.append(now_1)
            # 기회를 안 쓴 경우
            else:
                if graph[nx][ny] == '1':
                    now_2 = [nx,ny,now_count, 1]
                    visited_1[nx][ny] = now_count
                    q.append(now_2)
                else:
                    if now_count < visited_0[nx][ny]:
                        now_0 = [nx,ny,now_count, 0]
                        visited_0[nx][ny] = now_count
                        q.append(now_0)

bfs()
answer = min(visited_1[N-1][M-1], visited_0[N-1][M-1])
if answer == 1000001:
    print(-1)
else:
    print(answer)