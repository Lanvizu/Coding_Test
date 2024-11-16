# 121 최대 평균인 상황
# 121 - 110 = 11, 1 12
# 242 + 12 254/2 127
import sys
input = sys.stdin.readline

N = int(input())
graph = list(map(int,input().split()))
M = int(input())
graph.sort()

if sum(graph) <= M:
    print(graph[N-1])
else:
    total_now = M
    avg_M = M / N

    result = 0
    result_now = N-1
    for i in range(N-1):
        if graph[i] <= avg_M:
            total_now = total_now - graph[i]
            avg_M = (total_now) / (N-i-1)
        else:
            result_now = i
            break
    
    print(int(avg_M))