import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StableMatchGaleShapleyAlgorithm {

	public static void main(String[] args) {
		List<Integer>men = new ArrayList<Integer>();
           men.addAll(Arrays.asList(0, 1, 2, 3));
           List<Integer>women = new ArrayList<Integer>();
           women.addAll(Arrays.asList(4, 5, 6, 7));
           
           Map<Integer, ArrayList<Integer>>menPref = new HashMap<Integer, ArrayList<Integer>>();
           menPref.put(0, new ArrayList<Integer>(){{ addAll(Arrays.asList(7, 5, 6, 4));}});
           menPref.put(1, new ArrayList<Integer>(){{ addAll(Arrays.asList(5, 4, 6, 7));}});
           menPref.put(2, new ArrayList<Integer>(){{ addAll(Arrays.asList(4, 5, 6, 7));}});
           menPref.put(3, new ArrayList<Integer>(){{ addAll(Arrays.asList(4, 5, 6, 7));}});
           //System.out.println(menPref);
           Map<Integer, ArrayList<Integer>>womenPref = new HashMap<Integer, ArrayList<Integer>>();
           womenPref.put(4 , new ArrayList<Integer>(){{ addAll(Arrays.asList(0, 1, 2, 3));}});
           womenPref.put(5 , new ArrayList<Integer>(){{ addAll(Arrays.asList(0, 1, 2, 3));}});
           womenPref.put(6 , new ArrayList<Integer>(){{ addAll(Arrays.asList(0, 1, 2, 3));}});
           womenPref.put(7 , new ArrayList<Integer>(){{ addAll(Arrays.asList(0, 1, 2, 3));}});
           //System.out.println(womenPref);
             
           Map<Integer, Integer>matcher = new HashMap<>();
           for(Integer m :men){
        	   List<Integer> preflist = menPref.get(m);
        	   for(Integer w:preflist){
        		   if(matcher.containsKey(w)){
        			  if( dump(w, matcher ,m,womenPref)){
        				  matcher.put(w, m);
        				//  System.out.println("if w "+w+" m "+m);
        				  break;
        			  }
        		   }
        		   else{
        			   matcher.put(w, m);
        			   //System.out.println("else w "+w+" m "+m);
        			   break;
        		   }
        	   }
           }
           System.out.println(matcher);
           
	}

	private static boolean dump(Integer w, Map<Integer, Integer> matcher, Integer m, Map<Integer, ArrayList<Integer>> womenPref) {
		boolean dump = false;
		List<Integer>menpr = womenPref.get(w);
		Integer mprev = matcher.get(w);
		if(menpr.indexOf(m)<menpr.indexOf(mprev))
		dump =true;
		
		return dump;
	}

}
