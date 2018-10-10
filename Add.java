import java.util.ArrayList;
import java.util.Arrays;

public class Add 
{
	private String inActivity;
	private int inDuration;
	private String inPredecessors;
	
	// Constructor
	public void add (String inActivity, int inDuration, String inPredecessors)
	{		
		// Set values of vars for this add iteration
		this.inActivity = inActivity;
		this.inDuration = inDuration;
		this.inPredecessors = inPredecessors;
		
		// Parse predecessors input list into an arraylist to be stored in the node
		ArrayList<String> predecessorsList = new ArrayList<String>(Arrays.asList(inPredecessors.split(",")));
		
		// Create a new node for the input activity
		Node activtyN;
		activtyN = new Node (inActivity, inDuration, predecessorsList);
	}
	
	
	
}
