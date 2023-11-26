class Solution:
    def maxArea(self, height=[]):
        max_area=0
        curr_i=0
        j=len(height)-1
        for i in range(len(height)):
            if i>0 and height[i]<=height[curr_i]:
                continue
            else:
                curr_i=i
                pass
            
            while j>i:
                width=j-i
                h=min(height[i],height[j])
                area=width*h
                if area>max_area:
                    max_area=area
                
                if height[i]>=height[j]:
                    pass
                else:
                    break
                
                curr_j=j
                while j>i:
                    j=j-1
                    if height[j]<=height[curr_j]:
                        continue
                    else:
                        break
        return max_area

s=Solution()
print(s.maxArea([10,9,8,7,6,5,4,3,2,1]))

        