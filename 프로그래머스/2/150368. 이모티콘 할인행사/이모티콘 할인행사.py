total_cnt = 0
total = 0

def solution(users, emoticons):
    n = len(users)
    graph = [0] * n
    dfs(n,0,emoticons,users,graph, 0)
    answer = [total_cnt, total]
    return answer

def dfs(n, m, emoticons, users, graph, cnt):
    if m == len(emoticons):
        global total_cnt
        global total
        if total_cnt <= cnt:
            a = 0
            for graph_now in graph:
                if graph_now == -1:
                    continue
                a += graph_now
            if total_cnt < cnt:   
                total_cnt = cnt
                total = a
            else:
                total = max(a, total)
        return
    
    for i in range(1,5):
        copy_graph = graph.copy()
        result = emoticons[m] * (1 - (0.1 * i))
        n_cnt = 0
        for j in range(n):
            now = users[j]
            if now[0] <= (i * 10) and copy_graph[j] != -1:
                copy_graph[j] += result
            if copy_graph[j] >= now[1]:
                copy_graph[j] = -1
                n_cnt += 1
        dfs(n, m+1, emoticons, users, copy_graph, cnt + n_cnt)
                

