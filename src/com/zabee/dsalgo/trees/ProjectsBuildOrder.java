package com.zabee.dsalgo.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Build Order: You are given a list of projects and a list of dependencies
 * (which is a list of pairs of projects, where the second project is dependent
 * on the first project). All of a project's dependencies must be built before
 * the project is. Find a build order that will allow the projects to be built.
 * If there is no valid build order, return an error. EXAMPLE {@code
 * 
 * Input: 
 * 		projects: a, b, c, d, e, f 
 * 		dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) 
 * Output: f, e, a, b, d, c
 * }
 * 
 * @author Zabee
 *
 */

public class ProjectsBuildOrder {

	public static void main(String[] args) {
		String[] projects = { "a", "b", "c", "d", "e", "f" };

		List<Edge> edges = new ArrayList<>();
		Edge ad = new Edge("a", "d");
		Edge fb = new Edge("f", "b");
		Edge bd = new Edge("b", "d");
		Edge fa = new Edge("f", "a");
		Edge dc = new Edge("d", "c");

		edges.add(ad);
		edges.add(fb);
		edges.add(bd);
		edges.add(fa);
		edges.add(dc);

		Graph projectGraph = new Graph(projects, edges);
		List<ProjectNode> buildOrder = getBuildOrder(projectGraph);
		buildOrder.forEach(projectOrder -> System.out.println(projectOrder));
	}

	private static List<ProjectNode> getBuildOrder(Graph projectGraph) {
		int processed = 0;
		List<ProjectNode> projectsInOrder = new ArrayList<>();
		int projectsSize = projectGraph.projectNodeList.size();
		while (processed < projectsSize) {
			ProjectNode projectNode = getIndNode(projectGraph.projectNodeList);
			if (projectNode == null) {
				System.out.println("Project has loop or in a state that cannot help to build!!");
				System.exit(0);
			} else {
				projectGraph.projectNodeList.remove(projectGraph.projectNodeMap.get(projectNode.name));
				projectsInOrder.add(projectNode);
				for (ProjectNode child : projectNode.children) {
					child.dependencies--;
				}
				processed++;
			}
		}

		return projectsInOrder;
	}

	private static ProjectNode getIndNode(List<ProjectNode> argPNList) {
		Optional<ProjectNode> projectNode = argPNList.stream().filter(pn -> pn.dependencies == 0).findAny();
		return projectNode.get();
	}

	private static class Edge {
		String src, dst;

		public Edge(String argSrc, String argDst) {
			src = argSrc;
			dst = argDst;
		}

	}

	private static class Graph {
		List<ProjectNode> projectNodeList = new ArrayList<>();
		Map<String, ProjectNode> projectNodeMap = new HashMap<>();

		public Graph(String[] projectNodes, List<Edge> edges) {
			for (String pnStr : projectNodes) {
				ProjectNode pn = new ProjectNode(pnStr);
				projectNodeList.add(pn);
				projectNodeMap.put(pnStr, pn);
			}

			for (Edge edge : edges) {
				ProjectNode srcNode = projectNodeMap.get(edge.src);
				ProjectNode dstNode = projectNodeMap.get(edge.dst);
				dstNode.dependencies++;
				srcNode.children.add(dstNode);
			}
		}
	}

	static class ProjectNode {
		String name;
		List<ProjectNode> children = new ArrayList<>();
		int dependencies;

		public ProjectNode(String n) {
			this.name = n;
		}

		@Override
		public String toString() {
			return name;
		}
	}
}