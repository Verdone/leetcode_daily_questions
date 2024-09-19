// 241. Different Ways to Add Parentheses
// Difficulty: Medium
// Topics: Math, String, DP, Recursion, Memoization 

class Solution {
   
    public List<Integer> diffWaysToCompute(String exp) {
        if(exp.length() <= 2) {
            return Arrays.asList(Integer.parseInt(exp));
        }

        List<Integer> res = new ArrayList();

        for(int i = 0; i < exp.length(); i++){
            if(!Character.isDigit(exp.charAt(i))){
                List<Integer> l = diffWaysToCompute(exp.substring(0, i));
                List<Integer> r = diffWaysToCompute(exp.substring(i+1));

                for(int v1 : l){
                    for(int v2 : r){
                        res.add(cal(v1, v2, exp.charAt(i)));
                    }
                }
            }
        }

        return res;
    }

    int cal(int n1, int n2, char sign){
        if(sign=='+') {
            return n1 + n2;
        } else if (sign=='-'){
            return n1 - n2;
        } else {
            return n1 * n2;
        }
    }
}