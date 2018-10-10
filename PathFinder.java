import java.util.ArrayList;

import java.*;

//Rev 1

public class PathFinder {
	public static ArrayList<Path> Paths = new ArrayList<Path>();
	public static ArrayList<Path> findPaths(ArrayList<Node> Nodes){
		for(int i = 0; i < Nodes.size(); i++) {
			Node node = Nodes.get(i);
			if(node.isEnd() == true){
				Path newPath = new Path();
				Paths.add(newPath);
				newPath.CreatePath(node);
			}
		}
	}
}
