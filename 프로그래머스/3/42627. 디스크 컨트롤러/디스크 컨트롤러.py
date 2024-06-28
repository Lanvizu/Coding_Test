from heapq import heappush, heappop, heapify

def solution(jobs):
    answer = 0
    hq = []
    l_j = len(jobs)
    heapify(jobs)
    jobs.sort(key=lambda x : (x[0],x[1]))

    s, t = jobs.pop(0)
    heappush(hq, [t, s])
    now = s
    
    while hq:      
        t, s = heappop(hq)
        if now < s:
            answer += t
            now = s + t
        else:
            answer += now + t - s
            now = now + t
        if not hq:
            flag = True
        while jobs:
            js, jt = heappop(jobs)

            if now < js:
                if flag == True:
                    heappush(hq, [jt, js]) 
                    break
                else:
                    heappush(jobs, [js,jt])
                    break
            else : 
                heappush(hq, [jt, js])
                flag = False
                
            
    return answer // l_j