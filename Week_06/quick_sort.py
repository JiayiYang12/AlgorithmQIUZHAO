def quick_sort(a, begin, end):
    if begin >= end:
        return
    pivot = partition(a, begin, end)
    quick_sort(a, begin, pivot - 1)
    quick_sort(a, pivot + 1, end)

def partition(a, begin, end):
    mark = begin
    for i in range(begin+1, end+1):
        if a[i] < a[begin]:
            mark += 1
            a[i], a[mark] = a[mark], a[i]
    a[begin], a[mark] = a[mark], a[begin]
    return mark

# def partition(a, begin, end):
#     pivot = begin
#     lt, rt = begin + 1, end
#     while lt != rt:
#         while lt < rt and a[rt] > a[pivot]:
#             rt -= 1
#         a[rt], a[lt] = a[lt], a[rt]
#         while lt < rt and a[lt] < a[pivot]:
#             lt += 1
#         a[rt], a[lt] = a[lt], a[rt]
#     a[lt], a[pivot] = a[pivot], a[lt]
#     return lt

a = [3, 9, 0, 2, 6, 8, 1, 7, 4, 5]
quick_sort(a, 0, len(a) - 1)
print(a)
    

    
    