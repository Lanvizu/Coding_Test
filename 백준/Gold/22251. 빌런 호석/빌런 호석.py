# 각 숫자마다 최소 몇개를 반전해야 어떤 숫자로 넘어가는지 미리 저장 가능
# ex) 0 -> 1 (4), 0 -> 2 (3)
# 수동으로 등록해줘야하나.... 너무 귀찮은데 이건
# 각 칸을 위부터 순서대로 총 7칸의 LED 중 On만 1
import sys

input = sys.stdin.readline

graph = [[1,1,1,0,1,1,1],
         [0,0,1,0,0,1,0],
         [1,0,1,1,1,0,1],
         [1,0,1,1,0,1,1],
         [0,1,1,1,0,1,0],
         [1,1,0,1,0,1,1],
         [1,1,0,1,1,1,1],
         [1,0,1,0,0,1,0],
         [1,1,1,1,1,1,1],
         [1,1,1,1,0,1,1]]

g_cnt = [[0]*10 for _ in range(10)]
for i in range(10):
    for j in range(10):
        if i != j:
            for k in range(7):
                if graph[i][k] != graph[j][k]:
                    g_cnt[i][j] += 1

N, K, P, X = map(int,input().split())
x_length = len(str(X))
x = []
if x_length < K:
    for i in range(K-x_length):
        x.append(0)
for a in str(X):
    x.append(int(a))

n = [int(a) for a in str(N)]
total_cnt = 0
# 48 2 5 35
# 35를 각각의 자리수로 진행
# 최대 5번 변경가능
# 3 - [3, 3, 2, 0, 3, 2, 3, 2, 2, 1]
# 5 - [3, 5, 4, 2, 3, 0, 1, 4, 2, 1]
# 합쳐서 5 이하인 경우에만 total_count += 1
# 0을 선택해도 되는데? 마지막에 X와 동일한 1만 빼면 될듯
# 대신 48까지 있음 즉 49 이상인 수는 선택 불가.
# dp 사용?

def dp(tar,k,n_cnt):
    global total_cnt
    if k > K-1:
        if n_cnt <= P and tar > 0:
            total_cnt += 1
        return
    now = x[k]

    for i in range(10):
        if N < tar + i:
            return
        dp((tar+i)*10,k+1, n_cnt + g_cnt[now][i])

dp(0,0,0)
print(total_cnt-1)