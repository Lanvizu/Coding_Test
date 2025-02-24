def solution(edges):
    answer = [0, 0, 0, 0]
    graph = {}
    for a, b in edges:
        if not graph.get(a):
            graph[a] = [0,0]
        if not graph.get(b):
            graph[b] = [0,0]
        graph[a][0] += 1
        graph[b][1] += 1
    for c, d in graph.items():
        if d[0] >= 2 and d[1] == 0:
            answer[0] = c
        if d[0] == 0 and d[1] > 0:
            answer[2] += 1
        if d[0] >= 2 and d[1] >= 2:
            answer[3] += 1
    answer[1] = graph[answer[0]][0] - answer[2] - answer[3]
        
        
    return answer