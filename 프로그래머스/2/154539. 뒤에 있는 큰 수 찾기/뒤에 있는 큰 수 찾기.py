from collections import deque
def solution(numbers):
    answer = [-1]*len(numbers)
    # max_n = numbers[-1]
    stk = deque()
    stk.append(numbers[-1])
    for i in range(len(numbers)-2,-1,-1):
        now = numbers[i]
        while stk:
            tar = stk.pop()
            if now < tar:
                answer[i] = tar
                stk.append(tar)
                break
        stk.append(now)
    return answer