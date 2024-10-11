import numpy as np

def solution(key, lock):
    answer = False
    N = len(lock)
    M = len(key)
    # key를 zeropadding
    pad = N-1 
    # 예시 lock : 4, key : 3일때 lock의 최소 한칸에는 key 가 닿아야하므로 
    # key의 한칸 + zeroPadding 3칸 = 4칸이 lock에 적용되는 부분
    tot_pad = M + (pad * 2)
    # 중앙에 key를 두고 zeroPadding으로 채우는 방식
    new_key = [[0] * (tot_pad) for _ in range(tot_pad)]
    # pad ~ pad+len(key) 2 ~ 5
    for i in range(pad,pad+M):
        for j in range(pad,pad+M):
            new_key[i][j] = key[i-pad][j-pad]
    
    # 90, 180, 270도 회전
    key_1 = np.rot90(new_key,1)
    key_2 = np.rot90(new_key,2)
    key_3 = np.rot90(new_key,3)
    list_key = [new_key, key_1, key_2, key_3]
    
    for key_now in list_key:
        # new_key에서 N(lock 크기)로 맞춰서 진행
        for i in range(M+pad):
            for j in range(M+pad):
                # i ~ i+N
                # j ~ j+N 을 만들어서 sumKL에 넣는다.
                key_ex = [[0]*N for _ in range(N)]
                for a in range(N):
                    for b in range(N):
                        key_ex[a][b] = key_now[a+i][b+j]
                
                if sumKL(key_ex, lock):
                    answer = True
                    break
    return answer

# 동일한 크기의 2차원 배열에 대해서
# 각각의 index가 모두 동일하지 않은 경우에만 True
def sumKL(new_key, lock):
    global answer
    N = len(lock)
    for i in range(N):
        for j in range(N):
            if new_key[i][j] == lock[i][j]:
                return False
    return True
            
            
                    
        