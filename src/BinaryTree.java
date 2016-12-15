
public class BinaryTree {
	private TreeNode root;
	
	public void insert(Integer data){
		if(root == null){
			this.root = new TreeNode(data);
		}
		else{
			root.insert(data);
		}
	}
	
	public Integer largest(){
		if(this.root != null){
			return root.largest();
		}
		return null;
	}
	
	public Integer smallest(){
		if(this.root != null){
			return root.smallest();
		}
		return null;
	}
	
	
	public int height() {
		if (this.root == null) return 0;
		return this.root.height();
	}
	
	
	public TreeNode find(Integer data){
				
		if(root != null){
			return root.find(data);
		}
		return null;
	}
	
	public void delete(Integer data){
		//CASE 1: node has no children
		//CASE 2: node has one child
		//CASE 3: node has two children
		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;
		
		if(current == null){
			return;
		}
		
		while(current != null && current.getData() != data){
			parent = current;
			
			if(data < current.getData()){
				current = current.getLeftChild();
				isLeftChild = true;
			}
			else{
				current = current.getRightChild();
				isLeftChild = false;
			}
		}
		if(current == null){
			return;
		}
		//CASE 1
		if(current.getLeftChild() == null && current.getRightChild() == null){
			if(current == root){
				root = null;
			}
			else{
				if(isLeftChild){
					parent.setLeftChild(null);
				}
				else
					parent.setRightChild(null);
			}
		}
		//CASE 2
		else if(current.getRightChild() == null){
			if(current == root){
				root = current.getLeftChild();
			}
			else if(isLeftChild){
				parent.setLeftChild(current.getLeftChild());
			}
			else{
				parent.setRightChild(current.getLeftChild());
			}
		}
		else if(current.getLeftChild() == null){
			if(current == root){
				root = current.getRightChild();
			}
			else if(isLeftChild){
				parent.setLeftChild(current.getRightChild());
			}
			else{
				parent.setRightChild(current.getRightChild());
			}
		}
		else {
			TreeNode successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			successor.setLeftChild(current.getLeftChild());
		}
	}
	
	private TreeNode getSuccessor(TreeNode node) {
		TreeNode parentOfSuccessor = node;
		TreeNode successor = node;
		TreeNode current = node.getRightChild();
		while (current != null) {
			parentOfSuccessor = successor;
			successor = current;
			current = current.getLeftChild();
		}
		if (successor != node.getRightChild()) {
			parentOfSuccessor.setLeftChild(successor.getRightChild());
			successor.setRightChild(node.getRightChild());
		}
		return successor;
	}
	
	
	public void traverseInOrder() {
		if (this.root != null)
			this.root.traverseInOrder();
		System.out.println();
	}
	
	public int numOfLeafNodes() {
		if (this.root == null) return 0;
		return this.root.numOfLeafNodes();
	}
	
	public static BinaryTree createFromSortedArray(int[] data) {
		BinaryTree bst = new BinaryTree();		
		if (data != null && data.length > 0) {
			bst.root = TreeNode.addSorted(data, 0, data.length-1);
		}
		return bst;
	}
	
	
	public static void main(String[] args) {
		int[] sample = { 212, 580, 6, 7, 28, 84, 112, 434};
		BinaryTree bst = new BinaryTree();
		for (int x : sample) {
			bst.insert(x);
		}
		System.out.println(bst.find(65));
		System.out.println(bst.smallest());
		System.out.println(bst.largest());
//		bst.delete(84);
		System.out.println(bst.numOfLeafNodes());
		System.out.println(bst.height());
		bst.traverseInOrder();
	}

	
}


class TreeNode{
	
	private Integer data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	
	//Constructor
	public TreeNode(Integer data){
		this.data = data;
	}
	
	
	public TreeNode find(Integer data){
		if(this.data == data){
			return this;
		}
		if(data < this.data && leftChild!=null){
			return leftChild.find(data);
		}
		if(rightChild!=null){
			return rightChild.find(data);
		}
		return null;
		
	}
	
	public void insert(Integer data){
		if(data >= this.data){
			if(this.rightChild == null){
				this.rightChild = new TreeNode(data);
			}
			else{
				this.rightChild.insert(data);
			}
		}else{
			if(this.leftChild == null){
				this.leftChild = new TreeNode(data);
			}
			else{
				this.leftChild.insert(data);
			}
		}
	}
	//returns the number of leaf nodes in the tree
	public int numOfLeafNodes(){
		if(isLeaf()){
			return 1;
		}
		int leftLeaves = 0;
		int rightLeaves = 0;
		
		if(this.rightChild != null){
			rightLeaves = rightChild.numOfLeafNodes();
		}
		if(this.leftChild != null){
			leftLeaves = leftChild.numOfLeafNodes();
		}
		
		return leftLeaves + rightLeaves;
	}

	
	//returns largest node in the tree
	public Integer largest(){
		if(this.rightChild == null){
			return this.data;
		}
		return this.rightChild.largest();
	}
	
	//returns smallest node in the tree
	public Integer smallest(){
		if(this.leftChild == null){
			return this.data;
		}
		return this.leftChild.smallest();
	}
	
	//returns true if a node is a leaf (no children)
	public boolean isLeaf(){
		return (this.rightChild==null && this.leftChild==null);
	}
	
	public void traverseInOrder() {
		if (this.leftChild != null)
			this.leftChild.traverseInOrder();
		System.out.print(this + " ");
		if (this.rightChild != null)
			this.rightChild.traverseInOrder();
	}
	
	public int height() {
		if (isLeaf()) return 1;
		int left = 0;
		int right = 0;
		if (this.leftChild != null)
			left = this.leftChild.height();
		if (this.rightChild != null)
			right = this.rightChild.height();
		return (left > right) ? (left + 1) : (right + 1);
	}
	
	public static TreeNode addSorted(int[] data, int start, int end) {
		if (end >= start) {
			int mid = (start+end)/2;
			TreeNode newNode = new TreeNode(data[mid]);
			newNode.leftChild = addSorted(data, start, mid-1);
			newNode.rightChild = addSorted(data, mid+1, end);
			return newNode;
		}
		return null;
	}
	
	
	//get value of node
	public Integer getData() {
		return data;
	}
	
	// get/set for leftChild
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	// get/set for rightChild
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	
	@Override
	public String toString() {
		return String.valueOf(this.data);
	}
		
	
}