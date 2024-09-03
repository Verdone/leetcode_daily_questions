// 1945. Sum of Digits of String After Convert
// Difficulty: Easy

class Solution {
    public int getLucky(String s, int k) {
        
        StringBuilder number = new StringBuilder();
        for (char x : s.toCharArray()) {
            number.append(x - 'a' + 1);
        }
        
        while (k > 0) {
            int t = 0;
            for (char x : number.toString().toCharArray()) {
                t += x - '0';
            }
            number = new StringBuilder(String.valueOf(t));
            k--;
        }
        return Integer.parseInt(number.toString());
    }
}