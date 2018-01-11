import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;

public class MP1 {
    Random generator;
    String userName;
    String inputFileName;
    SortedMap<String, Integer> hm;
    Map<String, Integer> sortedMap;
    SortedSet<Map.Entry<String, Integer>> sortedSet;
    String delimiters = " \t,;.?!-:@[](){}_*/";
    String[] stopWordsArray = {"i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours",
            "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its",
            "itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that",
            "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having",
            "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while",
            "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before",
            "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again",
            "further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each",
            "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than",
            "too", "very", "s", "t", "can", "will", "just", "don", "should", "now"};

    void initialRandomGenerator(String seed) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        messageDigest.update(seed.toLowerCase().trim().getBytes());
        byte[] seedMD5 = messageDigest.digest();

        long longSeed = 0;
        for (int i = 0; i < seedMD5.length; i++) {
            longSeed += ((long) seedMD5[i] & 0xffL) << (8 * i);
        }

        this.generator = new Random(longSeed);
    }

    Integer[] getIndexes() throws NoSuchAlgorithmException {
        Integer n = 10000;
        Integer number_of_lines = 50000;
        Integer[] ret = new Integer[n];
        this.initialRandomGenerator(this.userName);
        for (int i = 0; i < n; i++) {
            ret[i] = generator.nextInt(number_of_lines);
        }
        return ret;
    }

    public MP1(String userName, String inputFileName) {
        this.userName = userName;
        this.inputFileName = inputFileName;
        this.hm = new TreeMap<String, Integer>();
        this.sortedSet = 
        		new TreeSet<Map.Entry<String, Integer>>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1,
                            Map.Entry<String, Integer> e2) {
                        if (e1.getValue() == e2.getValue()) {
                        	return (e1.getKey().compareTo(e2.getKey()));
                        } else {
                        	if (e1.getValue() > e2.getValue()) {
                        		return 1;
                        	} else {
                        		return 0;	
                        	}
                        } 
                    }
                });

    }

    private boolean isInStopWords(String word) {
    
    	for(String str : stopWordsArray) {
    		if (word.equals(str)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private void addToHashMap(String s) {
    	if (hm.containsKey(s)) {
    		Integer i = hm.get(s);
    		int j = i.intValue();
    		j++;
    		hm.put(s, new Integer(j));
    	} else {
    		hm.put(s, new Integer(1));
    	}
    }
    
   void getStrings(String [] output, int count) {
	   
	   LinkedHashMap<String, Integer> tm = ( LinkedHashMap<String, Integer>)sortedMap;
	   int i = 0;
	   for (Map.Entry<String, Integer> entry : tm.entrySet()) {
		   if (i == count) {
			   break;
		   }
		 //  System.out.println("Word: " + entry.getKey() + " occurs " + entry.getValue() + " times.");
		   output[i] = entry.getKey();
		   i++;
	   }
   }
   
   private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap)
   {

       List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

       // Sorting the list based on values
       Collections.sort(list, new Comparator<Entry<String, Integer>>()
       {
    	   @Override
           public int compare(Map.Entry<String, Integer> e1,
                   Map.Entry<String, Integer> e2) {
               if (e1.getValue() == e2.getValue()) {
               	int n = e1.getKey().compareTo(e2.getKey());
               	if (n > 0) { return -1; } 
               	else if (n < 0) { return 1;}
               	else {return 0; }
               } else {
               	if (e1.getValue() > e2.getValue()) {
               		return -1;
               	} else if (e1.getValue() < e2.getValue()) {
               		return 1;	
               	} else {
               		return 0;
               	}
               } 
           }
       });

       // Maintaining insertion order with the help of LinkedList
       Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
       for (Entry<String, Integer> entry : list)
       {
           sortedMap.put(entry.getKey(), entry.getValue());
       }

       return sortedMap;
   }

   public static void printMap(Map<String, Integer> map)
   {
       for (Entry<String, Integer> entry : map.entrySet())
       {
           System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
       }

   }
    
    public String[] process() throws Exception {
        String[] ret = new String[20];
       
        ArrayList<String> orig = new ArrayList<String>();
        
        //TODO
        try  {
        	BufferedReader br = new BufferedReader(new FileReader("/Users/kelakshm/cera/cloud3/MP1/cloudapp-mp1/input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
            	orig.add(line);
            	/*StringTokenizer st = new StringTokenizer(line, delimiters);
            	while (st.hasMoreTokens()) {
            		String token = st.nextToken();
            		String trimtoken = token.trim().toLowerCase();
            		if (!isInStopWords(trimtoken)) {
            			addToHashMap(trimtoken);
            		}
            	} */
            }
            br.close();
        } catch(Exception e) {
        	System.out.println(e);
        }
        
        Object [] origArray = orig.toArray();
        
        Integer [] toProcess = getIndexes();
        for (Integer i : toProcess) {
        	int value = i.intValue();
        	String origString = (String) origArray[value];
        	StringTokenizer st = new StringTokenizer(origString, delimiters);
        	while (st.hasMoreTokens()) {
        		String token = st.nextToken();
        		String trimtoken = token.trim().toLowerCase();
        		if (!isInStopWords(trimtoken)) {
        			addToHashMap(trimtoken);
        		}
        	} 
        }
        
        System.out.println("Before converting to the sorted set " + hm.size());
        sortedMap = sortByComparator(hm);
        System.out.println("After converting to the sorted set " + sortedSet.size());
        getStrings(ret, 20);

        return ret;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1){
            System.out.println("MP1 <User ID>");
        }
        else {
            String userName = args[0];
            String inputFileName = "./input.txt";
            MP1 mp = new MP1(userName, inputFileName);
            String[] topItems = mp.process();
            for (String item: topItems){
                System.out.println(item);
            }
        }
    }
}
