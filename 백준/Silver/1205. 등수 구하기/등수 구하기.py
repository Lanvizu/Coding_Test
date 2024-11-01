import sys
input = sys.stdin.readline

N, score, P = map(int, input().split())
if N > 0:
    score_list = list(map(int, input().split()))
    # 초기 점수 초기화
    if N < P:
        score_index =  N + 1
    else:
        score_index = -1
    for i in range(N):
        # 태수 점수가 낮을 경우
        if score_list[i] > score:
            continue
        # 점수 갱신 후 종료
        score_index = i+1
        break
    # 리스트가 전부 찼는 경우 and 꼴등과 태수 점수가 같은 경우 예외 처리
    if N == P and score_list[N-1] == score:
        score_index = -1

    print(score_index)
else:
    print(1)

