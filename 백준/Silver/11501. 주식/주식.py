# 가장 비싼 날 모두 팔아버린다.
# 1 1 2 1 3 -> 결국 3에 모든 것을 팔아버린다.
# 1 1 3 1 2 -> 가장 비싼 날 판 후 다음 비싼날 계산해 처리
# 1 1 3 1 2 1 1 -> 마지막 1 1 에는 아무것도 안한다.

import sys
input = sys.stdin.readline

def cal(graph, N):
    cnt = 0
    total = 0
    result = 0
    gr_mx = max(graph)
    mx_index = N-1-graph[::-1].index(gr_mx)
    for i in range(N):
        now = graph[i]
        if i == mx_index:
            result += gr_mx * cnt
            if i != N-1:
                gr_mx = max(graph[i+1:])
                mx_index = N-1-graph[::-1].index(gr_mx)
                cnt = 0
        else:
            cnt += 1
            total += now
    return result-total

T = int(input())
for _ in range(T):
    N = int(input())
    graph = list(map(int, input().split()))
    result = cal(graph, N)
    print(result)