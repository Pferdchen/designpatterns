package composite.dirstructure;

public abstract class Node {

	protected String name;

	protected Node parent = null;

	public Node(String name) {
		this.name = name;
	}

	public void addNode(Node node) throws Exception {
		throw new Exception("Invalid exception");
	}

	abstract void display();

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node[] getBrothers() {
		DirectNode parent = (DirectNode) getParent();
		if (parent == null)
			return null;
		int size = parent.nodeList.size();
		if (size == 1)
			return null;
		Node nodes[] = new Node[size - 1];
		for (int i = 0; i < size; i++) {
			if (parent.nodeList.get(i) == this)
				continue;
			nodes[i] = parent.nodeList.get(i);
		}
		return nodes;
	}

	public abstract Node[] getChilds();

}
