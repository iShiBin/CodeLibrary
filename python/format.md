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

### Solution 1: Brute force. O(n^2)
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
Note: Second submit succeeded. So the running time in leetcode varies.

### Solution 2: One time pass using collections.defaultdict(). O(n)
```python
class Solution:
    def pathSum(self, root, target):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        def traverse(root, running_sum):
    
            if not root:
                return 0
            count = 0
            running_sum += root.val
            count += d[running_sum - target]
            d[running_sum] +=1 
            count += traverse(root.left, running_sum) + traverse(root.right, running_sum)
            d[running_sum] -=1 
            return count
        d = collections.defaultdict(int)
        d[0] = 1
        return traverse(root, 0)
```

