import java.util.ArrayList;

public class Node {
	// Variables that will be stored in a node
	private String Activity;
	private int Duration;
	private ArrayList<Node> Predecessors;
	private ArrayList<String> PredecessorNames;
	private boolean hasPredecessor;

	// Constructor
	public Node(String Activity, int Duration, ArrayList<String> PredecessorNames) {
		this.Activity = Activity;
		this.Duration = Duration;
		this.PredecessorNames = PredecessorNames;
		this.Predecessors = new ArrayList<Node>();
		hasPredecessor = false;
	}

	public String getName() {
		return Activity;
	}

	public int getDuration() {
		return Duration;
	}

	public boolean hasPrdecessor() {
		return hasPredecessor;
	}

	public ArrayList<Node> getPredecessors() {
		return Predecessors;
	}

	public void addPredecessors(ArrayList<Node> Nodes) {
		for (int i = 0; i < PredecessorNames.size(); i++) {
			for (int j = 0; j < Nodes.size(); j++) {
				if (PredecessorNames.get(i).equals(Nodes.get(j).getName())) {
					this.Predecessors.add(Nodes.get(j));
					hasPredecessor = true;
				}
			}
		}
	}
}
