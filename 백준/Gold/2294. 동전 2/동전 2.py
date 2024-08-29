n,k = map(int, input().split())
dp = [333333] * (k+1)
dp[0] = 0
graph = []
for i in range(n):
    graph.append(int(input()))

for i in range(1, k+1):
    for coin in graph:
        if i < coin:
            continue
        dp[i] = min(dp[i], dp[i - coin] + 1)

if dp[k] == 333333:
    print(-1)
else:
    print(dp[k])