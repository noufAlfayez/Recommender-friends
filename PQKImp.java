public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {
    private int size;
    private PQNode<P,T> Head , Tail;
    int max;
	public PQKImp(int k) {
		Head = null;
                Tail = null;
                size = 0;
                max = k;
	}
    @Override
    public int length() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return size;
    }
    @Override
   
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         public void enqueue(P pr, T e) {
             
         PQNode<P, T> tmp = new PQNode<>(pr, e);
             if (size < max) {
                if (Head == null) {
                    Head = Tail = tmp;
                    } 
                
                  else if(pr.compareTo(Head.p)>0){
                    tmp.next = Head;
                    Head = tmp;
                      }
                  
                else {
                PQNode<P, T> p = null;
                PQNode<P, T> q = Head;
                while (q != null && pr.compareTo(q.p) <= 0) {
                        p = q;
                        q = q.next;
                }
                p.next=tmp;
                 tmp.next = q; 
                 if (tmp.next == null) {
                    Tail = tmp;
                    }
                if(p != null) {
                    p.next = tmp;
                }
                if(q==null)
                    Tail = tmp;
        }
        size++;
        }
        
       else if(size == max && pr.compareTo(Tail.p) > 0) {
        //  boolean f = false;
       if(pr.compareTo(Head.p)>0){
           tmp.next = Head;
           Head = tmp;
          // f = true;
       }
       else{
        PQNode<P,T> p = Head;
        PQNode<P,T> q = null;  
        
    while (p!=null && pr.compareTo(p.p)<=0){
        q=p;
        p = p.next;
    }
    
    q.next=tmp;
    tmp.next=p;
       if(p==null)
          Tail=tmp;
    }
       }
         }
    @Override
    public Pair<P, T> serve() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
           Pair<P,T> pq = null;//new Pair<>(node.p,node.data);
           if(Head != null){
       PQNode<P,T> node = Head;
       pq = new Pair<>(node.p,node.data);
       Head = Head.next;
       size --;
       if(Head == null)
           Tail = null;
           }
       return pq;
           
    }catch(Exception e){
        return null;
    }
    } 
}
