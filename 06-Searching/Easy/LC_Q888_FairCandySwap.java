class Solution {
    public int[] fairCandySwap(int[] a, int[] b) {
        int alice = 0;
        int bob = 0;
        for(int i = 0 ; i < a.length ; i++){
            alice += a[i];
        }

        for(int i = 0 ; i < b.length ; i++){
            bob += b[i];
        }

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b.length; j++){
                if ((alice - a[i] + b[j]) == (bob - b[j] + a[i]))
                    return new int[] { a[i], b[j] };
            }
        }
        return new int[]{0};
    }
}
