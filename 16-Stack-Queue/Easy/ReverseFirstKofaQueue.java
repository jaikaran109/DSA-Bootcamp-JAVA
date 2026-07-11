// GFG

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if(q == null || k <= 0 || k > q.size()) return q;

        Stack<Integer> dummy = new Stack<>();

        int n = q.size();
        int originalK = k;

        while(k-- > 0) {
            dummy.push(q.remove());
        }

        while(!dummy.isEmpty()) {
            q.add(dummy.pop());
        }

        for(int i = 0 ; i < n - originalK ; i++) {
            q.add(q.remove());
        }

        return q;
    }
}
