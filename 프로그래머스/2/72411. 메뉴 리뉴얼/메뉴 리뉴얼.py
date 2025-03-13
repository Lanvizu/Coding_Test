from collections import defaultdict

def solution(orders, course):
    answer = []
    dd = {}
    for order in orders:
        insert(dd, order)

    grouped = {}
    for key, value in dd.items():
        length = len(key)
        if length in course:
            grouped.setdefault(length, []).append((key, value))

    result = {}

    #각 길이 그룹에 대해 value>1인 항목 중 최대 value를 갖는 키(들)를 추출
    for length, items in grouped.items():
    # value가 1보다 큰 항목만 선택
        filtered = [(k, v) for k, v in items if v > 1]
        if not filtered:
            continue # 해당 길이 그룹 내에 value>1인 항목이 없으면 건너뜀
        # 최대 value 찾기
        max_val = max(v for _, v in filtered)
        # 최대 value와 동일한 value를 가진 키 모두 선택 (여러 개일 경우)
        max_keys = [k for k, v in filtered if v == max_val]

        result[length] = (max_val, max_keys)
    for n in result:
        r = result[n][1]
        for a in r:
            answer.append(str(a))
    answer.sort()
    return answer

def insert(dd, order):
    result = []
    order = list(map(str, order.strip()))
    order.sort()
    for o in order:
        target = result.copy()
        for t in target:
            result.append(str(t+o))
        result.append(o)
    for r in result:
        if len(r) == 1:
            continue
        if r in dd:
            dd[r] += 1
        else:
            dd[r] = 1