import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {
	    public static List < List < String >> groupAnagrams(String[] strs) {
	  
	        List < List < String >> result = new ArrayList < > ();	    
	        String str[] = new String[strs.length];
	        for (int i = 0; i < strs.length; i++) {
	            char c[] = strs[i].toCharArray();
	            Arrays.sort(c);
	            str[i] = String.valueOf(c);
	        }	        
	        HashMap < String, ArrayList < String >> map = new HashMap < String, ArrayList < String >> ();
	        for (int i = 0; i < strs.length; i++) {
	            if (map.containsKey(str[i])) {
	                ArrayList < String > list = map.get(str[i]);
	                list.add(strs[i]);
	                map.put(str[i], list);
	            } else {
	                ArrayList < String > list = new ArrayList < > ();
	                list.add(strs[i]);
	                map.put(str[i], list);
	                result.add(list);
	            }
	        }

	        return result;
	    }
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the no Words:- ");
	        int N = sc.nextInt();
	        System.out.println("Enter the words");
	        String strs[] = new String[N];
	        for (int i = 0; i < N; i++)
	            strs[i] = sc.next();
	        System.out.println(groupAnagrams(strs));
	    }

	}
