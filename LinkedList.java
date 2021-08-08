/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class LinkedList<T> implements List<T> {
    
	private Node<T> head;
	private Node<T> current;
        private int size;
        
	public LinkedList () {
		head = current = null;
                
	} 

	public boolean empty () {
		return head == null;
	}

	public boolean last () {
		return current.next == null;
	}
   public boolean full () {
		return false;
	}
	public void findFirst () {
		current = head;
	}
	public void findNext () {
		current = current.next;
	}
	public T retrieve () {
           // if(current != null)
		return current.data;
            //return null;
	}
	public void update (T e) {
		current.data = e;
	}
  	public void insert (T e) {
		Node<T> tmp;
		if (empty()) {
			current = head = new Node<T> (e);
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (e);
			current = current.next;
			current.next = tmp;
		}
                size++;
	}

  	public void remove () {
		if (current == head) {
			head = head.next;
		}
		else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
                
                size--;
	}

        public int size(){
            return size;
        }

    @Override
    public boolean exists(T e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Node<T> t = head;
        while(t!=null){
            if(t.data.equals(e))
                return true;
            t=t.next;
        }
        return false;
    }

}
     