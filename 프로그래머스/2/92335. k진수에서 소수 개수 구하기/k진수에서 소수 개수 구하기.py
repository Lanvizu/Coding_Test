import math

def solution(n, k):
    result = []
    now = []
    answer = 0
    while n > 0:
        a = n % k
        n = n // k
        result.append(a)
    now = []
    for i in range(len(result)-1,-1,-1):
        if result[i] != 0:
            now.append(result[i])
        else:
            if now:
                target = int("".join(map(str, now)))
                if small_number(target):
                    answer += 1
                now = []
    if now:
        target = int("".join(map(str, now)))
        if small_number(target):
            answer += 1
    return answer

def small_number(a):
    if a == 1:
        return False
    b = int(math.sqrt(a))
    flag = True
    for i in range(2, b+1):
        if a % i == 0:
            flag = False
            break
    return flag