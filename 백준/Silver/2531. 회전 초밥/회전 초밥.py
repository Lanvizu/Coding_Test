# 딕셔너리 key, value 값으로 (회전 초밥의 종류, 개수)와 총 개수를 측정해서
# k개가 유지되도록 해당 딕셔너리를 유지
# k가 유지되면 내부의 회전 초밥 종류의 개수를 업데이트하며 최대 종류의 개수 계산
# 쿠폰 번호 c 에 대한 처리: 딕셔너리에 c 가 없는 경우만 최대 종류 개수 + 1

import sys
input = sys.stdin.readline

N,d,k,c = map(int,input().split())

tar_dic = {}
graph = []
count = 0
max_type = 0

# 현재 값 추가
def cal_now(now):
    if now in tar_dic:
        tar_dic[now] += 1
    else:
        tar_dic[now] = 1

# 이전 값 제거
def cal_bef(before_tar):
    if tar_dic[before_tar] == 1:
        tar_dic.pop(before_tar)
    else:
        tar_dic[before_tar] -= 1

# c 여부 판단 후 max 계산
def cal_c():
    global max_type
    if c in tar_dic:
        max_type = max(max_type, len(tar_dic))
    else:
        max_type = max(max_type, len(tar_dic) + 1)

for i in range(N):
    now = int(input())
    graph.append(now)
    if count != k:
        count += 1
        cal_now(now)
    else:
        cal_c()
        before_tar = graph[i-k]
        cal_bef(before_tar)
        cal_now(now)
# 한 바퀴 이상 처리
for i in range(k):
    now = graph[i]

    cal_c()
    before_tar = graph[N+i-k]
    cal_bef(before_tar)
    cal_now(now)

print(max_type)