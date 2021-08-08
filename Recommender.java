
import java.io.File;
import java.util.Scanner;

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
   public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
       if(g == null)
           return null;
      if (!g.isNode(i)) 
         return null;
      List<K> l1 = g.getNodes();
      if(l1.empty())
         return null;
      
      else {
         PQK<Double, K> q = new PQKImp<>(k);
         l1.findFirst();
                
         while(!l1.last()) {
            if (l1.retrieve().compareTo(i) != 0 && !g.isEdge(i, l1.retrieve())) {
               q.enqueue((double) g.deg(l1.retrieve()), l1.retrieve());
            }
            l1.findNext(); 
         }
                
         if (l1.retrieve().compareTo(i) != 0 && !g.isEdge(i, l1.retrieve())) {
            q.enqueue((double) g.deg(l1.retrieve()), l1.retrieve());
         }
         return q;
      }   
   }
	// Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
   public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
       try{
       if(g == null)
           return null;
      if (!g.isNode(i)) 
         return null;
     
      PQK<Double, K> q = new PQKImp<>(k);
            
      List<K> l1 = g.getNodes();
      if (l1.empty()) 
         return null;
            
      l1.findFirst();
      while(!l1.last()) {
                
         if (l1.retrieve().compareTo(i) != 0 && !g.isEdge(i, l1.retrieve())) {
            List<K> a=g.neighb(l1.retrieve());
            List<K> b= g.neighb(i);
            double  n = 0;
                    
            if (!a.empty() && !b.empty()) {
               a.findFirst();
               while (!a.last()) {
                  if (b.exists(a.retrieve())) {
                     n++;
                  }
                  a.findNext();
               }
                        
               if (b.exists(a.retrieve())) {
                  n++;
               }
            }
                    
            q.enqueue(n, l1.retrieve());
         }
         l1.findNext();
      }
            
    if (l1.retrieve().compareTo(i) != 0 && !g.isEdge(i, l1.retrieve())) {
          
         List<K> a=g.neighb(l1.retrieve());
         List<K> b= g.neighb(i);
         
         double  n = 0;
         
         if (!a.empty() && !b.empty()) {
            a.findFirst();
            while (!a.last()) {
               if (b.exists(a.retrieve())) {
                  n++;
               }
               a.findNext();
            }
                        
            if (b.exists(a.retrieve())) {
               n++;
            }
         }
         q.enqueue(n, l1.retrieve());
      }
      return q;
       }catch(Exception e){
           return null;
       }
        //return null;
   }
	// Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
   public static Graph<Integer> read(String fileName) {
   
      try {
         Graph<Integer> g = new MGraph<Integer>();
         Scanner scanner = new Scanner(new File(fileName));
         while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            g.addNode(i);
            int j = scanner.nextInt();
            g.addNode(j);
            g.addEdge(i, j);
         }
         scanner.close();
         return g;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
}
/*
       
*/