def solution(players, m, k):
    answer = 0
    onS = [0]*24
    for i in range(24):
        np = players[i]
        if np <= (onS[i] + 1) * m - 1:
            continue
        more = (np - ((onS[i] + 1) * m - 1))
        if more % m > 0:
            plS = more // m + 1
        else:
            plS = more // m
        for j in range(i, i+k):
            if j > 23:
                break
            onS[j] += plS
        answer += plS
    return answer