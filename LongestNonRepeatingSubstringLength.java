import java.util.*; 

public class LongestNonRepeatingSubstringLength {
	public static void main(String[] args){
		LongestNonRepeatingSubstringLength s = new LongestNonRepeatingSubstringLength();
		System.out.println("Result is:"+s.lengthOfLongestSubstring("bbbb"));
	}
	
	public int[] lengths = null;
	boolean processed = false;
	
	public void preprocess(String s, int[] lengths){
		HashSet<Character> hsi = new HashSet<Character>();
		int cur = 0;
		for(int i = 0;i<s.length();i++){
			if(hsi.contains(s.charAt(i))){
				cur = 0;
				hsi.clear();
				hsi.add(s.charAt(i));
			} else {
				hsi.add(s.charAt(i));
			}
			lengths[i] = ++cur;
		}
	}
	
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        if(!processed){
        	lengths = new int[s.length()];
        	preprocess(s,lengths);
        	processed = true;
        }
        //BASE CASE: If the length of the string s is 1, then the length of the longest substring is 1
        if(s.length() == 1){
            lengths[lengths.length - 1] = 1;
            if(s.length() == lengths.length){
            	processed = false;
            	lengths = null;
            }
            return 1;
        }
        
        
        
        //Else, can we find the length of the string s[1..]
        int subLength = lengthOfLongestSubstring(s.substring(1));
        //Calculate the length of longsest string without duplicates INCLUDING the first character
        int firstCharSubstringMaxLength = lengths[lengths.length - s.length()];
        
        int ret = firstCharSubstringMaxLength > subLength ? firstCharSubstringMaxLength : subLength;
        
        
        if(s.length() == lengths.length){
        	processed = false;
        	lengths = null;
        }
        
        return ret;
    }
    
//    public int lengthOfLongestSubstring(String s) {
//        if(s.length() == 0) {
//            return 0;
//        }
//        //BASE CASE: If the length of the string s is 1, then the length of the longest substring is 1
//        if(s.length() == 1){
//            return 1;
//        }
//        
//        //Else, can we find the length of the string s[1..]
//        int subLength = lengthOfLongestSubstring(s.substring(1));
//        //Calculate the length of longsest string without duplicates INCLUDING the first character
//        int firstCharSubstringMaxLength = 0;
//        
//        //Some code to calculate firstCharSubstringMaxLength
//        HashSet<Character> letters = new HashSet<Character>();
//        
//        letters.add(s.charAt(0));
//        
//        for(int i=1;i<s.length();i++){
//            char cur = s.charAt(i);
//            if(letters.contains(cur)){
//                break;
//            } else {
//                letters.add(cur);
//            }
//        }
//        
//        firstCharSubstringMaxLength = letters.size();
//        
//        return firstCharSubstringMaxLength > subLength ? firstCharSubstringMaxLength : subLength;
//    }
}