package com.company.chapter_6_BST;

import com.company.chapter_3_stackAndQueue.stack.ArrayStack;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

    }


    private Node root;
    private int size;


    public BST() {
        root = null;
        size = 0;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(E e) {
        root = add(root, e);

    }

    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null)
            return false;

        if (node.e.compareTo(e) == 0)
            return true;
        else if (node.e.compareTo(e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }


    /*
    前序遍历
        先访问该元素，再去访问其左右子树。
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    public void preOrderNR() {
        ArrayStack<Node> stack = new ArrayStack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }

    }


    /*
        中序遍历
            先访问左子树，再访问该元素，然后访问右子树
     */
    public void inOrder() {
        inOrder(root);
    }


    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    /*
        后序遍历
            先访问左右子树，最后访问该元素
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.e);

            if (node.left != null)
                q.add(node.left);

            if (node.right != null)
                q.add(node.right);

        }
    }


    //  寻找最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is  null");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }


//    07:29
//    删除掉以node为根的二分搜索树中的最小节点
//    返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if (node.left==null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }



    //  寻找最大元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is  null");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return minimum(node.right);
    }

    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    //    08:13
//    删除掉以node为根的二分搜索树中的最小节点
//    返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if (node.right==null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }



    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e){
        if( node == null )
            return null;

        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else{   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }



    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        generateBTSString(root, 0, str);

        return str.toString();
    }

    private void generateBTSString(Node node, int depth, StringBuilder str) {

        if (node == null) {
            str.append(generateDepthString(depth) + "null\n");
            return;
        }
        str.append(generateDepthString(depth) + node.e + "\n");
        generateBTSString(node.left, depth + 1, str);
        generateBTSString(node.right, depth + 1, str);
    }

    private String generateDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }
    static int  max,min;

    public static void main(String[] args) {

        int array[] = {1,2,3,4,5,6,10};

        max = min = array[0];
        maxAndMin(array,0);
        System.out.printf("%d - %d",max,min);

    }


    private static void maxAndMin(int array[],int index){

        if (array.length==index)
            return;

        if (array[index]>max)
            max = array[index];

        if (array[index]<min)
            min = array[index];

        maxAndMin(array,index+1);
    }

}

