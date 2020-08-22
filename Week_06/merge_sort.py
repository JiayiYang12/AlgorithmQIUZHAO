def mergesort(a, begin, end):
    if begin >= end:
        return
    mid = (begin + end) >> 1
    mergesort(a, begin, mid)
    mergesort(a, mid+1, end)
    merge(a, begin, mid, end)

def merge(a, begin, mid, end):
    lt, rt = begin, mid + 1
    tmp = []
    while lt <= mid or rt <= end:
        if rt > end or (lt <=mid and a[lt] <= a[rt]):
            tmp.append(a[lt])
            lt += 1
        else:
            tmp.append(a[rt])
            rt += 1
            
    a[begin: end+1] = tmp

a = [3, 9, 0, 2, 6, 8, 1, 7, 4, 5]
mergesort(a, 0, len(a) - 1)
print(a)