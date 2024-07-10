from sortedcontainers import SortedSet

n,m  = map(int,input().split())
s = SortedSet()
for i in range(n):
    s.add(tuple(map(int,input().split())))

for i in range(m):
    index = s.bisect_left(tuple(map(int,input().split())))
    if index >= n :
        print ("-1 -1")
    else : 
        ans = s[index]
        print(*ans)