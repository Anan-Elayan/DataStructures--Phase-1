package Martyrs;

public class SingelLinkedList implements MethodsSingelLinkedList {

	private NodeSigleLinkedList first;
	private NodeSigleLinkedList last;
	private int count = 0;

	
	// to return first node from single linked list
	@Override
	public NodeSigleLinkedList getFirst() {//O(1)
		return this.first;
	}

	
	
	
	// to return last node from single linked list
	@Override
	public NodeSigleLinkedList getLast() {
		return this.last;
	}

	
	
	
	// in this method remove first node;
	// O(1)
	@Override
	public boolean removeFirst() {
		if (count == 0) {
			return false;
		} else if (count == 1) {
			this.first = null;
			this.last = null;
		} else {
			this.first = this.first.getNext();
		}
		count--;
		return true;
	}

	
	
	// in this method remove last node;
	//O(n)
	@Override
	public boolean removeLast() {
		if (count == 0) {
			return false;
		} else if (count == 1) {
			this.first = null;
			this.last = null;
		} else {
			NodeSigleLinkedList temp = this.first;
			for (int i = 0; i < count - 2; i++) {
				temp = temp.getNext();
			}
			this.last = temp;
			this.last.setNext(null);
		}
		count--;
		return true;
	}

	
	
	
	// in this method remove last node;
	@Override
	public boolean removeAtIndex(int index) {
		if (index == 0) {
			return removeFirst();
		} else if (index == count) {
			return removeLast();
		} else if (index <= 0 || index > count) {
			return false;
		} else {
			NodeSigleLinkedList prev = null;
			NodeSigleLinkedList temp = null;
			temp = this.first;
			for (int i = 0; i < index; i++) {
				prev = temp;
				temp = temp.getNext();
			}
			prev.setNext(temp.getNext());
			temp.setNext(null);
			count--;
		}

		return true;
	}

	
	
	
	// in this method that remove object ;
	@Override
	public boolean removObj(NodeSigleLinkedList target) {

		if (count == 0) {
			return false;
		}
		if (this.first.equals(target)) {
			return removeFirst();
		} else if (this.last.equals(target)) {
			return removeLast();
		} else {
			NodeSigleLinkedList prev = null;
			NodeSigleLinkedList temp = this.first;
			for (int i = 0; i < count; i++) {
				if (target.equals(temp)) {
					prev.setNext(temp.getNext());
					count--;
					return true;
				}
				prev = temp;
				temp = temp.getNext();
			}
		}
		return false;
	}

	
	
	
	// in this method that search specific object ;
	@Override
	public SingelLinkedList search(String name) {
		SingelLinkedList sList = new SingelLinkedList();
		NodeSigleLinkedList temp = this.first;
		while (temp != null) {
			if (temp.getObjMartyrs().getName().toLowerCase().contains(name.toLowerCase())) {
				sList.addLast(new NodeSigleLinkedList(temp.getObjMartyrs()));
			}
			temp = temp.getNext();
		}
		return sList;
	}

	
	
	// in this method we need to add node at header
	@Override
	public void addFirst(NodeSigleLinkedList target) {
		if (count == 0) {
			this.first = this.last = target;
		} else {
			target.setNext(this.first);
			this.first = target;
		}
		count++;
	}

	
	
	
	// in this method we need to add node at tail
	@Override
	public void addLast(NodeSigleLinkedList target) {
		if (count == 0) {
			this.first = this.last = target;
		} else {
			this.last.setNext(target);
			this.last = target;
		}
		count++;
	}
	
	
	

	// in this method we need to add node at tail
	@Override
	public void addNode(NodeSigleLinkedList target, int index) {
		NodeSigleLinkedList temp = this.first;
		if (count == 0) {
			this.first = this.last = target;
			addFirst(target);
		} else if (index <= 0) {
			addFirst(target);
		} else if (index > count) {
			addLast(target);
		} else {
			for (int i = 0; i < index - 1; i++) {
				temp = temp.getNext();
			}
			target.setNext(temp.getNext());
			temp.setNext(target);
			count++;
		}

	}

	// in this method to store info from file in linkedList sorted
	@Override
	public void addNodeSorted(NodeSigleLinkedList newNode) { // O(n)
		if (count == 0 && newNode != null) { // Nothing any node
			addFirst(newNode);
		} else {
			if (newNode != null) { //exit
				NodeSigleLinkedList temp = newNode;
				NodeSigleLinkedList current = this.first;
				NodeSigleLinkedList previous = null;
				if (newNode.compareTo(current) < 0) {
					addFirst(newNode);
				} else {
					while ((current != null) && (newNode.compareTo(current) >= 0)) {
						previous = current;
						current = current.getNext();
					}
					previous.setNext(temp);
					if (current == null)
						this.last = temp;
					temp.setNext(current);
					this.count++;
				}
			}

		}
	}

	@Override
	public String toString() {
		String s = "";
		NodeSigleLinkedList curent = first;
		while (curent != null) {
			s += curent + "\n";
			curent = curent.getNext();
		}
		return s;
	}

	@Override
	public int size() {
		return count;

	}

	// print list
	@Override
	public void printList() {
		NodeSigleLinkedList temp = first;
		if (count == 0) {
			return;
		}
		while (temp != null) {
			temp = temp.getNext();
		}
	}

}
