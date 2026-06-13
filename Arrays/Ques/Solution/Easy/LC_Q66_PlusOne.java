class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
    
        digits[n] += 1;
        int carry = 0;
        while(n >= 0){
            digits[n] += carry;
            if(digits[n] >= 10){
                carry = digits[n] / 10;
                digits[n] %= 10;
            }else{
                carry = 0;
                break;
            }
            n--;
        }


        if (carry > 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = carry;
            return ans;
        }

        return digits;
    }
}
