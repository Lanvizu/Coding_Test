import sys
input = sys.stdin.readline
N = int(input())
fav = []
for i in range(N*N):
    fav.append(list(map(int, input().split())))

graph = [[0] * N for _ in range(N)]
# 상좌하우 순서로 설정
dd = [[-1,0], [0,-1], [0,1], [1,0]]

def cnd1(N, target, graph):
    max_tar_0 = [-1,-1,-1,-1]
    for i in range(N):
        for j in range(N):
            # 사람이 있는 경우 무시
            if graph[i][j] != 0:
                continue
            # 친한 친구 수
            fav_count = 0
            # 빈 자리 수
            count = 0
            for a in dd:
                nx = i + a[0]
                ny = j + a[1]
                # 범위 밖 예외 처리
                if nx < 0 or ny < 0 or nx > N-1 or ny > N-1:
                    continue
                if graph[nx][ny] == 0:
                    count += 1
                elif graph[nx][ny] in target[1:]:
                    fav_count += 1
            if max_tar_0[3] < fav_count or (max_tar_0[3] == fav_count and max_tar_0[2] < count):
                max_tar_0 = [i,j,count,fav_count]
            
    graph[max_tar_0[0]][max_tar_0[1]] = target[0]
            
for now_fav in fav:
    cnd1(N, now_fav, graph)

total = 0
for i in range(N):
    for j in range(N):
        count = 0
        for now_fav in fav:
            if graph[i][j] != now_fav[0]:
                continue
            for a in dd:
                nx = i + a[0]
                ny = j + a[1]
                # 범위 밖 예외 처리
                if nx < 0 or ny < 0 or nx > N-1 or ny > N-1:
                    continue
                if graph[nx][ny] in now_fav[1:]:
                    count += 1
        if count == 0:
            continue
        total += 10 ** (count-1)
print(total)
