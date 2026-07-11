// GFG

class Solution {
    public void deleteMid(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();

        int mid = s.size() / 2;

        for(int i = 0 ; i < mid ; i++) {
            temp.push(s.pop());
        }

        s.pop();

        while(!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }
}
