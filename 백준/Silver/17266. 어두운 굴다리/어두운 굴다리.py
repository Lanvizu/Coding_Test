# 0과 N 에서 가장 가까운 가로등의 길이 a1,a2
# 가로등 사이 가장 긴 경우 a3
# a1,a2,a3 중 가장 긴 길이 -> answer
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
graph = list(map(int,input().split()))
a1 = graph[0] - 0
a2 = N - graph[M-1]
max_length = max(a1,a2)
for i in range(M-1):
    length = graph[i+1]-graph[i]
    length = length // 2 + 1 if length % 2 != 0 else length // 2
    if max_length >= length:
        continue
    max_length = length
print(max_length)
