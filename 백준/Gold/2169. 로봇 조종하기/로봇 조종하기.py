import sys
input = sys.stdin.readline

N, M = map(int, input().split())
dp = [list(map(int, input().split())) for _ in range(N)]

for j in range(1, M):
    dp[0][j] += dp[0][j-1]
    
for i in range(1, N):
    right = dp[i][:]
    left = dp[i][:]

    for j in range(M):
        if j == 0:
            right[j] += dp[i-1][j]
            left[M-1-j] += dp[i-1][M-1-j]
        else:
            right[j] += max(dp[i-1][j], right[j-1])
            left[M-1-j] += max(dp[i-1][M-1-j], left[M-j])

    for j in range(M):
        dp[i][j] = max(right[j], left[j])

print(dp[N-1][M-1])