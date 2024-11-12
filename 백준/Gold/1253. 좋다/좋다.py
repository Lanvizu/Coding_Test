import sys
input = sys.stdin.readline

N = int(input())
graph = list(map(int, input().split()))
graph.sort()

count = 0
for i in range(N):
    now = graph[i]
    j = 0
    k = N - 1
    while j < k:
        if j == i:
            j += 1
            continue
        if k == i:
            k -= 1
            continue
        a = graph[j]
        b = graph[k]
        if a + b == now:
            count += 1
            break
        if a+b > now:
            k -= 1
        else:
            j += 1
        
print(count)
