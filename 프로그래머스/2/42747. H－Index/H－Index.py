def solution(citations):
    citations.sort()
    size = len(citations)
    answer = 0
    for i in range(size):
        n = citations[i]
        now = size - i
        if now > n:
            answer = max(answer, n)
        elif now == n and i <= now:
            answer = max(answer, n)
            break
        elif now < n and i <= n-1:
            answer = max(now, answer)
            break
    
    return answer