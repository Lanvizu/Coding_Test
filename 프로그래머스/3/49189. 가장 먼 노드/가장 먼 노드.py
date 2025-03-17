import heapq

def solution(n, edge):
    graph = [[] * (n+1) for _ in range(n+1)]
    for a,b in edge:
        graph[a].append(b)
        graph[b].append(a)
    result = dijkstra_1(n, graph)
    max_result = 0
    answer = 0
    for i in range(2,n+1):
        if max_result < result[i]:
            max_result = result[i]
            answer = 1
        elif max_result == result[i]:
            answer += 1
    return answer

def dijkstra_1(n, graph):
    distance = [int(1e9)] * (n+1)
    distance[1] = 0
    q = []
    heapq.heappush(q,(0,1))
    while q:
        dis, now = heapq.heappop(q)
        for next in graph[now]:
            if distance[next] <= dis + 1:
                continue
            distance[next] = dis + 1
            heapq.heappush(q,(dis + 1, next))
    return distance
        
# 다익스트라를 사용할건데 1번 노드를 기준