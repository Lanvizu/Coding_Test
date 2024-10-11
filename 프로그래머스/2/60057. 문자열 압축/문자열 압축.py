def solution(s):
    answer = len(s)
    for i in range(1,len(s)): # 압축하는 크기
        # i 씩 붙여서 배열 생성
        new_s = []
        for j in range(0, len(s), i): # i씩 증가해야함
            new_s.append(s[j:j+i])
        # 결과(result), 중복 횟수(count) 초기화
        result = ''
        count = 1
        # new_s를 순환
        for j in range(len(new_s)-1):
            now_s = new_s[j]
            if now_s == new_s[j+1]: # 다음 배열과 동일한 경우
                count += 1
            elif count != 1: # 중복이 끝난 경우
                result += str(count)
                result += now_s
                count = 1
            else: # 중복이 아닌 경우
                result += now_s
        # 마지막 배열 처리
        if count != 1:
                result += str(count)
                result += new_s[-1]
        else:
            result += new_s[-1]
        # 최소값으로 answer
        answer = min(answer, len(result))
    return answer