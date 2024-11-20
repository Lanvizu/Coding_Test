# 최대 6*6 방향은 3방향
# 6*3*2*2*2*2*2 = 64* 6 = 384 충분한디
# 그럼 DP로 풀어볼까

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

min_fue = float('inf')
move_type = [-1,0,1]

def DP(bef_move, x, y, count):
    global min_fue
    if x == N-1:
        min_fue = min(min_fue, count)
        return
    for i in range(3):
        if bef_move == i:
            continue
        nx = x + 1
        ny = y + move_type[i]
        if 0 <= ny < M:
            now_c = count + graph[nx][ny]
            DP(i, nx, ny, now_c)

for i in range(M):
    DP(3, 0, i, graph[0][i])
print(min_fue)