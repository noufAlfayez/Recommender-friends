public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
    
    
	public BSTNode<K, T> root; // Do not change this// Do not change this
        private BSTNode<K, T>  current;
        int size;
        
        
	public BSTMap() {
		current = root = null;
                size = 0;
	}

    @Override
    public int size() {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return size;
    }

    @Override
    public boolean full() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    @Override
    public void clear() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       root = null;
       size = 0;
    }

    @Override
    public boolean update(K k, T e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(remove(k))
        return insert(k,e);
       return false;
    }
 
    @Override
    public Pair<Boolean, T> retrieve(K k) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Pair<Boolean , T> t = null;       
       boolean f = false;
         if(find_key(k)){
             f = true;
             t=new Pair(f,current.data);
             return t;
         }
        return new Pair(f,null);     
    }

    @Override
    public boolean insert(K k, T e) {
        BSTNode<K, T> tmp =new BSTNode<K, T> (k,e);
         if (root == null){
           root = tmp;
           size++;
           return true;
         }
        else {
         BSTNode<K, T>  node = root;
        while (true) {
            if (k.compareTo(node.key)>0) { 
                    if (node.right != null) { 
                        node = node.right;
                    } else { 
                        node.right = tmp;
                        size++;
                        return true;
                    }
                } else if (k.compareTo(node.key)<0) {
                if (node.left != null) {
                    node = node.left;
            } else {
                node.left = tmp;
                size++;
                return true;
            }
            } else {
                    return false;
            }
          }
        }
     
    }

    @Override
    public boolean remove(K k) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       if(!find_key(k))
           return false;
       if(size == 0)
           return false;
   
    K k1 = k;
    BSTNode<K, T>  t= root;
    BSTNode<K, T>  q= null;
    while (t != null){
        if(k1.compareTo(t.key) > 0){
             q = t;
            t = t.right;
        }
        else if (k1.compareTo(t.key) < 0){
            q=t;
            t=t.left;
        }
        else{
            if((t.left != null)&& (t.right != null)){
                BSTNode<K, T> min = t.right;
                q = t;
                while(min.left != null){
                   q = min;
                   min = min.left;
                }
                t.key = min.key;
                t.data = min.data;
                k1 = min.key;
                t = min;
            }
            if(t.left != null){
                t = t.left;
            }
            else {
                t = t.right;
            }
            if( q == null){
              root = q;  
            }
            else {
               if(k1.compareTo(q.key)<0){
                    q.left = t;
                }
                else{
                    q.right = t;
                }  
            }
            current = root;
            size--;
            return true;
        }
    }
    return false;
    }
    @Override
    public List<K> getKeys() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       List<K> l1 = new LinkedList<>();
      if(root!=null)
          ord(root,l1);
       return l1;
    }
    
    private boolean find_key(K k){
        BSTNode<K, T> p = root;
        BSTNode<K, T> q = root;
        if(root == null)
            return false;
        
        while(p != null){
            q = p;
            if(p.key.compareTo(k)==0){
                current =p;
                return true;
            }
            else if(p.key.compareTo(k)>0)
                p = p.left;
            else
                p = p.right;
        }
        current = q;
        return false;
        
    }
   private void ord(BSTNode<K, T> p, List<K> k){
       if(p.left!=null)
           ord(p.left,k);
       
       k.insert(p.key);
       
       if(p.right!=null)
           ord(p.right,k);
   }
}

