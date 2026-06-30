class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> dabba=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp=target-nums[i];
            if(dabba.containsKey(comp))
            return new int[]{dabba.get(comp),i};
            dabba.put(nums[i],i);
        }    
        return new int[]{};
    }
}
