import java.util.ArrayList;
import java.util.Collections;


//Rev 5

public class Path implements Comparable<Path> {
	private int Length;
	private ArrayList<Node> Activities;
	public Path () {
		Length = 0;
		Activities = new ArrayList<Node>();
	}
	public Path(int Duration, Node node) {
		Length = Duration;
		Activities = new ArrayList<Node>();
		Activities.add(node);
	}
	public Path(int Duration, ArrayList<Node> Nodes) {
		Length = Duration;
		Activities = new ArrayList<Node>();
		for (int i = 0; i < Nodes.size(); i ++) {
			Activities.add(Nodes.get(i));
		}
	}
	public void append(Node node) {
		Length += node.getDuration();
		Activities.add(node);
	}
	public int getLength() {
		return Length;
	}
	public void CreatePath(Node node, ArrayList<Path> paths) throws ErrorException {
		node.Touch();
		for(int i = 0; i < Activities.size(); i++) {
			if(node.equals(Activities.get(i))) {
				throw new ErrorException(ErrorException.ErrorID.CYCLE, node);
			}
		}
		this.append(node);
		if(node.hasPredecessor() == false) {
			Collections.reverse(Activities);
			return;
		}
		for(int i = 1; i < node.getPredecessors().size(); i++) {
			Path newPath = new Path(Length, Activities);
			paths.add(newPath);
			newPath.CreatePath(node.getPredecessors().get(i), paths);
		}
		CreatePath(node.getPredecessors().get(0), paths);
	}
	public String toString(){
		String Output = Length + "; " + Activities.get(0).getName();
		for(int i = 1; i < Activities.size(); i ++) {
			Output = Output.concat(", ".concat(Activities.get(i).getName()));
		}
		return Output;
	}
	public String toString(int i) {
		return "Path " + i + ": " + toString();
	}
	@Override
	public int compareTo(Path arg0) {
		// TODO Auto-generated method stub
		if(this.Length > arg0.getLength()) {
			return 1;
		}
		else if (this.Length == arg0.getLength()) {
			return 0;
		}
		else {
			return -1;
		}
	}
}