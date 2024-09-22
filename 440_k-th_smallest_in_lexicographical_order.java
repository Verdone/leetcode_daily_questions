// 440. K-th Smallest in Lexicographical Order
// Difficulty: Hard
// Topics: Trie

class Solution {
    private int getrNum(long a, long b, long n) {
        int g = 0;
        while (a <= n) {
            g += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return g;
    }

    public int findKthNumber(int n, int k) {
        long num = 1;
        for (int i = 1; i < k;) {
            int r = getrNum(num, num + 1, n);
            if (i + r <= k) {
                i += r;
                num++;
            } else {
                i++;
                num *= 10;
            }
        }
        return (int) num;
    }
}
