// 432. All O`one Data Structure
// Difficulty: Hard
// Topics: HashMap, Design 

class AllOne {

    private HashMap<String, Integer> d;
    private int op;
    private String res;

    public AllOne() {
        d = new HashMap<>();
        op = 0;
        res = "";
    }

    public void inc(String key) {
        op = 0;
        d.put(key, d.getOrDefault(key, 0) + 1);
    }

    public void dec(String key) {
        op = 0;
        if (d.containsKey(key)) {
            if (d.get(key) > 1) {
                d.put(key, d.get(key) - 1);
            } else {
                d.remove(key);
            }
        }
    }

    public String getMaxKey() {
        if (op == 1) {
            return res;
        }
        op = 1;
        if (!d.isEmpty()) {
            int a = (int) d.values().toArray()[0];
            String b = (String) d.keySet().toArray()[0];
            for (String key : d.keySet()) {
                if (d.get(key) > a) {
                    a = d.get(key);
                    b = key;
                }
            }
            res = b;
            return b;
        }
        res = "";
        return "";
    }

    public String getMinKey() {
        if (op == 2) {
            return res;
        }
        op = 2;
        if (!d.isEmpty()) {
            int a = (int) d.values().toArray()[0];
            String b = (String) d.keySet().toArray()[0];
            for (String key : d.keySet()) {
                if (d.get(key) < a) {
                    a = d.get(key);
                    b = key;
                }
            }
            res = b;
            return b;
        }
        res = "";
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */