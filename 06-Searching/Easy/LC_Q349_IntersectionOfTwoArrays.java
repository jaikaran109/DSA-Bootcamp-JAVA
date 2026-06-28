class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            if (set1.contains(n)) {
                resultSet.add(n);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int n : resultSet) {
            result[i++] = n;
        }
        return result;
    }
}






// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         ArrayList<Integer> list = new ArrayList<>();
//         for(int i = 0 ; i < nums1.length ; i++){
//             for(int j = 0 ; j < nums2.length ; j++){
//                 if(nums1[i] == nums2[j] && !(list.contains(nums1[i]))) list.add(nums1[i]);
//             }
//         }
//         int[] arr = new int[list.size()];
//         for(int i = 0 ; i < list.size() ; i++){
//             arr[i] = list.get(i);
//         }
//         return arr;
//     }
// }