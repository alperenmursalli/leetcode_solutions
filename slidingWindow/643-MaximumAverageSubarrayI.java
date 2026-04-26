package slidingWindow;


class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int curSum=0;
        int end=0;

        for (int i=0;i<k;i++){
            curSum += nums[i];
        }

        int maxSum = curSum;

        for (end=k;end<nums.length;end++){
            curSum += nums[end];
            curSum -= nums[end-k];
            maxSum = Math.max(maxSum, curSum);
        }
        return (double) maxSum/k;
        
    }

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        MaximumAverageSubarrayI sol = new MaximumAverageSubarrayI();
        double result = sol.findMaxAverage(nums, k);

        System.out.println("Max average: " + result);
    }
}
