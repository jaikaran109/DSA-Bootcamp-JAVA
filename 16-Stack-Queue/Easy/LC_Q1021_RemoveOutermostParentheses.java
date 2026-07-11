class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                if(depth > 0) {
                    sb.append(ch);
                }
                depth++;
            } 
            else {
                depth--;
                if(depth > 0) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}


/*class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();

        int pointer = 0;

        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
                sb.append(ch);
            }
            else{
                if(st.isEmpty()) return "";

                st.pop();

                if(st.isEmpty()){
                    sb.deleteCharAt(pointer);
                    pointer = sb.length();
                }else{
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
} */
