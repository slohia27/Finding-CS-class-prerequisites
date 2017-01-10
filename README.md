# Finding-CS-class-prerequisites

I wrote the topological sort algorithm in TopSort using the psuedocode provided in the book for reference.
	I used a hashmap to take in the class names and then assign them to a vertex.
	By doing this I was able to access adjacent vertices in order to determine what came before another course
	indegree was also useful because the courses without an indegree (ie 1004) were courses that required no pre-reqs
		and by enqueueing the course with the indegree and then putting that on an output list we were able 
		to essentially create a recursive algorithm in which the indegree would keep being removed and adjacent
		vertices would be traced
	TopSort took in the csmajors file and it essentially evaluated which pre-reqs were needed for certain classes
	and then printed that information out via the TopVert class.
	The output of the program was a sequence of courses that one could take that satisfy the prerequisites. 
