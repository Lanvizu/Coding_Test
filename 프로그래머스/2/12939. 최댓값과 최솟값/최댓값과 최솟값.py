def solution(s):
    inputs = list(map(int, s.split(" ")))
    min_s = min(inputs)
    max_s = max(inputs)
    answer = str(min_s) + " " + str(max_s)
    return answer 