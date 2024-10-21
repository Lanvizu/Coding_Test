# N, target 입력받음
N = int(input())
target = int(input())

# 표 초기화
graph = [[0] * N for _ in range(N)]

# N은 무조건 홀수가 입력되므로 시작위치는 중앙값 설정
now = [N//2, N//2]

# target의 x,y 좌표 초기화
tar_xy = [N//2, N//2]

count = 1
graph[now[0]][now[1]] = count

if count == target:
    tar_xy = [now[0]+1, now[1]+1]
count += 1
for i in range(1,N):
    # i(이동 크기)의 홀수 짝수에 따라 이동하는 방향 설정
    if i % 2 != 0:
        for j in range(i):
            now[0] -= 1
            if count == target:
                tar_xy = [now[0]+1, now[1]+1]
            graph[now[0]][now[1]] = count
            count += 1
        for j in range(i):
            now[1] += 1
            if count == target:
                tar_xy = [now[0]+1, now[1]+1]
            graph[now[0]][now[1]] = count
            count += 1
    else:
        for j in range(i):
            now[0] += 1
            if count == target:
                tar_xy = [now[0]+1, now[1]+1]
            graph[now[0]][now[1]] = count
            count += 1
        for j in range(i):
            now[1] -= 1
            if count == target:
                tar_xy = [now[0]+1, now[1]+1]
            graph[now[0]][now[1]] = count
            count += 1
# 마지막은 항상 y = 0인 줄 채워줘야함
if N > 1:
    for i in range(N-1):
        now[0] -= 1
        graph[now[0]][now[1]] = count
        if count == target:
                tar_xy = [now[0]+1, now[1]+1]
        count += 1

for i in range(N):
    print (*graph[i])
print(tar_xy[0], tar_xy[1])