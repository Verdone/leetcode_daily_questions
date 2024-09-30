// 1381. Design a Stack With Increment Operation
// Difficulty: Medium
// Category: Array, Stack

class CustomStack {
    private int n;
    private Stack<Integer> s;
    private List<Integer> inc;

    public CustomStack(int n) {
        this.n = n;
        this.s = new Stack<>();
        this.inc = new ArrayList<>();
    }

    public void push(int x) {
        if (s.size() < n) {
            s.push(x);
            inc.add(0);
        }
    }

    public int pop() {
        if (s.isEmpty()) return -1;
        if (inc.size() > 1) inc.set(inc.size() - 2, inc.get(inc.size() - 2) + inc.get(inc.size() - 1));
        return s.pop() + inc.remove(inc.size() - 1);
    }

    public void increment(int k, int val) {
        if (!s.isEmpty()) {
            int index = Math.min(k, inc.size()) - 1;
            inc.set(index, inc.get(index) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */ {
    
}
