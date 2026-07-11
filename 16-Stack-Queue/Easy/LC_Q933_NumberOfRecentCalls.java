class RecentCounter {

    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);

        while(!q.isEmpty() && q.peek() < t - 3000) {
            q.remove();
        }

        return q.size();
    }
}

// t se t - 3000 ke ander jo nhi h usko eleminate kr do 
// example - jb 3002 aaya to range 2 se 3002 ho gya aur 1 lie nhi kr rha h to usko remove kr do 
