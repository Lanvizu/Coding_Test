result = []
c_result = []

def solution(dice):
    n = len(dice)
    combo(0,n,[])
    m = len(result)
    maxResult = 0
    maxDice = []
    for i in range(m//2):
        a = result[i]
        b = result[m -i -1]
        ra, rb = cal(dice, a, b)
        if ra > maxResult:
            maxResult = ra
            maxDice = a
        if rb > maxResult:
            maxResult = rb
            maxDice = b
    answer = []
    for i in maxDice:
        answer.append(i+1)
    return answer

def combo(start, n, now):
    if len(now) == n//2:
        result.append(now)
        return
    for i in range(start, n):
        combo(i + 1, n, now + [i])
        
def total_sum(dice, a, n, targets):
    if n == len(a):
        return targets
    now = dice[a[n]]
    new_targets = {}
    for c in now:
        if not targets:
            new_targets[c] = new_targets.get(c,0) + 1
        else:
            for b,cnt in targets.items():
                s = c + b
                new_targets[s] = new_targets.get(s,0) + cnt
    return total_sum(dice, a, n+1, new_targets)
    
def cal(dice, a, b):
    aSum = total_sum(dice, a, 0, {})
    bSum = total_sum(dice, b, 0, {})
    a_keys = sorted(aSum.keys())
    b_keys = sorted(bSum.keys())
    
    ra, rb = 0, 0
    cum_b = 0
    j = 0
    for s_a in a_keys:
        while j < len(b_keys) and b_keys[j] < s_a:
            cum_b += bSum[b_keys[j]]
            j+=1
        ra += aSum[s_a] * cum_b
    
    cum_a = 0
    i = 0
    for s_b in b_keys:
        while i < len(a_keys) and a_keys[i] < s_b:
            cum_a += aSum[a_keys[i]]
            i+=1
        rb += bSum[s_b] * cum_a
    return [ra, rb]
    
# 예를 들어 n=2 인 경우는 0~1
# 4 -> 0~2 + 1~3
# 6 -> 0~3 + 1~4 + 2~5

    
# 6 ^ 10 전부를 돌게되면 6백만 -> 단순 그리디는 아니고
# 두 개라고 가정하자
# 주사위 마다 최소, 최대를 저장해놓자? 인덱스 비교하면되지 (정렬 필수)
# 1번 주사위가 이기는 경우의 수 -> 1:0, 2:0, 3:0, 4:4, 5:6, 6:6 -> 16 
# 2번 주사위가 이기는 경우의 수 -> 3:2, 3:2, 3:2, 3:2, 4:3, 4:3 -> 14
# 1번이 베스트

# 주사위 n/2를 선택했을 때 전체 경우의 수를 계산 key value로?
# 총 2개의 key value가 생성 -> 최대 36가지 
# 5개면 7776 한 쪽만 구해도 알수있지않나