import java.util.ArrayList;
import java.util.Collections;


//Rev 3

public class PathFinder {
	public static ArrayList<Path> Paths = new ArrayList<Path>();
	public static void findPaths(ArrayList<Node> Nodes) throws ErrorException {
		Paths.clear();
		int paths = 0;
		for(int i = 0; i < Nodes.size(); i++) {
			Node node = Nodes.get(i);
			if(node.isPredecessor() == false){
				paths++;
				if(paths > 1) {
					throw new ErrorException(ErrorException.ErrorID.ISLAND, node);
				}
				Path newPath = new Path();
				Paths.add(newPath);
				newPath.CreatePath(node);
			}
		}
		Collections.sort(Paths, Collections.reverseOrder());
	}
}