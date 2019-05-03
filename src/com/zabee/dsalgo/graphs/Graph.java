package com.zabee.dsalgo.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Below is a sample graph
 * 
 *		1 - 2 - 3 - 4
 * 		|		    | 	
 * 		5 - 7 - 8 - 9 - 10	
 * 		|
 * 		6 - 0
 * 
 * 	It's a directed graph. So, 1 to 5 is possible but not 5 to 1.
 * 
 * @author Zabee 
 *
 */
public class Graph {
	List<GraphNode> nodes = new ArrayList<GraphNode>();
	Map<Integer, GraphNode> graphNodeMap = new HashMap<Integer, GraphNode>();
	GraphNode graphRoot;

	/**
	 * Assuming all the node values will be unique. As the node data/value is the
	 * key to get it from graph node
	 * 
	 * @param argData
	 */
	public GraphNode createOrGetNode(final int argData) {
		if (graphNodeMap.get(argData) == null) {
			GraphNode graphNode = new GraphNode(argData);
//			System.out.println("Created " + argData);
			graphNodeMap.put(graphNode.data, graphNode);
			nodes.add(graphNode);
			if(argData == 1) {
				graphRoot = graphNode;
			}
		}
		return graphNodeMap.get(argData);
	}

	public void addEdge(GraphNode gNode1, GraphNode gNode2) {
		if (gNode1 != null) {
			gNode1.addNeighbour(gNode2);
		}
	}

	private void clearVisitedFlagForAll() {
		for (GraphNode graphNode : nodes) {
			graphNode.visited = false;
		}
	}

	public void DFS(GraphNode graphRoot) {
		if (graphRoot == null) {
			return;
		}
		System.out.print("|" + graphRoot.data + "|");
		for (GraphNode gNode : graphRoot.getAllChildren()) {
			if (gNode.visited == false) {
				gNode.visited = true;
				DFS(gNode);
			}
		}
	}
	
	public void BFS() {
		clearVisitedFlagForAll();
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		// Thanks to ArrayList for its feature of maintaining insertion order
		queue.add(graphRoot);
		GraphNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.remove();
			System.out.print("|" + temp.data + "|");
			for (GraphNode gNode : temp.getAllChildren()) {
				if (!gNode.visited) {
					gNode.visited = true;
//					System.out.println("Adding |"+ gNode.data +"| to queue ");
					queue.add(gNode);
				}
			}
		}
	}
	
	public boolean isPathBetween(GraphNode src, GraphNode dst) {
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(src);
		GraphNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.remove();
			if (temp.data == dst.data) {
				return true;
			}
			for (GraphNode graphNode : temp.getAllChildren()) {
				if (!graphNode.visited) {
					graphNode.visited = true;
					queue.add(graphNode);
				}
			}
		}
		return false;
	}
	
	private class GraphNode {
		private int data;
		private List<GraphNode> adjacentNodes = new ArrayList<GraphNode>();
		private Map<Integer, GraphNode> adjacentNodeMap = new HashMap<Integer, Graph.GraphNode>();
		private boolean visited;

		private GraphNode(final int argData) {
			data = argData;
		}

		public void addNeighbour(GraphNode argGraphNode) {
			if (adjacentNodeMap.get(argGraphNode.data) == null) {
				adjacentNodes.add(argGraphNode);
				adjacentNodeMap.put(argGraphNode.data, argGraphNode);
			}
		}

		public int getNodeChildrenCount() {
			return adjacentNodes.size();
		}
		
		public List<GraphNode> getAllChildren(){
			return adjacentNodes;
		}
	}

	 /*		1 - 2 - 3 - 4
	 * 		|		    | 	
	 * 		5 - 7 - 8 - 9 - 10	
	 * 		|
	 * 		6 - 0
	 */
	public static void main(String... args) {
		Graph graph = new Graph();
		for(int i=0; i<=10; i++) {
			graph.createOrGetNode(i);	
		}
		//For 0 nothing 
		//For 1 
		graph.addEdge(graph.createOrGetNode(1), graph.createOrGetNode(2));
		graph.addEdge(graph.createOrGetNode(1), graph.createOrGetNode(5));
		
		//For 2
		graph.addEdge(graph.createOrGetNode(2), graph.createOrGetNode(3));

		//For 3
		graph.addEdge(graph.createOrGetNode(3), graph.createOrGetNode(4));

		//For 4
		graph.addEdge(graph.createOrGetNode(4), graph.createOrGetNode(9));

		//For 5
		graph.addEdge(graph.createOrGetNode(5), graph.createOrGetNode(6));
		graph.addEdge(graph.createOrGetNode(5), graph.createOrGetNode(7));
		
		//For 6
		graph.addEdge(graph.createOrGetNode(6), graph.createOrGetNode(0));
		
		//For 7
		graph.addEdge(graph.createOrGetNode(7), graph.createOrGetNode(8));
		
		//For 8
		graph.addEdge(graph.createOrGetNode(8), graph.createOrGetNode(9));

		//For 9
		graph.addEdge(graph.createOrGetNode(9), graph.createOrGetNode(10));
		
		//For 10 nothing
		
		if (args.length > 0) {
			// This class is called from another class. So, let's entertain it.
			System.out.println(
					"\n\nIs there a path between " + Integer.valueOf(args[0]) + " and " + Integer.valueOf(args[1])
							+ ": " + graph.isPathBetween(graph.createOrGetNode(Integer.valueOf(args[0])),
									graph.createOrGetNode(Integer.valueOf(args[1]))));
			return;
		}
		System.out.println("\nBreadth First Search traversal of the graph");
		graph.BFS();
		graph.clearVisitedFlagForAll();
		
		System.out.println("\n\nDepth First Search traversal of the graph");
		graph.DFS(graph.graphRoot);
		graph.clearVisitedFlagForAll();
		
		System.out.println("\n\nIs there a path between 1 and 0?: " + graph.isPathBetween(graph.createOrGetNode(1), graph.createOrGetNode(0)));
		graph.clearVisitedFlagForAll();
		
		System.out.println("\n\nIs there a path between 0 and 1?: " + graph.isPathBetween(graph.createOrGetNode(0), graph.createOrGetNode(1)));
		
		
	}
}
