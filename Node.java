import java.util.ArrayList;

public class Node {
	//Rev 5
	public static ArrayList<Node> Nodes = new ArrayList<Node>();
	// Variables that will be stored in a node
	private String Activity;
	private int Duration;
	private ArrayList<Node> Predecessors;
	private String PredecessorNames;
	private boolean hasPredecessor;
	private boolean isPredecessor;
	private boolean Touched;

	// Constructor
	public Node(String Activity, int Duration, String PredecessorNames) {
		this.Activity = Activity;
		this.Duration = Duration;
		this.PredecessorNames = PredecessorNames.replaceAll("\\s", "");
		this.Predecessors = new ArrayList<Node>();
		hasPredecessor = false;
		Touched = false;
	}

	public String getName() {
		return Activity;
	}

	public int getDuration() {
		return Duration;
	}

	public boolean hasPredecessor() {
		return hasPredecessor;
	}
	
	public boolean isPredecessor() {
		return isPredecessor;
	}
	
	public void setPredecessor() {
		isPredecessor = true;
	}

	public ArrayList<Node> getPredecessors() {
		return Predecessors;
	}
	
	public boolean Touched() {
		return Touched;
	}
	
	public void Touch() {
		Touched = true;
	}
	
	public static void add(String inActivity, int inDuration, String inPredecessors)
	{		
		// Create a new node for the input activity
		Nodes.add(new Node (inActivity, inDuration, inPredecessors));
	}
	
	public void Reset() {
		isPredecessor = false;
		hasPredecessor = false;
	}

	public void addPredecessors(ArrayList<Node> Nodes) throws ErrorException {
		Predecessors.clear();
		String[] PredecessorList = PredecessorNames.split(",");
		for (int i = 0; i < PredecessorList.length; i++) {
			boolean flag = true;
			for (int j = 0; j < Nodes.size(); j++) {
				Node node = Nodes.get(j);
				if (PredecessorList[i].equals(node.getName())) {
					this.Predecessors.add(node);
					node.setPredecessor();
					hasPredecessor = true;
					flag = false;
				}
			}
			if(flag && PredecessorList[0].length() > 0) {
				throw new ErrorException(ErrorException.ErrorID.NO_PREDECESSOR, this);
			}
		}
	}
	public boolean isIsland() {
		return !isPredecessor && !hasPredecessor && Nodes.size() > 1;
	}
	public String toString() {
		return Activity + " " + Duration;
	}
}
