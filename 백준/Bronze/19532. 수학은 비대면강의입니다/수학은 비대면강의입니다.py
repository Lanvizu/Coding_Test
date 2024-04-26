a, b, c, d, e, f = map(int, input().split())


found = False
AX, AY = 0, 0
for x in range(-999, 1000):
  for y in range(-999, 1000):
    if a*x+b*y == c and d*x+e*y == f:
      found = True
      AX, AY = x, y
      break
print(AX, AY)