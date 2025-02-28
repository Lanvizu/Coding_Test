from collections import deque

def solution(queue1, queue2):
    answer = 0
    s1 = sum(queue1)
    s2 = sum(queue2)
    state = False
    if (s1+s2) % 2 == 0:
        q1 = deque()
        q2 = deque()
        for i in range(len(queue1)):
            q1.append([queue1[i],0])
            q2.append([queue2[i],0])
        
        while q1 and q2:
            if s1 > s2:
                a = q1.popleft()
                if a[1] >= 2:
                    break
                q2.append([a[0],a[1]+1])
                s1 -= a[0]
                s2 += a[0]
                answer += 1
            elif s2 > s1:
                b = q2.popleft()
                if b[1] >= 2:
                    break
                q1.append([b[0], b[1]+1])
                s2 -= b[0]
                s1 += b[0]
                answer += 1
            else:
                state = True
                break
    if not state:
        answer = -1
    return answer

