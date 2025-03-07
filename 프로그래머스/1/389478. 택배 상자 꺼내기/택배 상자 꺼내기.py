def solution(n, w, num):
    answer = 0
    graph = [[0]*w for _ in range((n//w)+1)]
    now = 0
    for i in range(n):
        if (i // w) % 2 == 0:
            graph[i//w][i%w] = i+1
            if i+1 == num:
                b = i%w
        else:
            graph[i//w][w-(i%w)-1] = i+1   
            if i+1 == num:
                b = w-(i%w)-1
        if i+1 == num:
            a = i//w
    
    while len(graph) > a:
        if graph[a][b] != 0:
            answer += 1
        a += 1
            
    return answer