package com.zabee.dsalgo.trees;

/**
 * 
 * @author Zabee {@code
 * Tree1:
 * 								1
 * 				2								3
 * 		4				5				6				7
 * 8		9		1		7		8		9		7		7
 * 
 * Sub Tree:
 * 				2
 * 		4				5
 * 8		9		1		7
 * 
 * Not a sub tree:
 * 				2
 * 		4				5
 * 8		9		1		6
 * }
 * 
 */
public class CheckIfSubtree {

	public static void main(String[] args) {

		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.left.left = new TreeNode(4);
		root1.left.left.left = new TreeNode(8);
		root1.left.left.right = new TreeNode(9);

		root1.left.right = new TreeNode(5);
		root1.left.right.left = new TreeNode(1);
		root1.left.right.right = new TreeNode(7);

		root1.right = new TreeNode(3);
		root1.right.left = new TreeNode(6);
		root1.right.left.left = new TreeNode(8);
		root1.right.left.right = new TreeNode(9);

		root1.right.right = new TreeNode(7);
		root1.right.right.left = new TreeNode(7);
		root1.right.right.right = new TreeNode(7);
		StringBuilder strBuilderTree1 = new StringBuilder();
		StringBuilder strBuilderTree2 = new StringBuilder();

		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(4);
		root2.left.left = new TreeNode(8);
		root2.left.right = new TreeNode(9);

		root2.right = new TreeNode(5);
		root2.right.left = new TreeNode(1);
		root2.right.right = new TreeNode(7);

		method1ToCheckIfSubTree(root1, strBuilderTree1, strBuilderTree2, root2);
		method2ToCheckIfSubTree(root1, root2);

	}

	private static void method2ToCheckIfSubTree(TreeNode root1, TreeNode root2) {
		if (root1 == root2) {
			System.out.println("Given tree is a sub tree from method2");
			return;
		}
		TreeNode node = locateMatchingRoot(root1, root2);
		if (node != null && matchTree(node, root2)) {
			System.out.println("Given tree is a sub tree from method2");
		} else {
			System.out.println("Given tree is not a sub tree from method2");
		}

	}

	private static boolean matchTree(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}
		boolean isMatch = matchTree(root1.left, root2.left);
		if (isMatch) {
			isMatch = matchTree(root1.right, root2.right);
		}
		return isMatch;
	}

	private static TreeNode locateMatchingRoot(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return null;
		}
		if (root1.data != root2.data) {
			return locateMatchingRoot(root1.left, root2);
		}
		return root1;
	}

	private static void method1ToCheckIfSubTree(TreeNode root, StringBuilder strBuilderTree1,
			StringBuilder strBuilderTree2, TreeNode root2) {
		preOrderTraversal(root, strBuilderTree1);
		preOrderTraversal(root2, strBuilderTree2);

		if (strBuilderTree1.toString().trim().contains(strBuilderTree2.toString().trim())) {
			System.out.println("Indeed a sub tree");
		} else {
			System.out.println("Not a sub tree");
		}
	}

	private static class TreeNode {

		public TreeNode(int argData) {
			data = argData;
		}

		int data;
		TreeNode left;
		TreeNode right;
	}

	private static void preOrderTraversal(TreeNode root, StringBuilder argStrBuilder) {
		if (root == null) {
			return;
		}
		argStrBuilder.append(root.data + " ");
		preOrderTraversal(root.left, argStrBuilder);
		preOrderTraversal(root.right, argStrBuilder);
	}
}
