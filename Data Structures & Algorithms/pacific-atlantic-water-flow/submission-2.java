class Solution {
    int rows,cols;
    int dirs[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        rows=heights.length;
        cols=heights[0].length;
        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            dfs(heights,i,0,pacific);
        }
        for(int j=0;j<cols;j++){
            dfs(heights,0,j,pacific);
        }
        for(int i=0;i<rows;i++){
            dfs(heights,i,cols-1,atlantic);
        }
        for(int j=0;j<cols;j++){
            dfs(heights,rows-1,j,atlantic);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j]==true&&atlantic[i][j]==true){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] heights,int r,int c,boolean[][] ocean){
        if(ocean[r][c]==true){
            return;
        }
        ocean[r][c]=true;
        for(int[] d:dirs){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr<0||nc<0||nr>=heights.length||nc>=heights[0].length)continue;
            if(heights[nr][nc]>=heights[r][c]){
                dfs(heights,nr,nc,ocean);
            }
        }
    }
}
