from typing import final


class Solution:
    def letterCombinations(self, digits: str):
        phone_dict={'2':['a','b','c'],
                    '3':['d','e','f'],
                    '4':['g','h','i'],
                    '5':['j','k','l'],
                    '6':['m','n','o'],
                    '7':['p','q','r','s'],
                    '8':['t','u','v'],
                    '9':['w','x','y','z']}
        
        n=0
        final_list=[]
        while n<len(digits):
            if final_list:
                temp_list=final_list
                final_list=[]
                for i in temp_list:
                    for j in phone_dict[digits[n]]:
                        final_list.append(i+j)
            else:
                final_list.extend(phone_dict[digits[n]])
            
            n=n+1
        
        return final_list





# Solution:
#run a while loop : while stuff in digits
#keep appending each to the final list 
# the next digit will make combos with contents of final list

