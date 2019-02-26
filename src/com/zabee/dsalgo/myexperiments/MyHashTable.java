package com.zabee.dsalgo.myexperiments;

/**
 * Don't confuse this with Java's HashTable, that DS is synchronized and generic
 * this is only for integers and not at all synchronous in anyway Overall
 * runtime is "amortized" O(1) not just O(1). It also depends on the size of
 * array and number of collisions. Number of collisions will be less if the size
 * of array is bigger
 * 
 * @author Zabee
 *
 */
public class MyHashTable {

	private int size;
	Node start;
	Node[] linkedList;

	/**
	 * O(1+1) ==> O(2) drop the constatn so, O(1)
	 * 
	 * @param argSize
	 */
	public MyHashTable(int argSize) {
		size = argSize;
		linkedList = new Node[size];
	}

	/**
	 * Upper bound worst case run time is O(n)
	 * 
	 * @param argKey
	 * @param argValue
	 */
	public final void put(final int argKey, final int argValue) {
		int i = getIndex(argKey);
		Node newNode = new Node(argKey, argValue);
		boolean overWroteExisting = false;
		if (linkedList[i] == null) {
			linkedList[i] = newNode;
		} else {// Add link and save it
			start = linkedList[i];
			Node actualNode = null;
			while (start != null) {
				if (start.key == newNode.key) { // if any existing node has same key as the new node key then insert the
												// node properly
					newNode.link = start.link;
					start = newNode;
					overWroteExisting = true;
					break;
				}
				actualNode = start;
				start = linkedList[i].link;
			}
			if (!overWroteExisting) {
				actualNode.link = newNode;
			}
		}
	}

	/**
	 * Upper bound worst case runtime O(n)
	 * 
	 * @param argKey
	 * @return
	 */
	public final String get(final int argKey) {
		int i = getIndex(argKey);
		Integer value = null;
		start = linkedList[i];
		while (start != null) {
			if (start.key == argKey) {
				value = start.value;
				break;
			}
			start = linkedList[i].link;
		}
		return value == null ? null : String.valueOf(value);
	}

	/**
	 * Upper bound worst case runtime O(1)
	 * 
	 * @param argKey
	 * @return
	 */
	private final int getIndex(final int argKey) {
		int hashedValue = hashCode(argKey);
		return hashedValue % size;
	}

	/**
	 * Upper bound worst case runtime is O(1)
	 * 
	 * @param argKey
	 * @return
	 */
	private final int hashCode(int argKey) {
		argKey = argKey >> 1;
		return argKey;
	}

	/**
	 * Upper bound worst case runtime is O(n*m) where is
	 */
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		for (Node node : linkedList) { // This means for every key having same hash value
			if (node != null) {
				strBuff.append("|HashKey->" + node.key + "|	");
				start = node;
				while (start != null) {
					strBuff.append("[Key" + start.key);
					strBuff.append("|Value" + start.value + "]	");
					start = start.link;
				}
				strBuff.deleteCharAt(strBuff.length() - 1);
				strBuff.append("\n");
			}
		}

		return strBuff.toString();
	}

	private class Node {
		private int key;
		private int value;
		private Node link;

		public Node(int argNodeKey, int argNodeValue) {
			this.key = argNodeKey;
			this.value = argNodeValue;
		}
	}
}
