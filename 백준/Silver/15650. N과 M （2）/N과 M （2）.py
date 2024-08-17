def backTracking(now, n, m, selected, depth):
    if depth == m:
        print(*selected)
        return

    else:
        for i in range(now + 1, n+1):
            selected[depth] = i
            backTracking(i, n, m, selected, depth + 1)

n, m = map(int, input().split())
selected = [0] * m

backTracking(0, n, m, selected,0)
