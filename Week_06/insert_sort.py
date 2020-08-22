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