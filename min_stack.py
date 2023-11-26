class ListNode:
    def __init__(self, x):
        self.value = x
        self.next = None

class MinStack:

    def __init__(self):
        self.head=None
        self.min=[]
        

    def push(self, val: int) -> None:
        if not self.head:
            self.head=ListNode(val)
            self.min.append(val)
        else:
            new_node=ListNode(val)
            new_node.next=self.head
            self.head=new_node
            if val<=self.min[-1]:
                self.min.append(val)
        

    def pop(self) -> None:
        if self.head.value==self.min[-1]:
            self.min.pop()
        self.head=self.head.next
        
        

    def top(self) -> int:
        curr_top=self.head
        return curr_top.value
        

    def getMin(self) -> int:
        if self.min:
            return self.min[-1]
            
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-1)
print(obj.getMin())
obj.pop()
print(obj.top())
print(obj.getMin())