package tiger.com.luckyleaf.charpt1;

/**
 *
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

 * ==============================================
 * Your runtime beats 35.99 % of java submissions.
 */
public class LC80RemoveDuplicatesFromSortedArrayII {

    /* http://bangbingsyb.blogspot.com/2014/11/leetcode-remove-duplicates-from-sorted.html
 和I一样的思路，区别仅仅在于当A［second-1] = A[second] = A[first]时，A[i]为重复元素需跳过。
 而实际只需要比较A[second-1]和A[first]，因为当A[second-1] = A[first]时，根据sorted arry特性必然也有A[second]=A[seond-1]。

 还要再看，理解

         if (nums[first] == nums[second] && nums[first] != nums[second - 1]) {
             nums[++second] = nums[first];
         }
         else if (nums[first] != nums[second]) {
             nums[++second] = nums[first];
         }

         =>

         if (nums[first] != nums[second - 1]) {
             nums[++second] = nums[first];
         }
         we do not care about the nums[second] if it is same as nums[first] or not. we both can  nums[++second] = nums[first]

         1, 2, .... 2 => 1, 2, 2 ....
         1, 1, .....2 => 1, 1, 2.....
 */
    public int removeDuplicatesBase(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 2) {
            return 2;
        }
        int second = 1;
        for (int first = 2; first < nums.length; first++) {
            // 1 1 1 1 3 3  => 1 1 3(second) 1 3(first)
            // 1 3(second) 3(first)
            if (nums[first] == nums[second] && nums[first] != nums[second - 1]) {
                nums[++second] = nums[first];
            }
            else if (nums[first] != nums[second]) {
                nums[++second] = nums[first];
            }
        }
        // second is last index of the new result, need to return len
        return second + 1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 2) {
            return 2;
        }
        int second = 1;
        for (int first = 2; first < nums.length; first++) {
            if (nums[first] != nums[second - 1]) {
                nums[++second] = nums[first];
            }
        }
        // second is last index of the new result, need to return len
        return second + 1;
    }
}
