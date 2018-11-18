import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


//Rev 4

public class PathFinder {
	
	public static ArrayList<Path> findPaths(ArrayList<Node> Nodes) throws ErrorException {
		ArrayList<Path> Paths = new ArrayList<Path>();
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
				newPath.CreatePath(node, Paths);
			}
		}
		Collections.sort(Paths, Collections.reverseOrder());
		return Paths;
	}
	
	public static String determineOutput(ArrayList<Path> Paths, boolean isCritical) {
		String Output = new String();
		if(isCritical) {
			int Longest = Paths.get(0).getLength();
			Output = Paths.get(0).toString(1);
			for(int i = 1; i < Paths.size(); i++) {
				Path path = Paths.get(i);
				if(path.getLength() == Longest) {
					Output = Output.concat(path.toString(i+1).concat("\r\n"));
				}
			}
		}
		else {
			Output = new String();
			for(int i = 0; i < Paths.size(); i++) {
				Path path = Paths.get(i);
				Output = Output.concat(path.toString(i+1).concat("\r\n"));
			}
		}
		return Output;
	}
	
	public static void generateReport(ArrayList<Path> Paths, ArrayList<Node> Nodes, String ReportTitle) throws IOException {
		String Output = new String();
		FileOutputStream fp = new FileOutputStream(ReportTitle.concat(".txt"));
		fp.write(ReportTitle.concat("\r\n\r\n").getBytes());
		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		fp.write(dateformat.format(date).concat("\r\n\r\n").getBytes());
		for(int i = 0; i < Nodes.size(); i ++) {
			Node node = Nodes.get(i);
			fp.write(node.toString().concat("\r\n").getBytes());
		}
		fp.write("\r\n".getBytes());
		Output = PathFinder.determineOutput(Paths, false);
		fp.write(Output.getBytes());
		fp.close();
	}
}