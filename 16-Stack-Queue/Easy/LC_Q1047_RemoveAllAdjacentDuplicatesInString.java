class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && st.peek() == c){
                st.pop();
            } else {
                st.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        for(char c : st) res.append(c);

        return res.toString();
        }
}



// class Solution {
//     public String removeDuplicates(String s) {
//         Stack<Character> st = new Stack<>();

//         for(char ch : s.toCharArray()){
//             if(!st.isEmpty() && st.peek() == ch) st.pop();
//             else st.push(ch);
//         }
        
//         String ans = "";
//         for(char ch : st){
//             ans += ch;
//         }
//         return ans;
//     }
// }
