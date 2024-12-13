# N이 200000이라 엄청 큰 수인데 이를 전부 for 문 돌리면 1초만에 가능할까
# 키 벨류로 K 번 까지 유지되도록 해야하나
# 처음부터 마지막 까지 O(N) 은 1초 가능하지 않을까
# 예시) 3255644까지 들어간 후 5가 들어오면 k를 넘어가니 가장 앞에있는 5까지 빼서
# 56445 이렇게 처리되도록

import sys
input = sys.stdin.readline

N, K = map(int, input().split())
graph = list(map(int, input().split()))
result = []
dict_graph = {}
max_len = 0
for now in graph:
    if now not in dict_graph or now not in result:
        dict_graph[now] = 1
    else:
        if dict_graph[now] < K:
            dict_graph[now] += 1
        else:
            start = result.index(now)
            result = result[start+1:]
    result.append(now)
    max_len = max(len(result), max_len)
print(max_len)