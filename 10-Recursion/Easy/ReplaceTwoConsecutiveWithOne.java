// GFG




// TLE

// class Solution {

//     public String removeDuplicates(String s) {
//         if (s.length() <= 1) return s;

//         return helper(s, 1, new StringBuilder().append(s.charAt(0))).toString();
//     }

//     private StringBuilder helper(String s, int idx, StringBuilder ans) {

//         if (idx == s.length()) {
//             return ans;
//         }

//         if (ans.charAt(ans.length() - 1) != s.charAt(idx)) {
//             ans.append(s.charAt(idx));
//         }

//         return helper(s, idx + 1, ans);
//     }
// }



class Solution {
    public String removeDuplicates(String s) {
        if (s.length() <= 1) return s;

        ArrayList<Character> ans = new ArrayList<>();
        ans.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (ans.get(ans.size() - 1) == s.charAt(i)) continue;
            ans.add(s.charAt(i));
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < ans.size(); i++) {
            res.append(ans.get(i));
        }

        return res.toString();
    }
}
