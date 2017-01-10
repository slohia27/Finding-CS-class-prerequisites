//Surbhi Lohia sl3893

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class TopSort {

	TopSort topSort = new TopSort();
	static HashMap <String, TopVert> vertexMap = new HashMap<String, TopVert>();

	//this output list is the linkedlist


	public static void topologicalSort(Graph graph) {
		//create a queue of type TopVert 
		Queue<TopVert> q = new LinkedList<TopVert>();
		int movealong = 0;
		
		for (TopVert m : graph.vertices) {
			if (m.inDegree == 0) {
				++movealong;
				q.add(m);
				System.out.println(m.data);
			}
		}
		//when the queue isn't empty you take off the top element
		while (!q.isEmpty()) {
			TopVert m = q.poll();

			for (TopVert child : m.AdjacenctVert) {
				--child.inDegree;
				if (child.inDegree == 0) {
					q.add(child);
					++movealong;
					System.out.println(child.data);
				}
			}
		}
		if (movealong > graph.count) {
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		Graph g = new Graph();
		//reading in the file
		BufferedReader file = new BufferedReader(new FileReader ("csmajors.txt"));
		String line = null;


		// Read each line and create node if not already present
		while ((line = file.readLine()) != null){

			String courses[] = line.split(" ");
			TopVert n = null;
			for (int i = 0; i < courses.length ; i++) {
				System.out.println("Courses "  + courses[i]);
				if (i == 0) {
					if ((n = vertexMap.get(courses[i])) == null )
					{
						n = new TopVert(courses[i]);
						g.vertices.add(n);
						vertexMap.put(courses[i],n);

					}
					else
					{
						n.inDegree++;
					}

				}    
				else {
					TopVert adjVert = null;
					if (( adjVert = vertexMap.get(courses[i])) == null )
					{
						adjVert = new TopVert(courses[i]);
						n.AdjacenctVert.add(adjVert);
						n = adjVert;
						vertexMap.put(courses[i],adjVert);

					}
					else 
					{
						adjVert.inDegree++;

					}

				}
			}
		}

		file.close();
		System.out.println("Now calling the topologial sorts");
		topologicalSort(g);
		for (TopVert t: g.vertices) {
			System.out.println(t.toString());

		}
		}

	}



class Graph {
	public int count;
	LinkedList<TopVert> vertices = new LinkedList<TopVert>();

}