import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem1 {
	public static List<Integer> substringUsingConcatenationOfAllGivenWords(String str, String[] words) {
	    if(str == null || str.length() == 0 || words == null || words.length == 0) {
	      return new ArrayList<>();
	    }
	    
	    Map<String, Integer> frequencyMap = new HashMap<>();
	    
	    for(String word: words) {
	      frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
	    }
	    
	    int eachWordLength = words[0].length();
	    int totalWords = words.length;
	    List<Integer> result = new ArrayList<>();
	    
	    for (int i = 0; i <= str.length() - totalWords * eachWordLength; i++) {
	      
	      Map<String, Integer> seenWords = new HashMap<>();
	      
	      for (int j = 0; j < totalWords; j++) {
	        int wordIndex = i + j * eachWordLength;
	        
	        String word = str.substring(wordIndex, wordIndex + eachWordLength);
	        
	        if(!frequencyMap.containsKey(word)) {
	          break;
	        }
	        
	        seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
	        
	        if(seenWords.get(word) > frequencyMap.getOrDefault(word, 0)) {
	          break;
	        }
	        
	        if(j + 1 == totalWords)   {
	          result.add(i);
	        }
	      }
	    }
	    
	    return result;
	  }
	  
	  public static void main(String[] args) {
		 		  
	    String str = "barfoothefoobarman";	    
	    String[] words = {"foo", "bar"};
	    
	    String str1 = "barfoofoobarthefoobarman";
	    String[] words1 = {"bar","foo","the"};
	    
	    System.out.println(substringUsingConcatenationOfAllGivenWords(str, words));
	    System.out.println(substringUsingConcatenationOfAllGivenWords(str1, words1));
	  }

	

}
