//package com.week4.ProductMIS.tree;
//
//
//import com.week4.ProductMIS.models.Product;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class TreeNode {
//    private Product product;
//    private TreeNode left;
//    private TreeNode right;
//
//    public TreeNode(Product product) {
//        this.product = product;
//        this.left = null;
//        this.right = null;
//    }
//}

package com.week4.ProductMIS.tree;

public class TreeNode<T extends Comparable<T>> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}

