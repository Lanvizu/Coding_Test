import sys
input = sys.stdin.readline

N, M, L, K = map(int, input().split())
star = []
for i in range(K):
    star.append(list(map(int,input().split())))

star.sort(key=lambda x:(x[0],x[1]))

# 왼쪽 꼭짓점을 각 별에 대해서 지정하여
# 트램펄린 내부의 별의 개수를 최대로 업데이트
# start를 정렬하고 
# 최대 K^2이니까 괜찮지 않을까 -> 실패.

# 0 * 0
# * 0 *
# 0 * 0
# 해당 예시는 꼭짓점 배치가 실패하는 경우.

# 시작하는 선분을 정해야할듯. 가로와 세로 두 가지로
total = 0

for i in range(K): # 가로선
    N_x,N_y = star[i]
    for j in range(K): # 세로선
        M_x,M_y = star[j]
        if 0 <= M_x-N_x <= L and 0 <= N_y-M_y <= L:
            nx,ny = N_x,M_y
            mx,my = nx+L,ny+L  
            cnt = 0
            for k in range(i, K):
                tx,ty = star[k]
                if nx <= tx <= mx and ny <= ty <= my:
                    cnt += 1
                elif tx > mx:
                    break
            total = max(cnt, total)
print(K-total)