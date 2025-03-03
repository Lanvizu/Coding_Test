def solution(fees, records):
    graph = {}
    answer = []
    result = {}
    for i in range(len(records)):
        now = records[i].split(" ")
        if now[1] in graph:
            a = graph[now[1]].split(":")
            b = now[0].split(":")
            in_time = int(a[0])*60 + int(a[1])
            out_time = int(b[0])*60 + int(b[1])
            total_time = out_time - in_time
            result[now[1]] = result.get(now[1], 0) + total_time
            graph.pop(now[1])
        else:
            graph[now[1]] = now[0]
    for now in graph:
        a = graph[now].split(":")
        b = [23, 59]
        in_time = int(a[0])*60 + int(a[1])
        out_time = b[0]*60 + b[1]
        total_time = out_time - in_time
        result[now] = result.get(now, 0) + total_time
        
    r_keys = sorted(result.keys())
    for now_keys in r_keys:
        answer.append(calc(fees, result[now_keys]))
    return answer

def calc(fees,tt):
    result = fees[1]
    if tt <= fees[0]:
        return result
    else:
        if (tt - fees[0]) % fees[2] > 0:
            result += ((tt - fees[0]) // fees[2] + 1) * fees[3]
        else:
            result += ((tt - fees[0]) // fees[2]) * fees[3]
        return result
            