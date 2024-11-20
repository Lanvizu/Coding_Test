# 15
# 1 5 3 2 6 3 2 6 4 2 5 7 3 1 5

# 예를 들어 두번째 6에 대해서 진행
# 왼쪽으로 기울기 비교하며 이동
# 높이 = 6-2, 길이 = index 차이 1 -> 4 : 1
# 기울기 4보다 작아야 함
# 3, 2 -> 1.5 업데이트 : 2
# 0, 3 -> 0 이므로 6보다 커야 함 즉 최대 기울기가 0인 상태 : 3
# 없으므로 우측 계산
# 2,1 -> 2 : 4
# 4,2 -> 2 기울기 업데이트 안되므로 스킵
# 1,3 -> 1/3 : 5
# 1,4 -> 1/4 : -6 6넘어서는 기울기 업데이트
# 7보다 큰 값 없으므로 총 6개

import sys
input = sys.stdin.readline

N = int(input())
graph = list(map(int, input().split()))
max_count = 0

def cal(index):
    now = graph[index]
    count = 0
    icl = 1000000001

    for i in range(index-1, -1, -1):
        target = graph[i]
        tar_icl = (now - target)/abs(i-index)
        if icl > tar_icl:
            icl = tar_icl
            count += 1

    icl = 1000000001

    for i in range(index+1,N):
        target = graph[i]
        tar_icl = (now - target)/abs(i-index)
        if icl > tar_icl:
            icl = tar_icl
            count += 1
    return count

for i in range(N):
    max_count = max(max_count, cal(i))

print(max_count)