import sys
input = sys.stdin.readline
S = input().rstrip()
# 일단 한 단어에 대해서 뒤집는 함수 생성
def reverse(words):
    tar = list(words)
    output = []
    for i in range(len(tar)-1,-1,-1):
        output.append(tar[i])
    return output

def split_detail(words):
    # '<,>' 내부 여부 - 0 : 외부, 1 : 내부
    count = 0
    # 처리하는 부분 문자열
    subword = []
    # 전체 문자열
    result = []
    # '>' 로 끝나거나 elif 공백으로 끝나는 경우 result에 추가
    for i in range(len(words)):
        word = words[i]

        if word == '<':
            # 중간에 < 시작인 경우 처리
            if len(subword) != 0:
                sum_word = ''.join(subword)
                result.append(sum_word)
                subword = []
            # 처음인 경우 상태 변환
            count = 1
        # '<,>'외부 상태면서 공백인 경우 처리
        if (word == ' ' and count == 0):
            sum_word = ''.join(subword)
            result.append(sum_word)
            subword = []
        else:
            subword.append(word)
        # 내부 상태거나 마지막인 경우 처리
        if word == '>' or i == len(words) - 1:
            sum_word = ''.join(subword)
            result.append(sum_word)
            subword = []
            count = 0

    return result

result = split_detail(S)
answer = ''

for i in range(len(result)):
    word = result[i]
    # 내부인 경우 그대로 대입
    if word.startswith('<'):
        answer = ''.join([answer, word])
        continue
    # 외부인 경우 뒤집기 실행
    reverse_word = reverse(word)
    sum_word = ''.join(reverse_word)
    # 전체 단어의 시작이거나 외부 상태 시작인 경우 처리
    if answer.endswith('>') or i == 0:
        answer = ''.join([answer, sum_word])
    # 외부 + 외부인 경우 공백 추가
    else:
        answer = ''.join([answer, ' ', sum_word])

print(answer)
