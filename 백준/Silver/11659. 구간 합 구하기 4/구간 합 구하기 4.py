import sys

input = sys.stdin.readline

N, M = map(int, input().split())
graph = list(map(int, input().split()))
dp = [0] * N
dp[0] = graph[0]
for i in range(1, N):
    dp[i] = dp[i-1] + graph[i]

for i in range(M):
    a, b = map(int, input().split())
    if a == 1:
        print(dp[b-1])
    else:
        print(dp[b-1] - dp[a-2])
