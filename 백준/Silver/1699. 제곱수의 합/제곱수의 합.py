from sys import stdin

n = int(stdin.readline())

dp = [i for i in range(n+1)]

dp[0] = 0

for i in range(1,n+1):
    
    for j in range(1,int(i**(1/2))+1):
          
        dp[i] = min(dp[i],dp[i-(j*j)]+1)

print(dp[n])