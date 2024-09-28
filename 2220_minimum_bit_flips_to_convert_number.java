// 2220. Minimum Bit Flips to Convert Number
// Difficulty: Easy
// Category: Bit Manipulation

class Solution {
    public int minBitFlips(int start, int goal) {
        int r = 0;
        int xor = start ^ goal;
        while(xor!=0){
            r += xor & 1;
            xor >>=1;
        }
        return r;
    }
}