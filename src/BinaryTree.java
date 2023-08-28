import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	public Node root;
	public Node symmetricRoot;
	public ArrayList<Integer> numbers;

	public BinaryTree(ArrayList<Integer> numbers) {
		this.root = null;
		this.symmetricRoot = null;
		this.numbers = numbers;
		insertTrees();
	}

	public void insertTrees() { // Hem normal aðacý oluþturuyor hemde simetriðini oluþturuyor

		for (int number : numbers) {
			insert(number);
		}

		for (int number : numbers) {
			insertSymmetric(number);
		}
	}

	public void insert(int number) { // Aðacý oluþturan fonksiyon

		this.root = insertRecursive(this.root, number);
	}

	public void insertSymmetric(int number) { // Aðacýn simetiriðini oluþturan fonksiyon

		this.symmetricRoot = insertSymmetricRecursive(this.symmetricRoot, number, 1);
	}

	public Node insertRecursive(Node root, int number) { //rekürsif olarak aðaca elemanlarý ekler
		if (root == null) {
			root = new Node(number);
			return root;
		}

		if (number < root.number)
			root.left = insertRecursive(root.left, number);
		else if (number > root.number)
			root.right = insertRecursive(root.right, number);

		return root;
	}

	public Node insertSymmetricRecursive(Node root, int number, int step) { //rekürsif olarak aðacýn simetriðine elemanlarý ekler
		if (root == null) {
			root = new Node(number);
			return root;
		}

		if (step < 2) {
			if (number > root.number)
				root.left = insertSymmetricRecursive(root.left, number, ++step);
			else if (number < root.number)
				root.right = insertSymmetricRecursive(root.right, number, ++step);
		} else {
			if (number < root.number)
				root.left = insertSymmetricRecursive(root.left, number, ++step);
			else if (number > root.number)
				root.right = insertSymmetricRecursive(root.right, number, ++step);
		}

		return root;
	}

	public void printLevelOrder(Node root) { // Seviye Sýrasýna göre elemanlarý yazdýrýr printGivenLevel a seviyeyi göndererek yapar
		int height = getHeight(root);
		for (int i = 1; i <= height; i++) {
			System.out.print("Seviye " + i + ": ");
			printGivenLevel(root, i);
			System.out.println();
		}
	}

	public void printGivenLevel(Node root, int level) { //Verilen seviyeyi aðaçta o seviyeye kadar gidip yazdýrýr
		if (root == null) {
			if (level == 1)
                System.out.print("boþ, ");
			return;
		}
		if (level == 1)
			System.out.print(root.number + ", ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}


	public int getHeight(Node node) { //Aðacýn yüksekliðini getiren fonksiyon
		if (node == null)
			return 0;
		else {
			int leftHeight = getHeight(node.left);
			int rightHeight = getHeight(node.right);

			if (leftHeight > rightHeight)
				return (leftHeight + 1);
			else
				return (rightHeight + 1);
		}
	}

	
	// Tam simetrisini almak 
	public void symmetric() {
		this.root = symmetricTreeRecursive(this.root);
	}

	public Node symmetricTreeRecursive(Node root) {
		if (root == null)
			return root;

		Node left = symmetricTreeRecursive(root.left);
		Node right = symmetricTreeRecursive(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

}
