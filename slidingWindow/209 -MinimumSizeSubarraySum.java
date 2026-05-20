package slidingWindow;

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minSub = Integer.MAX_VALUE;
        int start=0;
        int sum=0;
        for (int end=0;end < nums.length;end++){
            sum+=nums[end];
            while (sum>=target){
                minSub = Math.min(minSub, end-start+1);
                sum-=nums[start];
                start++;
            }
            
        }
        return minSub == Integer.MAX_VALUE ? 0 : minSub;
    }
    
}
