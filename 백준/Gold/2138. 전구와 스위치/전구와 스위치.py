# 0번째 전구에 따라 이후 값이 고정되는 것을 빠르게 파악해야함.

import sys
input = sys.stdin.readline

N = int(input())

start = list(map(int,input().rstrip()))
end = list(map(int,input().rstrip()))
total_count = 0

def TF(graph_now):
    TF_graph = []
    for i in range(N):
        if graph_now[i] == 0:
            TF_graph.append(False)
        else:
            TF_graph.append(True)
    return TF_graph

TF_graph = TF(start)
end_graph = TF(end)

def switch(TF_graph, count):
    for i in range(1, N-1):
        if TF_graph[i-1] != end_graph[i-1]:
            count += 1
            for j in range(i-1, i+2):
                TF_graph[j] = not TF_graph[j]
    # 마지막 전구 처리
    if TF_graph[N-1] != end_graph[N-1]:
        count += 1
        TF_graph[N-2] = not TF_graph[N-2]
        TF_graph[N-1] = not TF_graph[N-1]
    if TF_graph == end_graph:
        return count
    else:
        return -1

# 0번째 스위치를 누른 경우
TF_graph_0 = TF_graph.copy()
TF_graph_0[0] = not TF_graph_0[0]
TF_graph_0[1] = not TF_graph_0[1]

if TF_graph == end_graph:
    print(0)
else:
    count = switch(TF_graph,0)
    if count != -1:
        print(count)
    else:
        count = switch(TF_graph_0,1)
        print(count if count != -1 else -1)
    