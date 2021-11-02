package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int ELEMS = 100_000;
	private static final int TO_MS = 1_000_000;

	private UseCollection() {
	}

	/**
	 * @param s unused
	 */
	public static void main(final String... s) {
		/*
		 * 1) Create a new ArrayList<Integer>, and populate it with the numbers from
		 * 1000 (included) to 2000 (excluded).
		 */
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 1000; i <= 2000; i++) {
			al.add(i);
		}
		/*
		 * 2) Create a new LinkedList<Integer> and, in a single line of code without
		 * using any looping construct (for, while), populate it with the same contents
		 * of the list of point 1.
		 */
		LinkedList<Integer> ll = new LinkedList<Integer>(al);

		/*
		 * 3) Using "set" and "get" and "size" methods, swap the first and last element
		 * of the first list. You can not use any "magic number". (Suggestion: use a
		 * temporary variable)
		 */
		int tmp = al.get(0);
		al.set(0, al.get(al.size() - 1));
		al.set(al.size() - 1, tmp);

		// System.out.println(al);
		/*
		 * 4) Using a single for-each, print the contents of the arraylist.
		 */

		for (int elem : al) {
			// System.out.print(elem + ", ");
		}
		/*
		 * 5) Measure the performance of inserting new elements in the head of the
		 * collection: measure the time required to add 100.000 elements as first
		 * element of the collection for both ArrayList and LinkedList, using the
		 * previous lists. In order to measure times, use as example
		 * TestPerformance.java.
		 */
		long time = System.nanoTime();
		for (int i = 0; i < ELEMS; i++) {
			al.add(0, i);
		}
		time = System.nanoTime() - time;

		System.out.println("Add " + ELEMS + " int to the head of ArrayList " + time + "ns (" + time / TO_MS + "ms)");

		time = System.nanoTime();
		for (int i = 0; i < ELEMS; i++) {
			ll.addFirst(i);
		}

		time = System.nanoTime() - time;
		System.out.println("Add " + ELEMS + " int to the head of LinkedList " + time + "ns (" + time / TO_MS + "ms)");

		/*
		 * 6) Measure the performance of reading 1000 times an element whose position is
		 * in the middle of the collection for both ArrayList and LinkedList, using the
		 * collections of point 5. In order to measure times, use as example
		 * TestPerformance.java.
		 */

		time = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			al.get(al.size() / 2);
		}
		time = System.nanoTime() - time;
		System.out.println("Read " + ELEMS + " int to the head of ArrayList " + time + "ns (" + time / TO_MS + "ms)");

		time = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			ll.get(ll.size() / 2);
		}
		time = System.nanoTime() - time;
		System.out.println("Add " + ELEMS + " int to the head of LinkedList " + time + "ns (" + time / TO_MS + "ms)");

		/*
		 * 7) Build a new Map that associates to each continent's name its population:
		 * 
		 * Africa -> 1,110,635,000
		 * 
		 * Americas -> 972,005,000
		 * 
		 * Antarctica -> 0
		 * 
		 * Asia -> 4,298,723,000
		 * 
		 * Europe -> 742,452,000
		 * 
		 * Oceania -> 38,304,000
		 */
		Map<String,Long> world = new HashMap<>();
		world.put("Africa", 1_110_635_000L);
		world.put("Americas", 972_005_000L);
		world.put("Antarctica", 0L);
		world.put("Asia", 4_298_723_000L);
		world.put("Europe", 742_452_000L);
		world.put("Oceania", 38_304_000L);
		System.out.println(world);
		long sum = 0;
		for(var v : world.values()) {
			sum += v;
		}
		System.out.println("World 's population is : " + sum);
		/*
		 * 8) Compute the population of the world
		 */
	}
}
