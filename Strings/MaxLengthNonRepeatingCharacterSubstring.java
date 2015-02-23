package Strings;
import java.util.*; 

public class MaxLengthNonRepeatingCharacterSubstring {
    //The key idea is that the longest subtring must be limited by either the end of the string or must be
    //between 2 duplicates
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastIndices = new HashMap<Character, Integer>();

        
        int maxLen = 0;
        int curLen = 0;
        

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            //If either the last indices key does not contain this character c or lastIndices contains the character
            //but it is not part of the current longest non repeating string bing scanned.
            if(!lastIndices.containsKey(c) || (lastIndices.get(c) < (i-curLen))){
                //The character at index i also will update the current length of the string
                curLen++;
                if(curLen>maxLen){
                    maxLen = curLen;
                }
            } else {
                //The current longest String is therefore sandwiched between the indices (lastIndices.get(c)+1) and i
                //The length of this must therefore be i-(lastIndices.get(c)+1)+1 = i - lastIndices.get(c) -1 +1 =
                //i - lastIndices.get(c)
                curLen = i - lastIndices.get(c);
                lastIndices.put(c, i);
            }
            //Add or update the lastIndices entry
            lastIndices.put(c, i);
        }
        return maxLen;
    }
}