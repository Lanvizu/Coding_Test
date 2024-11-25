# 1번 사람의 위치는 정해진다.
# 순차적으로 2번 사람 위치도 고정아닌가
import sys
input = sys.stdin.readline

N = int(input())
graph = list(map(int,input().split()))
target = [i for i in range(N)]
result = [-1] * N
for i in range(N):
    now_count = graph[i]
    target[now_count]
    target_now = target.pop(now_count)
    result[target_now] = i+1
print(*result)