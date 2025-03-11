import bisect
from collections import defaultdict

def solution(info, query):
    answer = []
    people = defaultdict(list)
    for i in info:
        i = i.split()
        for lang in [i[0], '-']:
            for job in [i[1], '-']:
                for career in [i[2], '-']:
                    for food in [i[3], '-']:
                        people[(lang,job,career,food)].append(int(i[4]))
    for key in people:
        people[key].sort()
        
    for q in query:
        q = q.split()
        tmp = people[(q[0], q[2], q[4], q[6])]
        cnt = bisect.bisect_left(tmp,int(q[7]))
        answer.append(len(tmp) - cnt)
        
    return answer