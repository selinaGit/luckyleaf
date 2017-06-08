package tiger.com.luckyleaf.charpt1;

import java.util.Arrays;

/**
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

=======================================
 Your runtime beats 5.68 % of java submissions.
 */
public class LC75SortColors {


    /**
     * [0, left), i ...(right, 2]
     * 1. left = index of 0 -- lasted processed  + 1
     * 2. right = index of 2 -- lasted processed - 1
     * 3. i  is the scanner
     * 4. if scanner find 0 swap with left side and then i++, left++
     * 5. if scanner find 2, swap with right side and then i, right-- //the reason i doesn't move, because it could be 0 or 1
     * 6. if scanner is 1, i++
     */
    public void sortColorsEasyUnderstand(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int left = 0, right = nums.length - 1, i = 0; i <= right;) {
            if (nums[i] == 0) {
                swap(nums, i++, left++);
            } else if (nums[i] == 2) {
                swap(nums, i, right--);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     *
     * 乐神的code, 非常简洁的code, 三个指针都是从左边开始的
     * k 从 0 到 len - 1, if nums[k] == 2, do nothing, otherwise, nums[k] = 2
     * if val < 2,  j 右移一格， num[j++] = 1
     * if val == 0, i 右移一格， num[i++] = 0;
     *
     * 就是说， val == 0 的时候， 1 和 0 各向右边挪动一格
     * val == 1 的时候， 1 向右边挪动一格
     */
    public static void sortColors(int[] nums) {
        //[0, i), [i, j), [j, k) are 0s, 1s, and 2s
        for (int i = 0, j = 0, k = 0; k < nums.length; ++k) {
            int val = nums[k];
            nums[k] = 2;  //这是个移动2的过程。
            if (val < 2) {
                nums[j++] = 1;
            }
            if (val == 0) {
                nums[i++] = 0;
            }
        }
    }

}
