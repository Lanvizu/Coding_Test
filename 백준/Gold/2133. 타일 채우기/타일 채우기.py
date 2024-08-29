n = int(input())

dp = [0] * (n + 1)
if n>1:
    dp[2] = 3
if n > 3:
    dp[4] = 11

if n > 5:
    for i in range(6,n+1,2):
        dp[i] = dp[i-2]*4 -dp[i-4]


if n%2 !=0:
    print(0)
else:
    print(dp[n])