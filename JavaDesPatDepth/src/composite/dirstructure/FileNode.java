package composite.dirstructure;

public class FileNode extends Node {

	public FileNode(String name) {
		super(name);
	}

	@Override
	void display() {
		System.out.println(name);
	}

	@Override
	public Node[] getChilds() {
		return null;
	}

}
