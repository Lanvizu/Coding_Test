import sys

sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
graph = [ list(map(int, input().split())) for i in range(n)]

def dp(x, y, graph):
    if x == 0 and y == 0:
        return
    if x == 0 and y != 0:
        graph[x][y] += graph[x][y-1]
    elif x !=0 and y == 0:
        graph[x][y] += graph[x-1][y]
    else:
        sum_a = max(graph[x-1][y], graph[x][y-1])
        graph[x][y] += sum_a

for i in range(n):
    for j in range(m):
        dp(i,j,graph)

print(graph[n-1][m-1])