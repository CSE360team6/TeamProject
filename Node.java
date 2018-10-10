import java.util.ArrayList;

//REV 2


public class Node {
	// Variables that will be stored in a node
	private String Activity;
	private int Duration;
	private ArrayList<Node> Predecessors;
	private String PredecessorNames;
	private boolean hasPredecessor;
	private boolean isPredecessor;

	// Constructor
	public Node(String Activity, int Duration, String PredecessorNames) {
		this.Activity = Activity;
		this.Duration = Duration;
		this.PredecessorNames = PredecessorNames.replaceAll("\\s", "");
		this.Predecessors = new ArrayList<Node>();
		hasPredecessor = false;
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

	public void addPredecessors(ArrayList<Node> Nodes) throws ErrorException {
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
		return !isPredecessor && !hasPredecessor;
	}
	public String toString() {
		return Activity + " " /*" Duration:" + Duration + " Predecessors:" + Predecessors*/;
	}
}
