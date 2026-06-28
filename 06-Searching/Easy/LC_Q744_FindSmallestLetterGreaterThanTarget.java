class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target > letters[letters.length - 1]) return letters[0];

        int low = 0 ;
        int high = letters.length - 1;

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(letters[mid] > target){
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return letters[ans];
    }
}




// You can use linear search also but that takes O(n) time complexity