import numpy as np

def solution(key, lock):
    answer = False
    N = len(lock)
    M = len(key)
    # key를 zeropadding
    pad = N-1
    tot_pad = M + (pad * 2)
    new_key = [[0] * (tot_pad) for _ in range(tot_pad)]
    # pad ~ pad+len(key) 2~ 5
    for i in range(pad,pad+M):
        for j in range(pad,pad+M):
            new_key[i][j] = key[i-pad][j-pad]
    # print(new_key)
    # 90도 씩 3번 돌리기
    key_1 = np.rot90(new_key,1)
    key_2 = np.rot90(new_key,2)
    key_3 = np.rot90(new_key,3)
    list_key = [new_key, key_1, key_2, key_3]
    # print(key_1)
    for key_now in list_key:
        # new_key에 대해서 N크기로 나눠서 넣기
        for i in range(M+pad):
            for j in range(M+pad):
                # i ~ i+N
                # j~j+N 를 만들어서 sumKL에 넣는다.
                key_ex = [[0]*N for _ in range(N)]
                for a in range(N):
                    for b in range(N):
                        key_ex[a][b] = key_now[a+i][b+j]
                if sumKL(key_ex, lock):
                    print(key_ex, lock)
                    answer = True
                    break
    return answer

def sumKL(new_key, lock):
    global answer
    N = len(lock)
    # print(new_key, lock)
    for i in range(N):
        for j in range(N):
            if new_key[i][j] == lock[i][j]:
                return False
    return True
            
            
                    
        