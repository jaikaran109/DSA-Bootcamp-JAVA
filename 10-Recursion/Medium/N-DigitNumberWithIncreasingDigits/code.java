class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Special case: n=1 -> 0 se 9 tak saare digits valid
        if (n == 1) {
            for (int d = 0; d <= 9; d++) ans.add(d);
            return ans;
        }

        // n>=2 ke liye max 9 digits possible hain (1-9 use karke, leading zero allowed nahi)
        if (n < 1 || n > 9) return ans;

        helper(ans, 0, 1, n);
        return ans;
    }

    static void helper(ArrayList<Integer> ans, int current, int nextDigit, int n) {
        int digitsPlaced = (current == 0) ? 0 : String.valueOf(current).length();

        if (digitsPlaced == n) {
            ans.add(current);
            return;
        }

        // agla digit "nextDigit" se 9 tak try karo (strictly increasing ke liye)
        for (int d = nextDigit; d <= 9; d++) {
            helper(ans, current * 10 + d, d + 1, n);
        }
    }
}
