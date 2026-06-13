class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = num.length - 1;
        while(n >= 0 || k > 0) {
            if (n >= 0) {
                k += num[n];
                n--;
            }

            ans.add(0,k % 10);
            k /= 10;
        }
        return ans;
    }
}
