package in.ineuron.question;

public class Question2 {
	static class Node {
		Node left, right;
		int key;
	}

	static Node newNode(int key) {
		Node ptr = new Node();
		ptr.key = key;
		ptr.left = null;
		ptr.right = null;
		return ptr;
	}
	static Node insert(Node root, int key) {
		if (root == null)
			root = newNode(key);
		else if (root.key > key)
			root.left = insert(root.left, key);
		else if (root.key < key)
			root.right = insert(root.right, key);
		return root;
	}
	static int distanceFromRoot(Node root, int x) {
		if (root.key == x)
			return 0;
		else if (root.key > x)
			return 1 + distanceFromRoot(root.left, x);
		return 1 + distanceFromRoot(root.right, x);
	}
	static int distanceBetween2(Node root, int a, int b) {
		if (root == null)
			return 0;
		if (root.key > a && root.key > b)
			return distanceBetween2(root.left, a, b);
		if (root.key < a && root.key < b)
			return distanceBetween2(root.right, a, b);
		if (root.key >= a && root.key <= b)
			return distanceFromRoot(root, a) + distanceFromRoot(root, b);

		return 0;
	}
	static int findDistWrapper(Node root, int a, int b) {
		int temp = 0;
		if (a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		return distanceBetween2(root, a, b);
	}
	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 20);
		insert(root, 8);
		insert(root, 3);
		insert(root, 1);
		insert(root, 6);
		insert(root, 4);
		insert(root, 7);
		insert(root, 10);
		insert(root, 14);
		insert(root, 13);
		System.out.println(findDistWrapper(root, 6, 14));
	}
}
