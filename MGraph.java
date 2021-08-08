
public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Map<K, List<K>> adj; // Do not change this
        
	public MGraph() {
	adj = new BSTMap<>();
	}
	
    @Override
     public boolean addNode(K i) {
        List l1 = new LinkedList();
       if(adj.retrieve(i).first)
           return false;
       
       else {
           adj.insert(i, l1);
            return true;
       }
    }

    @Override
   public boolean isNode(K i) {
       if(adj == null)
           return false;
       
        return adj.retrieve(i).first;
    }

    @Override
 public boolean addEdge(K i, K j) {

              if(adj == null)
                return false;
       
           if(!adj.retrieve(i).first)
                return false;
            if(adj.retrieve(i).second.exists(j))
                return false;
            adj.retrieve(i).second.insert(j);
            if(!adj.retrieve(i).first)
                return false;
            if(adj.retrieve(j).second.exists(i))
                return false;
            
            adj.retrieve(j).second.insert(i);
            return true;
    }

    @Override
    public boolean isEdge(K i, K j) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       // Pair p = adj.retrieve(i);
        if(adj.retrieve(i).first && adj.retrieve(j).first){
        List a = adj.retrieve(i).second;
        //Pair q = adj.retrieve(j);
        List b = adj.retrieve(j).second;
        
        if(a.exists(j)&& b.exists(i))
            return true;
        }
        return false;
    }

    @Override
    public List<K> neighb(K i) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       List l = new LinkedList<>();
      // Pair p = adj.retrieve(i);
      if(adj.size()==0)
          return l;
      
        
            if(adj.retrieve(i).first==false && !adj.retrieve(i).second.exists(i))
                return l;
         //if(adj.retrieve(i).first==true)   
             l = adj.retrieve(i).second;
        
        return l;
    }
    
    @Override
    public int deg(K i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          Pair p = adj.retrieve(i);
           if(p.second!=null){
          List a = (List) p.second;
          if(a!= null)
          return a.size();
         }
          return -1;
    }

    @Override
    public List<K> getNodes() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return adj.getKeys();
    }
}

