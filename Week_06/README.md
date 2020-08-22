# 学习笔记
## 各种排序算法的实现
### 归并算法
```python
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
    while lt <= mid and rt <= end:
        if a[lt] < a[rt]:
            tmp.append(a[lt])
            lt += 1
        else:
            tmp.append(a[rt])
            rt += 1
    while lt <= mid:
        tmp.append(a[lt])
        lt += 1
    while rt <= end:
        tmp.append(a[rt])
        rt += 1
    a[begin: end+1] = tmp

a = [3, 9, 0, 2, 6, 8, 1, 7, 4, 5]
mergesort(a, 0, len(a) - 1)
print(a)
```
### 快速排序
```python
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
```
### 堆排序
```python
def heapify(parent_ind, n, nums):
    child_ind = 2 * parent_ind + 1
    tmp = nums[parent_ind]
    while child_ind < n:
        if child_ind + 1 < n and nums[child_ind] < nums[child_ind + 1]:
            child_ind = child_ind + 1
        if tmp > nums[child_ind]:
            break
        nums[parent_ind] = nums[child_ind]
        parent_ind = child_ind
        child_ind = 2 * parent_ind + 1
    nums[parent_ind] = tmp

def heapsort(nums):
    # build heap
    for i in range((len(nums) - 2) //2, -1, -1):
        heapify(i, len(nums), nums)
    for i in range(len(nums) - 1, -1, -1):
        nums[0], nums[i] = nums[i], nums[0]
        heapify(0, i, nums)
        
    
a = [3, 9, 0, 2, 6, 8, 1, 7, 4, 5]
heapsort(a)
print(a)
```
### 冒泡排序
```python
def bubblesort(nums):
    n = len(nums)
    j = 0
    for i in range(1, n):
        for j in range(0, n-i):
            if nums[j] > nums[j+1]:
                nums[j], nums[j+1] = nums[j+1], nums[j]

a = [3, 9, 0, 2, 6, 8, 1, 7, 4, 5]
bubblesort(a)
print(a)
```
### 选择排序
```python
import sys
def selectsort(nums):
    max_ind = 0
    n = len(nums)
    for i in range(n):
        _max = -sys.maxsize - 1
        for j in range(0, n - i):
            if nums[j] > _max:
                _max = nums[j]
                max_ind = j
        nums[n - i - 1], nums[max_ind] = _max, nums[n - i - 1]
        
a = [3, 9, 0, 2, 6, 8, 1, 7, 4, 5]
selectsort(a)
print(a)
```
### 插入排序
```python
def insertsort(nums):
    n = len(nums)
    for i in range(n - 1):
        for j in range(n-1, i, -1):
            k = j
            while k > 0 and nums[k] < nums[k-1]:
                nums[k], nums[k-1] = nums[k-1], nums[k]
                k -= 1
                
a = [3, 9, 0, 2, 6, 8, 1, 7, 4, 5]
insertsort(a)
print(a)
```