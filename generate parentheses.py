class Solution:
    def generateParenthesis(n: int):
        
        # THIS IS AS WRONG AS WRONG THINGS CAN GET. MY RECENT SOLUTION IN JAVA IS CORRECT. I'VE IMPROVED!!!
        #keep the opening parantheses constant
        #play with the order of closing parantheses
        #keep closing paranthsis in the outer loop
        
        par_list=[]
        for c_par in range(1,n+1):
            par_str=""
            for o_par in range(n):
                par_str+="("
                if c_par==len(par_str):
                    par_str+=")"
            par_str=par_str+"))"
            par_list.append(par_str)
        
        
        return par_list
            
if __name__ == "__main__":
    print(Solution.generateParenthesis(3))
                

            
        