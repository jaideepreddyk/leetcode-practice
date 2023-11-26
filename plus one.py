class Solution:
    def plusOne(self, digits):
        last=digits.pop()
        cnt=0
        last=last+1
        if last<=9:
            digits.append(last)
        else:
            while last>9:
                cnt=cnt+1
                try:
                    last=digits.pop()
                    last=last+1
                except:
                    last=1
            
            digits.append(last)
            for i in range(cnt):
                digits.append(0)
        
        return digits

