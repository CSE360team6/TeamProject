import java.util.ArrayList;


import java.*;

//Rev 1

public class Path {
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
	public void CreatePath(Node node) {
		this.append(node);
		if(node.hasPredecessor() == false) {
			return;
		}
		CreatePath(node.getPredecessors().get(0));
		for(int i = 1; i < node.getPredecessors().size(); i++) {
			Path newPath = new Path(Length, Activities);
			PathFinder.Paths.add(newPath);
			newPath.CreatePath(node.getPredecessors().get(i));
		}
	}
	public String toString(){
		return "Duration:" + Length + Activities.toString();
	}
}
