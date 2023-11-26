class Solution:
    def moveZeroes(self, nums) -> None:
        i=z=0
        arr_len=len(nums)
        while i<arr_len-z-1:
            if nums[i]==0:
                z+=1
                nums.append(nums.pop(i)) ## slicing and pop won't work because whenever you slice it's a different array
            else:
                i+=1

        