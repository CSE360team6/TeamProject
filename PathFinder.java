import java.util.ArrayList;

import java.*;

//Rev 2

public class PathFinder {
	public static ArrayList<Path> Paths = new ArrayList<Path>();
	public static void findPaths(ArrayList<Node> Nodes) throws ErrorException {
		for(int i = 0; i < Nodes.size(); i++) {
			Node node = Nodes.get(i);
			if(node.isPredecessor() == false){
				Path newPath = new Path();
				Paths.add(newPath);
				newPath.CreatePath(node);
			}
		}
	}
}
