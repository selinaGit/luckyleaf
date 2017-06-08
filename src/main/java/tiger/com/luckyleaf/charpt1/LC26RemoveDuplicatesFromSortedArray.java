package tiger.com.luckyleaf.charpt1;

/**
 *
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class LC26RemoveDuplicatesFromSortedArray {

    /*
    http://bangbingsyb.blogspot.com/2014/11/leetcode-remove-duplicates-from-sorted.html
    双指针，first 在前，seond 在后，比较两个指针是不是相同。
    (1) A[second]==A[first]，A[first]为重复数字，first++ 继续。
    (2) A[second]!=A[first]，将A[first]放到A[++second]位置，first++ 继续;
    (3) second is index. to return length need to return second + 1
    (4)  Optimize code => from removeDuplicatesBase to removeDuplicates
    要理解（4）的抽象意义, for each loop (step), when the number pointed by first is not equal to the number pointed by second, assign the number pointed by first to next number of second point
    */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int second = 0;
        for (int first = 1; first < nums.length; first++) {
            if (nums[first] != nums[second]) {
                nums[++second] = nums[first];
            }
        }
        return second + 1;
    }

    public int removeDuplicatesBase(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int second = 0;
        for (int first = 1; first < nums.length;) {
            if (nums[first] == nums[second]) {
                first++;
            } else {
                nums[++second] = nums[first];
                first++;
            }
        }
        return second + 1;
    }
}
