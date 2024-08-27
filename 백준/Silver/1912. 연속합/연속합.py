import sys

n = int(input())
graph = list(map(int, sys.stdin.readline().split()))

# 한 번의 for 문을 사용하자
for i in range(1, n):
    graph[i] = max(graph[i-1] + graph[i], graph[i])

print(max(graph))