import sys
input = sys.stdin.readline

N = int(input())
graph = {}
result = [0,'','',0]
for j in range(N):
    target = str(input().rstrip())
    M = len(target)
    a = target
    for i in range(M):
        if a not in graph:
            graph[a] = (target, j)
            a = a[:-1]
        else:
            if result[0] < len(a) and graph[a][0] != target:
                result = [len(a), graph[a][0], target, graph[a][1]]
                break
            if result[0] == len(a) and result[3] > graph[a][1]:
                result = [len(a), graph[a][0], target, graph[a][1]]
                break
                
print(result[1], result[2])