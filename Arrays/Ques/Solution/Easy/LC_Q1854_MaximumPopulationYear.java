class Solution {
    public int maximumPopulation(int[][] logs) {

        int[] year = new int[101];

        for (int i = 0 ; i < logs.length ; i++) {
            int[] log = logs[i];
            year[log[0] - 1950]++;
            year[log[1] - 1950]--;
        }

        int maxPop = 0;
        int curr = 0;
        int ans = 1950;

        for (int i = 0; i < 101; i++) {
            curr += year[i];

            if (curr > maxPop) {
                maxPop = curr;
                ans = i + 1950;
            }
        }

        return ans;
    }
}
