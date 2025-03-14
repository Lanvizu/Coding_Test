def solution(info, edges):
    l = len(info)
    graph = [[] for _ in range(l)]
    for a,b in edges:
        graph[a].append(b)
    result = []
    calc(0, [], [0], 0, 0, result, graph, info)
    answer = max(result)
    return answer

def calc(now, visited, ways, s, w, result, graph, info):
    visited.append(now)
    ways.remove(now)
    for g in graph[now]:
        ways.append(g)
    if info[now] == 0:
        s += 1
    else:
        w += 1
    
    result.append(s)
    po_visit = []
    for way in ways:
        if info[way] == 0 or s > w+1:
            po_visit.append(way)
            
    for nn in po_visit:
        calc(nn, visited, ways[:], s, w, result, graph, info)
    

# 스택으로 진행하자.
# 0 / 1
# 01 / 2, 4, 8
# 012/X
# 014/X
# 018/7,9
# 0187/2,4,9
# 01872/9
# 018729/10, 11, 4

# 01879465