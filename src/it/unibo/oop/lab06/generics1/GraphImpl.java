package it.unibo.oop.lab06.generics1;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	
	private Map <N, Set<N>> nodes;
	
	public GraphImpl() {
		super();
		this.nodes = new LinkedHashMap<>();
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
