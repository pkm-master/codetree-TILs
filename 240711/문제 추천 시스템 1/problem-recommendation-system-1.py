from sortedcontainers import SortedSet

n = int(input())
s = SortedSet()
for i in range(n) : 
    p,l = map(int,input().split())
    s.add((l,p))

m = int(input())
for i in range(m) : 
    method = input().split()
    if method[0] == "rc" : 
        if method[1] == "1" :
            print(s[-1][1])
        else : 
            print(s[0][1])
    elif method[0] == "ad" :
        s.add(tuple(map(int,(method[2],method[1]))))
    else :
        s.remove(tuple(map(int,(method[2],method[1]))))