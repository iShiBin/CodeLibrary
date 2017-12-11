import tree.TreeNode;

class DisconnectNodes {
    private void isolate(TreeNode node){
        node=null;
    }
    
    private void removeChildren(TreeNode node){
        node.left=null;
        node.right=null;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
        DisconnectNodes test = new DisconnectNodes();
        test.isolate(root);
        System.out.println(root==null);
        
        test.removeChildren(root);
        System.out.println(root.left==null);
        System.out.println(root.right==null);
    }

}
