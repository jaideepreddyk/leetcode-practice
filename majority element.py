from typing import Counter


class Solution:
    def majorityElement(self, nums) -> int:
        num_dict={}
        for i in nums:
            if i in num_dict:
                num_dict[i]=num_dict[i]+1
            else:
                num_dict[i]=1
        
        # major_num=max(num_dict.values())
        # return list(num_dict.keys())[list(num_dict.values()).index(major_num)]
        return max(num_dict,key=num_dict.get)

### Boyer-Moore Voting Algorithm

class Solution:
    def majorityElement(self, nums) -> int:
        major_num=nums.pop(0)
        count=1
        for i in nums:
            if count==0:
                major_num=i
            if i==major_num:
                count+=1
            else:
                count=count-1
        
        return major_num

        