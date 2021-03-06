/**
 * Implement a binary tree.
 * @author Bin.S
 * @date 2017-11-08
 * 
 * @history
 * 2017-11-08: persist on the static implementation
 */
package tree;
import java.util.*;

public class BinaryTree extends TreeNode {
  
  /**
   * Build a tree from an input string
   * @param input: a tree like [3, 1, 8, null,10, null, null]
   * <quote> https://leetcode.com/playground/new/binary-tree
   */
  public static TreeNode buildTree(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return null;
    }

    String[] parts = input.split(",");
    String item = parts[0];
    TreeNode root = new TreeNode(Integer.parseInt(item));
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    int index = 1;
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int leftNumber = Integer.parseInt(item);
        node.left = new TreeNode(leftNumber);
        nodeQueue.add(node.left);
      }

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int rightNumber = Integer.parseInt(item);
        node.right = new TreeNode(rightNumber);
        nodeQueue.add(node.right);
      }
    }
    return root;
  }
  
  /**Generate a binary tree from an array
   * @param array
   * @return a balanced binary tree
   */
  public static TreeNode buildTree(int[] array){
    return BinarySearchTree.buildMinBST(array);
  }


  /**
   * Traverse the binary tree in preorder and return the list of nodes.
   * Note: The null nodes are not included.
   * @param root
   * @return
   */
  public static List<TreeNode> traversePreorder(TreeNode root){
    List<TreeNode> list=new LinkedList<>();
    traversePreorder(root, list);
    return list;
  }
  
  private static void traversePreorder(TreeNode root, List<TreeNode> list){
    if(root==null) return;
    list.add(root);
    traversePreorder(root.left,list);
    traversePreorder(root.right,list);
  }
  
  /**
   * Iterative solution: For recursion, we use implicit stack. So here to
   * convert recursive solution to iterative, we will use explicit stack. Steps
   * for iterative solution:
   * 
   * Create empty stack and pust root node to it. Do the following when stack is
   * not empty Pop a node from stack and print it Push right child of popped
   * node to stack Push left child of popped node to stack
   * 
   * @param root
   * @return
   */
  public static List<TreeNode> traversePreorderIterativly(TreeNode root){
    if(root==null) return null;
    
    List<TreeNode> list=new LinkedList<>();
    Stack<TreeNode> stack=new Stack<>();
    stack.push(root);
    
    while(!stack.isEmpty()){
      TreeNode node=stack.pop();
      list.add(node);
      if(node.right!=null) stack.push(node.right);
      if(node.left!=null) stack.push(node.left);
    }
    return list;
  }
  
  /**
   * PostOrder traversal:
   * 
   * In PostOrder traversal, each node is processed after subtrees traversal.In
   * simpler words,Visit left subtree, right subtree and then node. Steps for
   * PostOrder traversal are: Traverse the left subtree in PostOrder. Traverse
   * the right subtree in PostOrder. Visit the node.
   * 
   * @param root
   * @return
   */
  public static List<TreeNode> traversePostorder(TreeNode root){
    List<TreeNode> list = new LinkedList<>();
    traversePostorder(root, list);
    return list;
  }
  
  private static void traversePostorder(TreeNode root, List<TreeNode> list){
    if(root==null) return;
    traversePostorder(root.left, list);
    traversePostorder(root.right, list);
    list.add(root);
  }
  
  /**
   * InOrder traversal:
   * 
   * In InOrder traversal,each node is processed between subtrees.In simpler
   * words,Visit left subtree, node and then right subtree. Steps for InOrder
   * traversal are: Traverse the left subtree in InOrder. Visit the node.
   * Traverse the right subtree in InOrder.
   * 
   * @param root
   * @return
   */
  public static List<TreeNode> traverseInorder(TreeNode root){
    List<TreeNode> list=new LinkedList<>();
    traverseInorder(root, list);
    return list;
  }
  //note: the performance is almost the same using a parameter or a global variable.
  private static void traverseInorder(TreeNode root, List<TreeNode> list){
    if(root==null) return;
    traverseInorder(root.left, list);//don't miss list
    list.add(root);
    traverseInorder(root.right, list);
  }
  
  /**
   * sometimes, just want to do it iteratively. :)
   * @param root
   * @return
   */
  public List<Integer> traverseInorderIteratively(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<TreeNode>();

    while (root != null) {
      stack.push(root);
      root = root.left;
    }

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      list.add(node.val);
      if (node.right != null) {
        TreeNode temp = node.right;
        while (temp != null) {
          stack.push(temp);
          temp = temp.left;
        }
      }
    }
    return list;
  }

  /**
   * This algorithm is very similar to breadth first search of graph. Steps for
   * Level order traversal algorithm:
   * 
   * Create empty queue and pust root node to it. Do the following when queue is
   * not empty Pop a node from queue and print it Push left child of popped node
   * to queue if not null Push right child of popped node to queue if not null
   * 
   * @param root
   * @return
   */
  public static List<TreeNode> traverseInLevel(TreeNode root){
    List<TreeNode> list=new LinkedList<>();
    
    Queue<TreeNode> queue=new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
      TreeNode node=queue.poll();
      list.add(node);
      if(node.left!=null) queue.add(node.left);
      if(node.right!=null) queue.add(node.right);
    }
    return list;
  }
  
  /**
   * Get all the levels and stored in a List<List<TreeNode>>.
   * @param root
   * @return
   */
  private static LinkedList<List<TreeNode>> getLevelsAll(TreeNode root){
    LinkedList<List<TreeNode>> list=new LinkedList<>();
    getLevelsAll(root,0,list, true);
    return list;
  }
  
  private static void getLevelsAll(TreeNode root, int level, List<List<TreeNode>> list, boolean includeNull){
    
    if(!includeNull && root==null) return;
    
    if(list.size()==level){
      List<TreeNode> l=new ArrayList<>();
      l.add(root);
      list.add(l);
    }else{
      list.get(level).add(root);
    }
    
    if(root!=null) getLevelsAll(root.left,level+1,list,includeNull);
    if(root!=null) getLevelsAll(root.right,level+1,list,includeNull);
  }
  
  /**
   * Sometimes, we just don't want the last level if all its elements are null.
   */
  public static List<List<TreeNode>> getLevelsReal(TreeNode root){
    LinkedList<List<TreeNode>> list=getLevelsAll(root);
    List<TreeNode> lastLevel=list.getLast();
    if(isAllNull(lastLevel)) list.removeLast();
    return list;
  }
  private static boolean isAllNull(List<TreeNode> list){
    for(TreeNode node: list){
      if(node!=null) return false;
    }
    return true;
  }
  
  /**
   * Common used. Normally we just don't need the null value in the levels.
   */
  public static List<List<TreeNode>> getLevelsNoNull(TreeNode root){
    LinkedList<List<TreeNode>> list=new LinkedList<>();
    getLevelsAll(root,0,list, false);
    return list;
  }
  
  /**
   * Spiral/Zigzag Level Order traversal: 
   * Assuming the root level is 0, when the level%2==1, reverse the list of that level.
   * @param root
   * @return
   */
  public static List<List<TreeNode>> traverseZipzap(TreeNode root){
    List<List<TreeNode>> levelList = getLevelsReal(root);
    for(int i=0;i<levelList.size();i++){
      if(i%2==1){
        Collections.reverse(levelList.get(i));
      }
    }
    return levelList;
  }

//  get a string representing all the nodes in level traverse order
  public static String toString(TreeNode root) {
    if (root.left == null && root.right == null) {
      return "[" + root.val + "]";
    } else {
      List<List<TreeNode>> levels = getLevelsAll(root);
      List<TreeNode> list = new ArrayList<>();
      int start = 0, end = levels.size() - 1;
      if (isLastLevelNull(root))
        end -= 1;
      for (int i = start; i <= end; i++) {
        list.addAll(levels.get(i));
      }
      return list.toString();
    }
  }
  
  //return to a string even the last level is all null
  public String getStringAll(TreeNode root) {
    String output = "";
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (node == null) {
        output += "null, ";
        continue;
      }

      output += String.valueOf(node.val) + ", ";
      nodeQueue.add(node.left);
      nodeQueue.add(node.right);
    }
    return "[" + output.substring(0, output.length() - 2) + "]";
  }
  
  private static boolean isLastLevelNull(TreeNode root){
    List<List<TreeNode>> list = getLevelsAll(root);
    List<TreeNode> l=list.get(list.size()-1);
    for(TreeNode node: l){
      if(node!=null) return false;
    }
    return true;
  }

/*  how Leetcode print a tree. not very pretty. */
  private static void printTree(TreeNode node, String prefix, boolean isLeft) {
    if (node == null) {
      System.out.println("Empty tree");
      return;
    }

    if (node.right != null) {
      printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);

    if (node.left != null) {
      printTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
    }
  }

  public static void print(TreeNode root) {
    printTree(root, "", true);
  }
  
  /**
   * To judge whether two binary tree are the same.
   * <link> https://leetcode.com/problems/same-tree/description/
   * @param root1
   * @param root2
   * @return True if yes; False if no.
   */
  public static boolean isIdentical(TreeNode root1, TreeNode root2){
    if(root1==root2) return true;
    if(root1==null ^ root2==null) return false;
    return (root1.val==root2.val) &&
        BinaryTree.isIdentical(root1.left, root2.left) &&
        BinaryTree.isIdentical(root1.right, root2.right);
  }
  /**
   * Judge whether two trees have the same data structure.
   * @param root
   * @param another
   * @return
   */
  public static boolean hasSameStructure(TreeNode root, TreeNode another){
	  if(root == another || (root==null && another==null) ) return true;
	  else if (root==null || another ==null) return false;
	  else return hasSameStructure(root.left, another.left)
			      && hasSameStructure(root.right, root.right);
  }
  
  public static void simplePrint(TreeNode root) {
    simplePrint(root, 0);
  }

  private static void simplePrint(TreeNode root, int indent) {
    for (int i = 0; i < indent; i++) {
      System.out.print("   ");
    }
    if (root == null) {
      System.out.println("null");
      return;
    }
    System.out.println(root.val);
    if (isLeaf(root))
      return;
    simplePrint(root.left, indent + 1);
    simplePrint(root.right, indent + 1);
  }
  
  public static boolean isLeaf(TreeNode node){
    return node.left==null && node.right==null;
  }
  
  /**
   * Invert a binary tree. https://leetcode.com/problems/invert-binary-tree/description/
   * Input:
     4
   /   \
  2     7
 / \   / \
1   3 6   9

  * Output:
     4
   /   \
  7     2
 / \   / \
9   6 3   1
   * @param root
   * @return a reverted binary tree.
   */
  public static TreeNode invert(TreeNode root) {
    if (root != null) {
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      invert(root.left);
      invert(root.right);
    }
    return root;
  }
  
  /**
   * Check whether two trees are mirrored.
   * <link> https://leetcode.com/problems/symmetric-tree/solution/
   * @param t1
   * @param t2
   * @return
   */
  public static boolean isMirrored(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val) && isMirrored(t1.right, t2.left) && isMirrored(t1.left, t2.right);
  }
  
  /**
   * A sibling is one of two or more individuals having one or both parents in common.
   * A full sibling is a first-degree relative. A male sibling is a brother, and a female sibling is a sister.
   * @param root
   * @param node1
   * @param node2
   * @return
   */
  public static boolean areSiblings(TreeNode root, TreeNode node1, TreeNode node2) {
    if (root == null)
      return false;
    return root.left == node1 && root.right == node2 || root.right == node1 && root.left == node2
        || areSiblings(root.left, node1, node2) || areSiblings(root.right, node1, node2);
  }
  
  /**
   * Two nodes are cousins only if their parents are siblings.
   * @param root
   * @param node1
   * @param node2
   * @return
   */
  public static boolean areCousins(TreeNode root, TreeNode node1, TreeNode node2) {
    return areSiblings(root, getParent(root, node1), getParent(root, node2));
  }
  
  /**
   * Find the parent of a node.
   * @param root
   * @param node
   * @return node's parent or null
   */
  public static TreeNode getParent(TreeNode root, TreeNode node){
    if(root==null || node==null) return null;
    
    if(root.left==node || root.right==node) return root;
    else {
      TreeNode parent = getParent(root.left, node);
      return parent!=null?parent:getParent(root.right, node);
    }
  }
  
  /**
   * Boundary of Binary Tree
   * <link> https://leetcode.com/problems/boundary-of-binary-tree/description/
   * @param args
   */
  public static List<TreeNode> getBoundary(TreeNode root){
    LinkedList<TreeNode> leftBoundary=getBoundaryLeft(root);
    LinkedList<TreeNode> leaves=getLeaves(root);
    LinkedList<TreeNode> rightBoundary=getBoundaryRight(root);
    
    List<TreeNode> list=leftBoundary;
    if(leaves!=null && leaves.getFirst()==leftBoundary.getLast()){
      leaves.removeFirst();
    }
    if(!leaves.isEmpty()) list.addAll(leaves);
    
    rightBoundary.removeFirst();//remove the root node because it is already in the leftBoundary
    if(!rightBoundary.isEmpty() && rightBoundary.getLast()==leaves.getLast()){
      rightBoundary.removeLast();
    }
    if(!rightBoundary.isEmpty()){
      Collections.reverse(rightBoundary);
      list.addAll(rightBoundary);
    }
    return list;
  }
  
  public static LinkedList<TreeNode> getBoundaryLeft(TreeNode root){
    LinkedList<TreeNode> list = new LinkedList<>();
    if (root != null) {
      list.add(root);
      root = root.left;
    }
    while (root != null) {
      list.add(root);
      if (root.left != null) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return list;
  }
  
  public static LinkedList<TreeNode> getBoundaryRight(TreeNode root) {
    LinkedList<TreeNode> list = new LinkedList<>();
    if (root != null) {
      list.add(root);
      root = root.right;
    }
    while (root != null) {
      list.add(root);
      if (root.right != null) {
        root = root.right;
      } else {
        root = root.left;
      }
    }
    return list;
  }
  
  public static LinkedList<TreeNode> getLeaves(TreeNode root){
    LinkedList<TreeNode> list=new LinkedList<>();
    getLeaves(root, list);
    return list;
  }
  
  private static void getLeaves(TreeNode root, List<TreeNode> list){
    if(root==null) return;
    if(root.left==null && root.right==null) list.add(root);
    getLeaves(root.left,list);
    getLeaves(root.right,list);
  }
  
  /**
   * Lowest Common Ancestor of a Binary Tree
   * <link> https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
   * @param root
   * @param t1
   * @param t2
   * @return
   */
  //assume t1 and t2 are all the subtree of root. otherwise, need to scan first.
  public static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2){
    if (root == null || root == t1 || root == t2) return root;
    TreeNode left = getLowestCommonAncestor(root.left, t1, t2);
    TreeNode right = getLowestCommonAncestor(root.right, t1, t2);
    
    return left == null ? right : right == null ? left : root;
    /* the logic of above code equals the following:
    if(left==null) return right;
    else if(right==null) return left;
    else return root;
    */
  }
  
  
  /** TOP-DOWN RECURSION
   * Another way to get the path of a tree, which just use one method.
   * The efficiency is however not high.
   * <link> https://leetcode.com/problems/path-sum-ii/description/
   * @param root
   * @return
   */
  public static List<List<TreeNode>> getRootToLeafPaths(TreeNode root){
    List<List<TreeNode>> list=new LinkedList<>();
    if(root==null) return list;
    else if(root.left==null && root.right==null){
      List<TreeNode> l=new LinkedList<>();
      l.add(root);
      list.add(l);
    } else {
      List<List<TreeNode>> left= getRootToLeafPaths(root.left);
      List<List<TreeNode>> right= getRootToLeafPaths(root.right);
      
      for(List<TreeNode> l: left){
        l.add(0, root);
        list.add(l);
      }
      
      for(List<TreeNode> l: right){
        l.add(0, root);
        list.add(l);
      }
    }
    return list;
  }
  
  /**
   * Binary Tree Paths from the root to leaf.
   * <link> https://leetcode.com/problems/binary-tree-paths/description/
   * @param root
   * @return all root-to-leaf paths in a linked list.
   */
  
  public static List<LinkedList<TreeNode>> getPaths(TreeNode root){
    List<LinkedList<TreeNode>> pathList=new LinkedList<>();
    if(root==null) return pathList;
    getToLeafPaths(root, new LinkedList<>(), pathList);
    return pathList;
  }
  
  /**
   * Help function to backtrack and get the recursions.
   * @param root
   * @param path
   * @param pathList
   */
  private static void getToLeafPaths(TreeNode root, LinkedList<TreeNode> path, List<LinkedList<TreeNode>> pathList) {
    if (root == null)
      return;

    path.add(root);

    if (root.left == null && root.right == null) {
   // need to create a new list and then add
      pathList.add(new LinkedList<TreeNode>(path));
    }
    getToLeafPaths(root.left, path, pathList);
    getToLeafPaths(root.right, path, pathList);
    path.removeLast();// remove the last node after one recursion!
  }
  
  @Deprecated //Because of low efficiency to frequently 'new' objects 
  private static void getPaths(TreeNode root, LinkedList<TreeNode> path, List<LinkedList<TreeNode>> pathList){
    path.add(root);
    
    if(root.left==null && root.right==null){
      pathList.add(new LinkedList<TreeNode>(path));//need to create a new list and then add
      return ;
    }
    
    //create a new list for each sub-path.
    if(root.left!=null) getPaths(root.left, new LinkedList<TreeNode>(path), pathList); //low efficiency
    if(root.right!=null) getPaths(root.right, new LinkedList<TreeNode>(path), pathList); //low efficiency
  }

  /**
   * Get the path from the root to leaf which has the max sum.
   * @param root
   * @return
   */
  public static List<TreeNode> getMaxSumPath(TreeNode root){
    List<TreeNode> max=new ArrayList<>(), temp=new ArrayList<>();
    long[] sums=new long[2];
    getMaxSumPath(root, max, temp, sums);
    return max; 
  }
  
  /**
   * Recursion: Calculate the path with max sum value
   * @param root: the root of the binary tree
   * @param max: the path of max sum 
   * @param temp: a temp list of the current recursion
   * @param sums: sums[0] - the sum of temp list; sum[1] - the sum of max list
   */
  private static void getMaxSumPath(TreeNode root, List<TreeNode> max, List<TreeNode> temp, long[] sums){
    if(root==null) return;
    temp.add(root);
    sums[0]+=root.val;
    if(root.left==null && root.right==null) {
      if(sums[0]>sums[1]) {
        //cannot use `max = new ArrayList<Integer>(temp);` because it dereference max and list 
        max.clear();
        max.addAll(temp);
        sums[1]=sums[0];
      }
    }
    getMaxSumPath(root.left, max, temp, sums);
    getMaxSumPath(root.right, max, temp, sums);
    
    sums[0]-=temp.get(temp.size()-1).val;
    temp.remove(temp.size()-1);
  }
  
  /**
   * Vertical sum of binary tree
   * <link> https://www.java2blog.com/vertical-sum-of-binary-tree-in-java/
   * @param root
   * @return
   */
  public static int[] sumVertical(TreeNode root){
    Map<Integer, Integer> map=new TreeMap<>();
    sumVertical(root, map, 0);
    return map.values().stream().mapToInt(v->v.intValue()).toArray();
  }
  
  private static void sumVertical(TreeNode root, Map<Integer, Integer> map, int position){
    if(root==null) return;
    
    map.computeIfPresent(position, (k,v)->(v+root.val));
    map.putIfAbsent(position, root.val);
    
    sumVertical(root.left, map, position-1);
    sumVertical(root.right, map, position+1);
  }
  
  /**
   * Find the max value in the tree.
   * @param root
   * @return
   */
  public static int getMax(TreeNode root){
    if(root==null) return Integer.MIN_VALUE;
    int max=root.val;
    max=Math.max(max, getMax(root.left));
    max=Math.max(max, getMax(root.right));
    return max;
  }
  
  /**
   * Get the depth of a binary tree.
   * @param root
   * @return the depth of the tree. Root is in depth 0.
   */
  public static int getDepth(TreeNode root){
    if(root==null) return -1;
    return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
  }
  
  /**
   * Get the level a a node (AKA Y position). Root node is level 0.
   * @param root
   * @param node
   * @return The level of a node if it exists in the tree. (root is 0)
   * Otherwise, return -1;
   */
  public static int getLevelOfNode(TreeNode root, TreeNode node){
    if(root==null) return -1;
    return getLevelOfNode(root, node, 0);
  }
  private static int getLevelOfNode(TreeNode root, TreeNode node, int level){
    if(root==node) return level;
    
    if(root.left!=null){
      int left=getLevelOfNode(root.left, node, level+1);
      if(left>-1) return left;
    }
    if(root.right!=null){
      int right=getLevelOfNode(root.right, node, level+1);
      if(right>-1) return right;
    }
    return -1;
  }
  
  /**
   * Get the relative position from the node to root in the horizontal level.
   *    1
      /  \
     2     3
    / \   / \
   6   7 4   5
   * @param root
   * @param node
   * @return relative position (+/-) of a node to the root.
   *         Integer.MIN_VAULE if this node does not exist in the tree.
   */
  public static int getDistanceOfNode(TreeNode root, TreeNode node){
    if(root==null) return Integer.MIN_VALUE;
    return getDistanceOfNode(root, node, 0);
  }
  private static int getDistanceOfNode(TreeNode root, TreeNode node, int distance){
    if(root==node) return distance;
    if(root.left!=null){
      int dis=getDistanceOfNode(root.left, node, distance-1);
      if(dis!=Integer.MIN_VALUE) return dis;
    }
    
    if(root.right!=null){
      int dis=getDistanceOfNode(root.right, node, distance+1);
      if(dis!=Integer.MIN_VALUE) return dis;
    }
    
    return Integer.MIN_VALUE;
  }
  
  /**
   * Find the sum of all left leaves in a given binary tree.
   * <link> https://leetcode.com/problems/sum-of-left-leaves/description/
   * @param root
   * @return sum of all left leaves in a given binary tree.
   */
  public static int sumOfLeftLeaves(TreeNode root){
    if(root==null) return 0;
    int n=0;
    
    //root.left is a left leave, so add the value to n;
    if(root.left!=null && root.left.left==null && root.left.right==null){
        n+=root.left.val;
    }
    return n+sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
  }
  
  public static int sumOfLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    } else if (root.left == null && root.right == null) {
      return root.val;
    } else {
      return sumOfLeaves(root.left) + sumOfLeaves(root.right);
    }
  }
  
  public static long maxSumRootToLeaf(TreeNode root){
    if(root==null) return 0;
    return Math.max(maxSumRootToLeaf(root.left), maxSumRootToLeaf(root.right)) + root.val;
  }
  
  
  
  private List<TreeNode> list=new ArrayList<>();
  
  // print the top view from left->right
  public void printTopView(TreeNode root) {
    if(root==null) System.out.println("[]");
    else{
      Queue<TreeNode> queue=new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()){
        TreeNode node=queue.poll();
        if(node.left!=null) queue.offer(node.left);
        if(node.right!=null) queue.offer(node.right);
        list.add(node);
      }

      Map<Integer, TreeNode> map=new TreeMap<>();
      getTopView(root, map, 0);
      
      List<Integer> topview=new ArrayList<Integer>();
      for(TreeNode node:map.values()){
        topview.add(node.val);
      }
      System.out.println(topview);
    }
  }
  
  private void getTopView(TreeNode root, Map<Integer, TreeNode> map, int horizon){
    if(root==null) return;
    if(!map.containsKey(horizon)){
      map.put(horizon, root);
    }else{
      TreeNode node=map.get(horizon);
      if(isBefore(root, node)){
        map.replace(horizon, root);
      }
    }
    getTopView(root.left,map,horizon-1);
    getTopView(root.right,map,horizon+1);
  }
  
  private boolean isBefore(TreeNode node1, TreeNode node2){
    for(TreeNode node:list){
      if(node==node1) return true;
      if(node==node2) return false;
    }
    return true;
  }
  // print the top view in level order (root, left, right)
  public void printTopViewLevel(TreeNode root) {
    if(root==null) System.out.println("[]");
    else{
      Queue<TreeNode> queue=new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()){
        TreeNode node=queue.poll();
        if(node.left!=null) queue.offer(node.left);
        if(node.right!=null) queue.offer(node.right);
        list.add(node);
      }

      Map<Integer, TreeNode> map=new TreeMap<>();
      getTopView(root, map, 0);
      
      List<Integer> topview=new ArrayList<>();
      Collection<TreeNode> set=map.values();
      for(TreeNode node:list){
        if(set.contains(node)) topview.add(node.val);
      }
      System.out.println(topview);
    }
  }

  public static TreeNode invertTree(TreeNode root) {
    if (root == null)
      return root;
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;
  }
  
  /**
   * Tell whether a tree is s sum tree, which root's value is the sum of all its children' values.
   * @param root
   * @return
   */
  public static boolean isSumTree(TreeNode root){
    if(root==null || (root.left ==null && root.right==null)) return true;
    
    int sum= (root.left==null?0:root.left.val) + (root.right==null?0:root.right.val);
    if(root.val==sum && isSumTree(root.left) && isSumTree(root.right)) return true;
    else return false;
  }
}
