import sys
input = sys.stdin.readline
N = int(input())
for i in range(N):
    result = []
    count = 0
    graph = list(map(int, input().split()))
    result.append(graph[1])
    for j in range(2,len(graph)):
        target = graph[j]
        for k in range(len(result)):
            if result[k] > target:
                result.insert(k, target)
                count += len(result) - k - 1
                break
            if k == len(result) - 1:
                result.append(target)
    print(graph[0], count)
    