package composite.dirstructure;

import java.util.ArrayList;

public class DirectNode extends Node {

	ArrayList<Node> nodeList = new ArrayList<Node>();

	public DirectNode(String name) {
		super(name);
	}

	public void addNode(Node node) throws Exception {
		nodeList.add(node);
		node.setParent(this);
	}

	@Override
	void display() {
		System.out.println(name);
		for (int i = 0; i < nodeList.size(); i++) {
			nodeList.get(i).display();
		}
	}

	@Override
	public Node[] getChilds() {
		if (nodeList.size() == 0)
			return null;
		Node nodes[] = new Node[nodeList.size()];
		for (int i = 0; i < nodeList.size(); i++) {
			nodes[i] = nodeList.get(i);
		}
		return nodes;
	}

}
