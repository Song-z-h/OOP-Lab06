package it.unibo.oop.lab06.generics1;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	
	private Map <N, Set<N>> nodes;
	
	public GraphImpl() {
		super();
		this.nodes = new LinkedHashMap<>();
	}

	public GraphImpl(Map<N, Set<N>> nodes) {
		super();
		this.nodes = new LinkedHashMap<>(nodes);
	}

	@Override
	public void addNode(N node) {
		if(!nodeAlreadyExist(node)) {
			nodes.put(node, new LinkedHashSet<N>());
		}
	}
	
	private boolean nodeAlreadyExist(N node){
		return nodes.containsKey(node);
	}

	@Override
	public void addEdge(N source, N target) {
		Set<N> edgeds = nodes.get(source);
		if(edgeds != null) {
			edgeds.add(target);
		}
	}

	@Override
	public Set<N> nodeSet() {
		Set<N> allnodes = new LinkedHashSet<N>();
		for(var entry : nodes.entrySet()) {
			allnodes.add(entry.getKey());
		}
		return allnodes;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		Set<N> edgeds = nodes.get(node);
		if(edgeds != null) {
			return new LinkedHashSet<>(edgeds);
		}
		return new LinkedHashSet<N>(Collections.emptySet());
	}

	@Override
	public List<N> getPath(N source, N target) {
		Set<N> alreadyVisited = new LinkedHashSet<>();
		Queue<N> nodeToVisit = new LinkedList<>();
		nodeToVisit.add(source);
		Map<N, N> itsParent = new LinkedHashMap<>();
		
			while(!nodeToVisit.isEmpty()){
				N node = nodeToVisit.poll();
				if(node.equals(target)) {
					System.out.println(node);
					break;
				}
				
					alreadyVisited.add(node);
					for(var edgeds : this.linkedNodes(node)) {
						if(!alreadyVisited.contains(edgeds)) {
						nodeToVisit.add(edgeds);
						itsParent.put(edgeds, node);
						
					}
			}			
			
		}
		
		return null;
	}
	
}
