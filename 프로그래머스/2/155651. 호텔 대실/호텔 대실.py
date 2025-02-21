def solution(book_time):
    sb = sorted(book_time)
    room = []
    for now in sb:
        room.sort()
        flx = False
        for i in range(len(room)):
            tar = room[i]
            if splitTime(tar[0]) + 10 <= splitTime(now[0]):
                room[i][0] = now[1]
                flx = True
                break
        if not flx:
            room.append([now[1],now[0]])
            
    answer = len(room)
    return answer

def splitTime(time_str):
    hours, minutes = map(int, time_str.split(":"))
    return hours * 60 + minutes