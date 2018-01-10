You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

<pre>
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
</pre>

### Solution 1: Time Limit Exceed on case 126/126
```python
class Solution:
    counter = 0
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        if root:
            self.traverse(root, sum)
            self.pathSum(root.left, sum)
            self.pathSum(root.right, sum)
        return self.counter
        
    def traverse(self, root, sum):
        if root:
            if sum == root.val: self.counter += 1
            self.traverse(root.left, sum-root.val)
            self.traverse(root.right, sum-root.val)
```
