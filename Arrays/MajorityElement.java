package Arrays;
public class MajorityElement {
    public int majorityElement(int[] num) {
        return findCand(num);
    }
    
    
    //How to implement a logger
    //Return the the majority element
    public int findCand(int[] num){
        int majorityIndex = 0, count = 1;
        
        for(int i=1;i<num.length;i++){
            if(num[i] == num[majorityIndex]){
                count++;
            } else {
                count--;
            }
            
            if(count==0){
                majorityIndex = i;
                count = 1;
            }
        }
        
        return num[majorityIndex];
    }
    
    public boolean isMajority(int[] num, int cand){
        int count = 0 ;
        
        for(int i:num){
            if(i==cand){
                count++;
            }
        }
        
        if(count>num.length/2){
            return true;
        } 
        return false;
    }
}
