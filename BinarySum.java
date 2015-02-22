public class BinarySum {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        
        int i,j, sum=0, carry=0;
        
        String result = "";
        
        for(i=len1-1, j=len2-1; (i>=0) && (j>=0) ;i--,j--) {
             int aBit = a.charAt(i) - '0'; 
             int bBit = b.charAt(j) - '0';
             
             sum = (aBit+bBit+carry)%2;
             carry = (aBit+bBit+carry)/2;
             
             result = sum + result;
        }
        if(i>=0){
            for(;i>=0;i--){
                int aBit = a.charAt(i) - '0'; 
             
                sum = (aBit+carry)%2;
                carry = (aBit+carry)/2;
             
                result = sum + result;
            }
        }   
        if(j>=0){
            for(;j>=0;j--){
                int bBit = b.charAt(j) - '0'; 
             
                sum = (bBit+carry)%2;
                carry = (bBit+carry)/2;
             
                result = sum + result;
            }
        }
        if(carry!=0){
            result = carry + result;
        }
        return result;
    }
}