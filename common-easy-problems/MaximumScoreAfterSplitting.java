//leetcose 1422
class MaximumScoreAfterSplitting {
    public int maxScore(String s) {
        int sum = 0;
        int maxSum = 0;
    
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '1')
                sum += 1;
        }
        int zeros = 0;
        for(int i = 0 ; i < s.length()-1; i++){
            if(s.charAt(i) == '0')
               zeros++;
            else
                sum--;
            
            maxSum = Math.max(maxSum, sum + zeros);
               
        }
        return maxSum;
    }
}
