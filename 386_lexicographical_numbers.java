// 386. Lexicographical Numbers
// Difficulty: Medium
// Topics: Recursion

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        addToNineMax(res, 1, n);
        return res;
    }

    void addToNineMax(List<Integer> res, int ln, int n) {
        if (ln <= n) { 
            res.add(ln);
            addToNineMax(res, ln * 10, n);

            for(int i = 1; i < (ln < 10 ? 9 : 10) && (ln+i<=n); i++) {
                res.add(ln + i);
                if ((ln + i) * 10 <= n) {
                    addToNineMax(res, (ln+i) * 10, n);
                } 
            }
        }
    }
}