import sys
input = sys.stdin.readline

N, M, R = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

# 주어진 범위를 변경하는 함수
def rr(N, M, graph):
    ss = [0, 0, N - 1, M - 1]  # 시작점과 종료점
    result = [[0] * M for _ in range(N)]
    
    while (ss[0] <= ss[2] and ss[1] <= ss[3]):
        rd(ss, graph, result)
        # 범위 업데이트
        ss[0] += 1
        ss[1] += 1
        ss[2] -= 1
        ss[3] -= 1
        
    return result

# 주어진 범위 내의 가장자리 부분만 반시계 회전 함수
def rd(ss, graph, result):
    
    # 위쪽 행
    for b in range(ss[1], ss[3] + 1):
        result[ss[0]][b] = graph[ss[0]][b]

    # 오른쪽 열
    for a in range(ss[0] + 1, ss[2] + 1):
        result[a][ss[3]] = graph[a][ss[3]]

    # 아래쪽 행
    for b in range(ss[3], ss[1] - 1, -1):
        result[ss[2]][b] = graph[ss[2]][b]

    # 왼쪽 열
    for a in range(ss[2] - 1, ss[0], -1):
        result[a][ss[1]] = graph[a][ss[1]]

    # 각 가장자리를 반시계 회전
    for a in range(ss[0], ss[2]):
        result[a + 1][ss[1]] = graph[a][ss[1]]
    for b in range(ss[1], ss[3]):
        result[ss[2]][b + 1] = graph[ss[2]][b]
    for a in range(ss[2], ss[0], -1):
        result[a - 1][ss[3]] = graph[a][ss[3]]
    for b in range(ss[3], ss[1], -1):
        result[ss[0]][b - 1] = graph[ss[0]][b]

# 주어진 R 만큼 회전 반복
for _ in range(R):
    graph = rr(N, M, graph)

for a in graph:
    print(' '.join(map(str, a)))