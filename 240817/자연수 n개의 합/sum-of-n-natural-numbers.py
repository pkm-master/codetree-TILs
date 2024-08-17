n = int(input())

st = 0
end = n
ans = 0

while st<=end : 
    mid = (st+end)//2
    if (mid*(mid+1))//2 <= n :
        ans = max(ans,mid)
        st = mid + 1
    else :
        end = mid - 1

print(ans)