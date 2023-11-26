class Solution:
    def countBits(self, n: int):
        bits=[0]
        for i in range(1,n+1):
            if i%2==1:
                bits.append(bits[int(i/2)]+1)
            else:
                bits.append(bits[int(i/2)])
        return bits

# 76ms - my personal best on this problem
# my personal dynamic programming problem

# the above even shorter
# class Solution:
#     def countBits(self, n: int) -> List[int]:
#         bits=[0]
#         for i in range(1,n+1):
#                 bits.append(bits[int(i/2)]+i%2)
#         return bits


            
# Submitted nlogn solution ~300ms

# class Solution:
#     def countBits(self, n: int) -> List[int]:
#         one_list=[0]
#         for i in range(1,n+1):
#             q=i
#             bits=[]
#             while q>0:
#                 r=q%2
#                 bits.append(r)
#                 q=int(q/2)
            
#             one_list.append(bits.count(1))

#         return one_list       
         
# my improved solution  ~150 ms half as before
# class Solution:
#     def countBits(self, n: int) -> List[int]:
#         if n==0:
#             return [0]
#         elif n==1:
#             return [0,1]
#         else:
#             one_list=[0,1]
#             bits={0:[0],1:[1]}
#             for i in range(2,n+1):
#                 q=i
#                 r=q%2
#                 bits[q]=[r]
#                 bits[q].extend(bits[int(q/2)])
                
#                 one_list.append(bits[i].count(1))

#             return one_list
    
    #Cleaner Solution
# class Solution:
#     def countBits(self, n: int) -> List[int]:
#         one_list=[0]
#         bits={0:[0]}
#         for i in range(1,n+1):
#             q=i
#             r=q%2
#             bits[q]=[r]
#             bits[q].extend(bits[int(q/2)])
                
#             one_list.append(bits[i].count(1))

#         return one_list