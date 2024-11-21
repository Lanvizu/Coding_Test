# 3 7 5 2 6 1 4
# 오름 차순 배열 중 가장 긴 경우의 수를 구한다?
# 8 9 5 6 7 1 2 3 4
# 1234가 가장 긴 오름차순 배열이므로
# 1234를 기준으로 나머지를 옮긴다
# 1 5 2 6 3 7 4 8 9
# 1 2 3 4 8 9 을 기준으로 오름차순 배열
# 나머지 5 6 7 이동
# 그럼 가장 긴 오름차순 배열의 길이를 어떻게 구하나
#1 5 6 7 8 9 -> 나머지 2 3 4 이동
# 뒤에서 부터 오름차순 길이 추가
# 6 5 5 4 4 3 3 2 1

# 3 7 5 2 6 1 4
# 3 1 2 2 1 2 1 

# 기준 수보다 큰 수에 대해서 가장 긴 값 + 1 해 현재 값 업데이트

import sys
input = sys.stdin.readline

N = int(input())

graph = []
for _ in range(N):
    graph.append(int(input()))

graph_count = [1] * N
graph_count[N-1] = 1

def cal(index):
    max_count = 1
    now = graph[index]
    for i in range(index+1, N):
        target = graph[i]
        if now > target:
            continue
        if max_count < graph_count[i] + 1:
            max_count = graph_count[i] + 1
            graph_count[index] = max_count
    return max_count

max_total = 1
for i in range(N-2, -1, -1):
    max_total = max(max_total, cal(i))
# print(graph_count)
print(N - max_total)
