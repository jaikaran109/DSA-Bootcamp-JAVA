class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;

        for (int num = 1; ; num++) {
            boolean found = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                count++;

                if (count == k) {
                    return num;
                }
            }
        }
    }
}



// Not Optimal Use Binary Search for optimal code