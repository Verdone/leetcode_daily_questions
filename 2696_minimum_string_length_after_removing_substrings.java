// 2696. Minimum String Length After Removing Substrings
// Difficulty: Easy
// Topics: Stack

class Solution {
    public int minLength(String s) {
        char[] st = new char[s.length()+1];
        int t=0;
        for(char ch:s.toCharArray()){
            if(t==0){
                st[t++]=ch;
                continue;
            }
            if((ch=='B' && st[t-1]=='A')|| ch=='D' && st[t-1]=='C'){
                t--;
            }
            else{
                st[t++]=ch;
            }
        }
        return t;
    }
} {
    
}
