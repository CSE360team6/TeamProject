import java.util.ArrayList;
import java.util.Collections;
import java.*;

//Rev 2

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
	public void CreatePath(Node node) throws ErrorException {
		for(int i = 0; i < Activities.size(); i++) {
			if(node.equals(Activities.get(i))) {
				throw new ErrorException(ErrorException.ErrorID.CYCLE, node);
			}
		}
		this.append(node);
		if(node.hasPredecessor() == false) {
			return;
		}
		for(int i = 1; i < node.getPredecessors().size(); i++) {
			Path newPath = new Path(Length, Activities);
			PathFinder.Paths.add(newPath);
			newPath.CreatePath(node.getPredecessors().get(i));
		}
		CreatePath(node.getPredecessors().get(0));
	}
	public String toString(){
		Collections.reverse(Activities);
		return "Duration:" + Length + " " + Activities;
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
