while (1):
    word = str(input())
    if word == 'end':
        break
    acceptable = False
    word_list = list(word)
    case1 = ['a','e','i','o','u']
    count = 0
    status = 0
    for i in range(len(word_list)):
        now_word = word_list[i]
        if i < len(word_list) - 1:
            next_word = word_list[i+1]
            # 규칙 3 - 연속적으로 두 번 오는 경우
            if (now_word == next_word) and (now_word not in ['e','o']):
                acceptable = False
                break
        # 규칙 1 - 하나라도 존재하면 통과
        if now_word in case1:
            acceptable = True
            if status == 0:
                count += 1
            else:
                status = 0
                count = 1
        else:
            if status == 1:
                count += 1
            else:
                status = 1
                count = 1
        if count >= 3:
            acceptable = False
            break

    if acceptable:
        print('<'+word+'> is acceptable.')
    else:
        print('<'+word+'> is not acceptable.')