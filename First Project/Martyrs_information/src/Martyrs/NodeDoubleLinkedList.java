package Martyrs;

public class NodeDoubleLinkedList implements Comparable<NodeDoubleLinkedList> {

	private String location;
	private SingelLinkedList listMartyrs;
	private NodeDoubleLinkedList next;
	private NodeDoubleLinkedList previous;

	public NodeDoubleLinkedList(String location, SingelLinkedList list) {
		super();
		this.listMartyrs = list;
		this.location = location;
	}

	public NodeDoubleLinkedList(String location) {
		super();
		this.location = location;
		this.listMartyrs=new SingelLinkedList();
	}
	
	public NodeDoubleLinkedList() {
		super();
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public SingelLinkedList getListMartyrs() {
		return listMartyrs;
	}

	public void setListMartyrs(SingelLinkedList listMartyrs) {
		this.listMartyrs = listMartyrs;
	}

	public NodeDoubleLinkedList getNext() {
		return next;
	}

	public void setNext(NodeDoubleLinkedList next) {
		this.next = next;
	}

	public NodeDoubleLinkedList getPrevious() {
		return previous;
	}

	public void setPrevious(NodeDoubleLinkedList previous) {
		this.previous = previous;
	}

	
	

	@Override
	public String toString() {
		return "NodeDoubleLinkedList [location=" + location + "]";
	}

	@Override
	public int compareTo(NodeDoubleLinkedList o) {
	    return this.getLocation().compareToIgnoreCase(o.getLocation());

		
	}

	@Override
	public boolean equals(Object obj) {
		return this.getLocation().equalsIgnoreCase(((NodeDoubleLinkedList)obj).getLocation());
	}

	
	
}
