N, K = map(int, input().split())
coins = []
for _ in range(N):
    coins.append(int(input()))

dp = [22222 for _ in range(K+1)]
dp[0] = 0

for value in range(1, K+1):
    for coin in coins:
        if value < coin:
            continue
        dp[value] = min(dp[value], dp[value-coin]+1)
        

if dp[K] != 22222:
    print(dp[K])
else:
    print(-1)