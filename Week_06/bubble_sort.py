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
            