/*
 * Fardos Mohamed, Alan Kim
	ffm2@uw.edu, kimaj93@uw.edu
	1037290, 1124105
*/
import java.util.List;

public class Path {
	// we use public fields fields here since this very simple class is
	// used only for returning multiple results from shortestPath
	public final List<Vertex> vertices;
	public final int cost;

	public Path(List<Vertex> vertices, int cost) {
		this.vertices = vertices;
		this.cost = cost;
	}
}
