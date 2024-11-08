import sys
input = sys.stdin.readline

N, C = map(int, input().split())

graph = [int(input()) for _ in range(N)]
graph.sort()

start, end = 1, graph[-1]-graph[0]

while start <= end:
    current = graph[0]
    count = 1
    mid = (start + end) // 2
    for i in range(N):
        if graph[i] >= mid + current:
            count += 1
            current = graph[i]
    
    if count < C:
        end = mid - 1
    else:
        start = mid + 1
        result = mid
print(result)