def backTracking(visited, selected, depth, n, m):
    if depth == m:
        print(' '.join(map(str, selected)))
        return

    for i in range(1, n+1):
        if not visited[i]:
            visited[i] = True
            selected[depth] = i
            backTracking(visited, selected, depth+1, n, m)
            visited[i] = False

n, m = map(int, input().split())
selected = [0] * m
visited = [False] * (n + 1)

backTracking(visited, selected, 0, n, m)