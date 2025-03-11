import bisect
from collections import defaultdict

def solution(info, query):
  answer = []
  # defaultdict: key에 해당하는 값이 없을 경우 자동으로 빈 리스트([])를 생성
  people = defaultdict(list)

  # 지원자 정보(info)를 순회하며 각 정보에 대해 가능한 모든 조건 조합을 딕셔너리에 저장
  # - 각 속성마다 '-'를 포함한 경우의 수를 모두 고려하여 key로 사용
  for i in info:
      i = i.split()
      for lang in [i[0], '-']:
          for job in [i[1], '-']:
              for career in [i[2], '-']:
                  for food in [i[3], '-']:
                      # key: (언어, 직군, 경력, 소울푸드) / value: 해당 지원자의 점수(정수형)
                      people[(lang, job, career, food)].append(int(i[4]))

  # 모든 key에 대해, 점수 리스트를 오름차순 정렬
  # 이후 쿼리 처리 시 이진 탐색(bisect)을 사용해 효율적으로 점수 조건을 확인할 수 있음
  for key in people:
      people[key].sort()

  # 각 쿼리(query)별로 조건에 맞는 지원자 수를 계산
  for q in query:
      q = q.split()
      # 쿼리 조건은 "and" 키워드가 포함, 실제 속성 정보는 인덱스 0, 2, 4, 6에 있음
      # 해당 key에 대응하는 지원자들의 점수 리스트를 tmp 변수에 저장
      tmp = people[(q[0], q[2], q[4], q[6])]

      # bisect_left: int(q[7]) (점수 조건) 이상의 값이 처음으로 등장하는 인덱스를 찾음
      # 이후 (리스트 길이 - 찾은 인덱스)를 계산하면 조건을 만족하는 지원자 수가 됨
      cnt = bisect.bisect_left(tmp, int(q[7]))
      answer.append(len(tmp) - cnt)

  return answer