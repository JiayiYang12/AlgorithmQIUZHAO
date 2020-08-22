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