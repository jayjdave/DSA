import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

	Vertex[] adjLists;
	
	public Graph(String file) throws FileNotFoundException{
		Scanner scan = new Scanner(new File(file));
		
		//expects 
		adjLists = new Vertex[scan.nextInt()];
		
		//read vertices
		for(int i = 0; i < adjLists.length; i++){
			adjLists[i] = new Vertex(scan.next(), null);
		}
		
		
		//read edges
		while(scan.hasNext()){
			//reads data from file
			int v1 = indexNeighbor(scan.next());
			int v2 = indexNeighbor(scan.next());
			
			//add v2 to the front of v1's list
			//add v1 to the front of v2's list
			adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
			
			//comment this line out for directed graphs
			adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
			
		}
	}
	
	int indexNeighbor(String name){
		for(int i = 0; i < adjLists.length; i++){
			if(adjLists[i].name.equals(name)){
				return i;
			}
		}
		//only occurs if bad data in input file
		return -1;
	}
	
	public void print(){
		System.out.println();
		for(int i = 0; i < adjLists.length; i++){
			System.out.println(adjLists[i].name);
			for(Neighbor n = adjLists[i].adjList; n != null; n = n.next){
				System.out.print(" --> " + adjLists[n.vertexID].name);
			}
			System.out.println("\n");
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String file = scan.nextLine();
		Graph graph = new Graph(file);
		graph.print();
	}
}

class Neighbor {
	public int vertexID;
	public Neighbor next;
	
	public Neighbor(int id, Neighbor n){
		this.vertexID = id;
		next = n;
	}
}

class Vertex {
	String name;
	Neighbor adjList;
	
	Vertex(String name, Neighbor ns){
		this.name = name;
		this.adjList = ns;
	}
}
