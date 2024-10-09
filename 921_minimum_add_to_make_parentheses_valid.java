// 921. Minimum Add to Make Parentheses Valid
// Difficulty: Medium
// Topics: Stack, Greedy

class Solution {
    public int minAddToMakeValid(String s) {
        int o=0, m=0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') o++;
            else {
                if(o>0) o--;
                else m++;
            }
        }

        return o+m;   
    }
}