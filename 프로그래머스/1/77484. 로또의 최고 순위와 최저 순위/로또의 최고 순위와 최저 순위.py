def solution(lottos, win_nums):
    answer = []
    lottos.sort()
    win_nums.sort()
    cnt_0 = 0
    cnt = 0
    for now in lottos:
        if now == 0:
            cnt_0 += 1
        else:
            for target in win_nums:
                if now == target:
                    cnt += 1
                    break
                elif now < target:
                    break
    cnt = 7 - cnt
    if cnt - cnt_0 > 6:
        answer.append(6)
    else:
        answer.append(cnt - cnt_0)
    if cnt < 6:
        answer.append(cnt)
    else:
        answer.append(6)
                    
    return answer