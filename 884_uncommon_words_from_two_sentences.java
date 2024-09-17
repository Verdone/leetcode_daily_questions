// 884. Uncommon Words from Two Sentences
// Difficulty: Easy
// Topics: Hash Table, String, Counting

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> hm = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        String[] firstString = s1.split(" ");
        String[] secondString = s2.split(" ");
        mapStringCount(hm,firstString);
        mapStringCount(hm,secondString);
        for(String each: hm.keySet()){
            if(hm.get(each) == 1){
                al.add(each);
            }
        }
        String[] ans = new String[al.size()];
        for(int i=0;i<al.size();i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
    public void mapStringCount(HashMap<String,Integer> hm, String[] str){
        for(String each: str){
            if(hm.containsKey(each)){
                hm.put(each,(hm.get(each) + 1));
            }
            else{
                hm.put(each, 1);
            }
        }
    }
}