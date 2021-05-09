package array.math;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/820/
public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		 if (1<<31 == dividend && divisor == -1) return Integer.MAX_VALUE;
         // edge case when dividend is most negative value , Integer.MIN_Value (1 << 31)

         boolean sameSign = (dividend<0) == (divisor<0);
         if (divisor > 0) divisor = -divisor;
         if (dividend > 0) dividend = -dividend;
         // change both to negative, negative values has bigger magnitude
         int temp = helper(dividend, divisor); 
         return sameSign? temp: -temp;
     } 
 
     int helper(int dividend, int divisor) {
        if (dividend > divisor) return 0; // negative values so the logic is reverse
        
        int sum = divisor;
        int valueOfBit = 1;
        
        while( sum > Integer.MIN_VALUE - sum &&  sum + sum > dividend) {
            // original logic is sum + sum > Integer.MIN_VALUE but rearrange to avoid overflow
            // notice how sum + sum actually means double of sum which is equivalent to shifting sum to the left by 1
             sum += sum;     
             valueOfBit += valueOfBit; 
        } // the terminating condition is when valueOfBit is equivalent to the left most 1 bit
         // the sum is used below to help us remove the left most 1 bit from dividend
         return valueOfBit + helper(dividend - sum, divisor);
		
//		if (divisor == 1)
//			return dividend;
//		if (divisor == -1) {
//			if (dividend == Integer.MIN_VALUE)
//				return Integer.MAX_VALUE;
//			return dividend * -1;
//		}
//		if (dividend == Integer.MIN_VALUE) {
//			int result = divide((int) Math.pow(2, 15), divisor);
//			return -1 * divide(2, divisor) * result * result;
//		}
//		int dividendAbs = Math.abs(dividend);
//		int divisorAbs = Math.abs(divisor);
//		int sign = ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) ? 1 : -1;
//		int quotient = 0;
//		if (dividendAbs < divisorAbs)
//			return 0;
//		while (dividendAbs >= divisorAbs) {
//			dividendAbs -= divisorAbs;
//			quotient++;
//		}
//		return quotient * sign;
	}
}
