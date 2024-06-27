def solution(genres, plays):
    dict = {}
    n = len(genres)
    for i in range(n):
        genr = genres[i]
        play = plays[i]
        if dict.get(genr) == None:
            dict[genr] = [play, i,-1]
        else:
            dict[genr][0] += play
            if plays[dict[genr][1]] < play:
                dict[genr][2] = dict[genr][1]
                dict[genr][1] = i
            elif dict[genr][2] == -1 or plays[dict[genr][2]] < play:
                dict[genr][2] = i
        
    answer = []
    while len(dict)>0:
        max_genre = max(dict, key=lambda x:dict[x][0])
        answer.append(dict[max_genre][1])
        sec = dict[max_genre][2]
        if sec != -1:
            answer.append(sec)
        del dict[max_genre]
        
    return answer