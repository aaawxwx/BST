public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }
    private Node root;
    private int size;
    public BST(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
//向二分搜索树中添加新的元素e
    public void add(E e){
       root = add(root,e);
    }
    private Node add(Node node,E e){
       if (node==null){
           size++;
     return new Node(e);
       }
        if (e.compareTo(node.e)<0)
            node.left= add(node.left,e);

        else if(e.compareTo(node.e)>0)
            node.right=add(node.right,e);

        return node;
    }
    //看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root,e);
    }
    //看以node为根的二分搜索树中是否包含元素e，递归算法
    private boolean contains(Node node,E e){
        if (node==null)
            return false;
        if (e.compareTo(node.e)==0)
            return true;
        else if (e.compareTo(node.e)<0)
            return contains(node.left,e);
        else return contains(node.right,e);
    }

    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node==null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder (Node node){
        if (node==null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
//二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node==null)
            return;;
            postOrder(node.left);
            postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    private void  generateBSTString(Node node,int depth,StringBuilder res){
        if (node==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left, depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }
    private String generateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for (int i=0;i<depth;i++)
            res.append("--");
        return res.toString();
    }
}
