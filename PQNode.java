

public class PQNode<P,T> {
    
    public T data;
    public P p;
    public PQNode<P,T> next; 
    
    public PQNode(){
        next = null;
    }
    
    public PQNode (P p , T e){
        data = e;
        this.p =p;
    }
            
    
}
