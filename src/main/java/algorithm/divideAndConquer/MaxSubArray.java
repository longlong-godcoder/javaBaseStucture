package algorithm.divideAndConquer;

/**
 * 最大连续子序列，最大切片
 */
public class MaxSubArray {

    private int sumMaxSubArray;

    public int[] getNums(){
        //该最大子序列的和是6 4 -1 2 1
        sumMaxSubArray = 6;
        return new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

    }

    /**
     * 暴力法，时间复杂度O(n^3)
     */
    public int bruteForce(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length; end++) {
                //同一个begin内，没必要end每一次都重新计算sum的值，可以累加之前的结果
                int sum  = 0;
                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     *  简单优化bruteForce, 时间复杂度O(n^2)
     */
    public int bruteForce2(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        for (int begin = 0; begin < nums.length; begin++) {
            int sum  = 0;
            for (int end = begin; end < nums.length; end++) {
                    sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * 采用分治思想
     */
    public int divideAndConquer(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        //左闭右开
        return divideAndConquer(nums, 0, nums.length);
    }

    private int divideAndConquer(int[] nums, int begin, int end){
        //只有一个元素，那么这个元素一定是begin -> end 的 最大子序列
        if (end - begin < 2) return nums[begin];
        int mid = (end + begin) >> 1;
        /*
            存在两种情况
            1.最大子序列属于左边 + 右边
            2.最大子序列属于左边或者右边
         */
        int leftMax = nums[mid - 1];
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = nums[mid];
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        int max = leftMax + rightMax;

        //比较2种情况3个max的最大值
        return Math.max(max,
                Math.max(divideAndConquer(nums, begin, mid),
                        divideAndConquer(nums, mid, end)));
    }



    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.divideAndConquer(maxSubArray.getNums());
        System.out.println(i);
    }
}
