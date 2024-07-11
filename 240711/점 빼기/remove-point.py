from sortedcontainers import SortedSet

n,m = map(int,input().split())
s = SortedSet()

for i in range(n) :
    x,y = map(int,input().split())
    s.add((x,y))

for i in range(m) : 
    q = int(input())
    index = s.bisect_left((q,0))
    if index < len(s) :
        print(*s[s.bisect_left((q,0))])
        s.remove(s[s.bisect_left((q,0))])
    else :
        print("-1 -1")