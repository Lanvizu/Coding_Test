def solution(rows, columns, queries):
    answer = []
    graph = [[i * columns + j + 1 for j in range(columns)] for i in range(rows)]
    for now in queries:   
        answer.append(rotation(now, graph))
    return answer

def rotation(q, graph):
    # q = [2,2,5,4]
    
    tmp = graph[q[0]-1][q[1]-1]
    result = tmp
    for i in range(q[1],q[3]):
        target = tmp
        tmp = graph[q[0]-1][i]
        graph[q[0]-1][i] = target
        result = min(result, tmp)
    
    for i in range(q[0],q[2]):
        target = tmp
        tmp = graph[i][q[3]-1]
        graph[i][q[3]-1] = target
        result = min(result, tmp)
        
    for i in range(q[3]-2,q[1]-2,-1):
        target = tmp
        tmp = graph[q[2]-1][i]
        graph[q[2]-1][i] = target
        result = min(result, tmp)
        
    for i in range(q[2]-2,q[0]-2,-1):
        target = tmp
        tmp = graph[i][q[1]-1]
        graph[i][q[1]-1] = target
        result = min(result, tmp)
        
    return result