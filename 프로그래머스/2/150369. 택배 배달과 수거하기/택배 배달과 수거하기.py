def solution(cap, n, deliveries, pickups):
    answer = 0
    d_cap , p_cap = 0, 0
    
    for i in range(n-1, -1, -1):
        n_d = deliveries[i]
        n_p = pickups[i]
        if (d_cap == 0 and n_d > 0) or (p_cap == 0 and n_p > 0):
            answer += (i+1)*2
            d_cap += cap
            p_cap += cap
        if d_cap >= n_d:
            d_cap -= n_d
        else:
            if (n_d - d_cap) % cap == 0:
                cnt = (n_d - d_cap) // cap
            else:
                cnt = (n_d - d_cap) // cap + 1
            d_cap += cap * cnt - n_d
            p_cap += cap * cnt
            answer += (i+1)*2*cnt
            
        if p_cap >= n_p:
            p_cap -= n_p
        else:
            if (n_p - p_cap) % cap == 0:
                cnt = (n_p - p_cap) // cap
            else:
                cnt = (n_p - p_cap) // cap + 1
            d_cap += cap * cnt
            p_cap += cap * cnt - n_p
            answer += (i+1)*2*cnt
    return answer