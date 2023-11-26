# Dynamic Programming Solution

class Solution:
    def climbStairs(self, n) :
        dp={}
        dp[1]=1
        dp[2]=2

        if n>=3:
            for i in range(3,n+1):
                dp[i]=dp[i-1]+ dp[i-2]
        
        return dp[n]

s=Solution()
print(s.climbStairs(6))



# My original failed solution

# class Solution:
#     def climbStairs(self, n) :
#         ways=1
#         num_list=[1 for x in range(n)]

#         if n%2==0:
#             while len(num_list)>((n/2)+1):
#                 num_list.remove(1)
#                 num_list.remove(1)
#                 num_list.append(2)
#                 ways=ways+self.combo_counter(num_list)
#             return ways+1
#         else:
#             while len(num_list)>((n/2)+1):
#                 num_list.remove(1)
#                 num_list.remove(1)
#                 num_list.append(2)
#                 ways=ways+self.combo_counter(num_list)
#             return ways

#     def combo_counter(self,num=[]):
#         combo_list=[]
#         combo_list.append(num.copy())
#         while True:
#             num.append(num.pop(0))
#             if num in combo_list:
#                 break
#             else:
#                 combo_list.append(num.copy())
#         print(combo_list)
#         return len(combo_list)
            

# s=Solution()
# print(s.climbStairs(6))

#print(s.combo_counter([1, 1, 1, 2, 1]))

## note: must do odd and even seperation
## the above method is total rubbish (check for 6)

## update: 07/27 
## try queue(enque and deque)
## use remove(1) remove(1) and append(2) combos 
