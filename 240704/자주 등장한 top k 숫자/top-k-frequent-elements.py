from heapq import heappop, heappush

n,k = map(int,input().split())
arr = list(map(int,input().split()))

ndict = {}

for el in arr : 
    if el in ndict :
        ndict[el] +=1
    else :
        ndict[el] = 1


heap = []

for key in ndict:
    heappush(heap,(-ndict[key],-key))

for i in range(k) : 
    value, key = heappop(heap)
    print(-key, end = " ")