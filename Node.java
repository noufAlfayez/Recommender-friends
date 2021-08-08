public class Node<T>{
	
	public T data ; 
	public Node <T> next ; 
	//private int s;
	public Node (){
	data = null;
	next = null;
	//s=0;
	}
	public Node (T e ) {

	data = e; 
	next = null ;
	
	}
}