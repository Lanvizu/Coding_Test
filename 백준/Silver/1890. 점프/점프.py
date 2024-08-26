import sys

n = int(input())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dp = [[0] * n for _ in range(n)]
dx = [0,1]
dy = [1,0]

dp[0][0] = 1

for i in range(n):
    for j in range(n):
        if i == n - 1 and j == n - 1:
            print(dp[i][j])
        now = graph[i][j]
        if now != 0:
            for k in range(2):
                x = i + now * dx[k] 
                y = j + now * dy[k]
                if x < n and y < n:
                    dp[x][y] += dp[i][j]
