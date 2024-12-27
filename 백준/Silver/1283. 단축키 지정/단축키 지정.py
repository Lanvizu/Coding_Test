import sys
input = sys.stdin.readline
N = int(input())

word_list = {}
for _ in range(N):
    TF = False
    words = list(input().split(' '))
    words[-1] = words[-1].rstrip()
    for i in range(len(words)):
        n_word = words[i]
        if n_word[0] in word_list:
            continue
        word_list[n_word[0].upper()] = True
        word_list[n_word[0].lower()] = True
        words[i] = "[" + words[i][0] + "]" + words[i][1:]
        print(*words)
        TF = True
        break
    if not TF:
        for i in range(len(words)):
            if TF:
                break
            n_word = words[i]
            n_words = list(n_word)
            for j in range(len(n_words)):
                now = n_words[j]
                if now in word_list:
                    continue
                word_list[now.upper()] = True
                word_list[now.lower()] = True
                TF = True
                words[i] = words[i][:j] +"[" + words[i][j] + "]" + words[i][j+1:]
                print(*words)
                break
    if not TF:  
        print(*words)