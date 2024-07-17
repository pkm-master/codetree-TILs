from heapq import heappush, heappop

N, T = map(int,input().split())
h = []

for i in range(N) :
    st, v = map(int,input().split())
    heappush(h,(v*T+st,-st))

gn = 0
global_max_st = -1

for i in range(N):
    new_dist, new_st = heappop(h)
    if -new_st > global_max_st : 
        gn += 1
        global_max_st = -new_st

print(gn)