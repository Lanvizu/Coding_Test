def solution(info, n, m):
    graph = [[False] * m for _ in range(n)]
    graph[0][0] = True
    for now in info:
        next = [[False] * m for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if graph[i][j]:
                    if i + now[0] < n:
                        next[i+now[0]][j] = True
                    if j + now[1] < m:
                        next[i][j + now[1]] = True
        graph = next
    answer = -1
    for i in range(n):
        for j in range(m):
            if graph[i][j]:
                answer = i
                break
        if answer != -1:
            break
    return answer