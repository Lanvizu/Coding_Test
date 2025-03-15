import heapq

def solution(n, s, a, b, fares):
    answer = int(1e9)
    graph = [[0] * (n+1) for _ in range(n+1)]
    for x,y,cost in fares:
        graph[x][y] = cost
        graph[y][x] = cost
    result = dijkstra_1(s, n, graph)
    
    for i in range(1, n+1):
        if result[i] == int(1e9):
            continue
        result_ab = dijkstra_2(i, a, b, n, graph)
        answer = min(answer, result[i] + result_ab)
    return answer
# start 지점이 들어왔을 때 a와 b 로 가는 최소를 만들어보자.

def dijkstra_1(start, n, graph):
    distance = [int(1e9)] * (n+1)
    q = []
    heapq.heappush(q, (0,start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in range(1, n+1):
            if graph[now][i] == 0 or now == i:
                continue
            cost = dist + graph[now][i]
            if distance[i] > cost:
                distance[i] = cost
                heapq.heappush(q, (cost, i))
                
    return distance

def dijkstra_2(start, a, b, n, graph):
    distance = [int(1e9)] * (n+1)
    q = []
    heapq.heappush(q, (0,start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in range(1, n+1):
            if graph[now][i] == 0 or now == i:
                continue
            cost = dist + graph[now][i]
            if distance[i] > cost:
                distance[i] = cost
                heapq.heappush(q, (cost, i))
    return distance[a] + distance[b]