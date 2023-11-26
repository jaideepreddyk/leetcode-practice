class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinaryTree(object):
    def __init__(self, root):
        self.root = Node(root)

    def search(self, find_val):
        """Return True if the value
        is in the tree, return
        False otherwise."""
        if self.preorder_search(self.root,find_val):
            return True
        else:
            return False

    def print_tree(self):
        """Print out all tree nodes
        as they are visited in
        a pre-order traversal."""
        return self.preorder_print(self.root)

    def preorder_search(self, start, find_val):
        """Helper method - use this to create a
        recursive search solution."""
        if start.value==find_val:
            return True
        elif start.left and self.preorder_search(start.left,find_val):
            return True
        elif start.right and self.preorder_search(start.right,find_val):
            return True
        else:
            return False

    def preorder_print(self, start):
        """Helper method - use this to create a
        recursive print solution."""
        if start.value is None:
            pass
        else:
            print(start.value)
        if start.left:
            self.preorder_print(start.left)
        if start.right:
            self.preorder_print(start.right)

tree = BinaryTree(1)
tree.root.left = Node(2)
tree.root.right = Node(3)
tree.root.left.left = Node(4)
tree.root.left.right = Node(5)

print(tree.search(4))
print(tree.search(6))

print(tree.print_tree())

