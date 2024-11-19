import sys
input = sys.stdin.readline

N, X = map(int, input().split())
graph = list(map(int, input().split()))
now_sum = 0
for i in range(N-1,N-1-X, -1):
    now_sum += graph[i]
    
max_sum = now_sum
max_day = 1
i = N-1-X

while i >= 0:
    now_sum = now_sum - graph.pop() + graph[i]
    if max_sum == now_sum:
        max_day += 1
    elif max_sum < now_sum:
        max_sum = now_sum
        max_day = 1
    i -= 1

if max_sum == 0:
    print('SAD')
else:
    print(max_sum)
    print(max_day)