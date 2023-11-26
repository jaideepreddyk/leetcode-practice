class Solution:
    def maxProfit(self, prices) -> int:
        profit_1,profit_2,profit_3=0,0,0
        max_pos=prices.index(max(prices))
        min_pos=prices.index(min(prices))

        if max_pos>min_pos:
            return prices[max_pos]-prices[min_pos]

        if max_pos<min_pos:
            if max_pos>0:
                subarr=prices[0:max_pos+1]
                profit_1=max(subarr)-min(subarr)
            if min_pos<len(prices)-1:
                subarr=prices[min_pos:]
                profit_2=max(subarr)-min(subarr)
            rem_arr=prices[max_pos+1:min_pos]
            if len(rem_arr)>1:
                profit_3=self.maxProfit(rem_arr)
            
        return max([profit_1,profit_2,profit_3])
            

s=Solution()
print(s.maxProfit([7,6,4,3,1]))
        
        ##use max(arr) and min(arr)
        ## nothing can be greater than max
        ## and nothing less than min
        ## first check min pos and max pos
        
        # BASE CHECK
        ## if min pos greater than max pos = we have winner!
        
        ## shouldn't sort
        ## looks like RECURSIVE???? steps below:
        
        ## do max(subarr) where subarr=arr[min_pos:] then max-min
        ## do min(subarr) where subarr=arr[0:max_pos] then max-min
        ## recursive call maxProfile(arr[max_pos:min_pos])
        ## always return max of all three outputs
        