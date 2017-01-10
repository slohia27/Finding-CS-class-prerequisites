//Surbhi Lohia sl3893
//April 21 2016

import java.util.LinkedList;

class TopVert {
	public String data;
	public int dist;
	public int inDegree;
	//create a list of adjacenet vertices
	LinkedList<TopVert> AdjacenctVert = new LinkedList<TopVert>();
	
	//creating method add adjacent vertex
	public void addAdjVert(final TopVert Child) {
		AdjacenctVert.add(Child);
		Child.inDegree++;
	}

	public TopVert(String data) {
		super();
		this.data = data;
	}
	public String toString()
	{
		return data;
	}
}
