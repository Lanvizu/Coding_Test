import sys
input = sys.stdin.readline

N = int(input())

graph = [list(input()[:N]) for _ in range(N)]

heart_xy = [-1,-1]
for i in range(N-1):
    for j in range(N-1):
        # 심장이 있는 행
        if (graph[i][j] == graph[i][j+1]) and (graph[i][j] == graph[i+1][j]) and (graph[i][j] == '*'):
            heart_xy = [i+1, j+1]
            break

left_arm_count = 0
for i in range(heart_xy[1]-2, -1,-1):
    if graph[heart_xy[0]-1][i] == '*':
        left_arm_count += 1
    else:
        break

right_arm_count = 0
for i in range(heart_xy[1], N):
    if graph[heart_xy[0]-1][i] == '*':
        right_arm_count += 1
    else:
        break

waist_count = 0
for i in range(heart_xy[0], N):
    if graph[i][heart_xy[1]-1] == '*':
        waist_count += 1
    else:
        break


left_leg_count = 0
right_leg_count = 0
for i in range(heart_xy[0]-1 + waist_count+1, N):
    if graph[i][heart_xy[1]-2] == '*':
        left_leg_count += 1
    if graph[i][heart_xy[1]] == '*':
        right_leg_count += 1

print(*heart_xy)
print(left_arm_count, right_arm_count, waist_count, left_leg_count, right_leg_count)