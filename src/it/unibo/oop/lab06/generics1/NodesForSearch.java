package it.unibo.oop.lab06.generics1;

import java.util.Map;
import java.util.Set;

enum Color{
	WHITE, GREY, BLACK
}

public class NodesForSearch<N> extends GraphImpl<N> {
	
	private Color nodeColor;
	private N parentNode;
	
	public NodesForSearch(Map<N, Set<N>> nodes) {
		super(nodes);
		this.nodeColor = Color.WHITE;
		this.parentNode = null;
	}

	public Color getNodeColor() {
		return nodeColor;
	}

	public void setNodeColor(Color nodeColor) {
		this.nodeColor = nodeColor;
	}

	public N getParentNode() {
		return parentNode;
	}

	public void setParentNode(N parentNode) {
		this.parentNode = parentNode;
	}
	
	
	
	
	
}
