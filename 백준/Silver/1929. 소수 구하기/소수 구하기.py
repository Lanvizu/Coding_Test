import sys
import math
input = sys.stdin.readline

M, N = map(int,input().split())
graph = [True for _ in range(N+1)]
graph[0] = False
graph[1] = False
target = int(math.sqrt(N))
# 2~ target 수의 배수 정리
for i in range(2,target+1):
    if graph[i]:
        now = 2
        while i * now <= N:
            graph[i * now] = False
            now += 1

for i in range(M, N+1):
    if graph[i]:
        print(i)
