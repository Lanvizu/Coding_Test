import sys
import heapq

input = sys.stdin.readline
N = int(input())

q = list(map(int, input().split()))
heapq.heapify(q)

for i in range(N-1):
    graph = list(map(int, input().split()))
    for now in graph:
        if now > q[0]:
            heapq.heapreplace(q, now)
print(q[0])