class Solution:
    def threeSum(self, nums) :
        sum_list=[]
        for i in range(len(nums)-2):
            j=i+1
            while j<len(nums)-1:
                for k in range(j+1,len(nums)):
                    if nums[i]+nums[j]+nums[k]==0:
                        mini_list=[nums[i],nums[j],nums[k]]
                        mini_list.sort()
                        if mini_list not in sum_list:
                            sum_list.append(mini_list)
                        else:
                            pass
                    else:
                        continue
                j=j+1
        
        return sum_list

# definitely faster, but still not fast enough
class Solution:
    def threeSum(self, nums) :
        sum_list=[]
        for i in range(len(nums)-2):
            j=i+1
            while j<len(nums)-1:
                k=-(nums[i]+nums[j])
                if k in nums[j+1:]:
                    mini_list=[nums[i],nums[j],k]
                    mini_list.sort()
                    if mini_list not in sum_list:
                        sum_list.append(mini_list)
                j=j+1
                
        
        return sum_list       
    

    # FINDING PATTERN
    # because the sum of mini_list must be zero
    # hold first, cycle through list for second AND third i.e. sum of those two must be negative of first (or zero)
    
    ## Order of execution:
    ### for-loop to control i
    ### while-loop with len(sum_list)<3 (might not be need if 'break' in k??) or j not reached end of the list
    ### j is controlled by while loop above (j=j+1) at the end
    ### for-loop to control k and 'if' to break out of the loop when sum zero

    ## new updates:to improve speed
    ### based on i and j, we know if -(nums[i]+nums[j]) in k list, then append, else break.
        