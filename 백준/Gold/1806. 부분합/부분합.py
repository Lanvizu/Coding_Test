import sys
input = sys.stdin.readline

N, S = map(int, input().split())
graph = list(map(int, input().split()))

left = 0
current_sum = 0
min_len = float('inf')

for right in range(N):
    current_sum += graph[right]
    while current_sum >= S:
        min_len = min(min_len, right - left + 1)
        current_sum -= graph[left]
        left += 1

print(0 if min_len == float('inf') else min_len)