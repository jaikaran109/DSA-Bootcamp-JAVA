

// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         for(int i = 0 ; i < nums1.length ; i++){
//             ans.add(nums1[i]);
//         }

//         ArrayList<Integer> res = new ArrayList<>();
//         for(int i = 0 ; i < nums2.length ; i++){
//             if(ans.contains(nums2[i])){
//                 res.add(nums2[i]);
//                 ans.remove(Integer.valueOf(nums2[i]));
//             }
//         }

//         int[] arr = new int[res.size()];
//         for (int i = 0; i < res.size(); i++){
//             arr[i] = res.get(i);
//         }
//         return arr;
//     }
// }



// Not Optimal