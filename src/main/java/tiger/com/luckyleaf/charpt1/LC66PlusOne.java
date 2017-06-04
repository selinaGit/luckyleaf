package tiger.com.luckyleaf.charpt1;

import java.util.Arrays;

/**
 *
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class LC66PlusOne {

    /**
     *
     * throw new IllegalArgumentException();  for invalid input!!!
     * 这道题的要考虑是1. 不是可以更改input, 2. digits[0] 会不会有进位。
     * 3. 如何处理有进位和没进位。Arrays.copyOfRange(result, start, len + 1);
     * 4. 注意 start的值。
     *
     */
    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            //throw exception or Log error
            throw new IllegalArgumentException();
        }
        int len = digits.length;
        int[] result = new int[len + 1];
        int carry = 1;

        for (int i = len - 1; i >=0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            result[i + 1] = sum % 10;
        }
        result[0] = carry;

        int startIndex = (carry == 1) ? 0 : 1;

        // Arrays !!!
        return Arrays.copyOfRange(result, startIndex, len + 1);
    }
}
