package tiger.com.luckyleaf.charpt1;

/**
 *
 * http://www.lintcode.com/en/problem/partition-array/
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 */
public class TC31PartitionArray {

    /**
     *
     * @param nums: The integer array you should partition
     * @param k: As description
     * return: The index after partition
     *
     * 考虑 一个极端的例子：
     * case 1: nums{5}, k = 9
     * case 2: nums{5}, k = 2
     * case 3: 1, 6, can understand why left <= right not left < right
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length, left = 0, right = len - 1;
        // need to understand the reason left <= right, check case1, case2
        while (left <= right) {
            while (left < len && nums[left] < k) {
                left++;
            }
            while(right >= 0 && nums[right] >= k) {
                right--;
            }
            //very important!!! otherwise IndexOutOfBoundsException
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return left;
    }
}
