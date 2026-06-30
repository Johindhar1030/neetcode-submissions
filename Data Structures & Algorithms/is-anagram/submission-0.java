class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
        Map<Character,Integer> store=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            store.put(a,store.getOrDefault(a,0)+1);
            store.put(b,store.getOrDefault(b,0)-1);
        }
        for(int val: store.values()){
            if(val!=0)
            return false;
        }
        return true;
    }
}
