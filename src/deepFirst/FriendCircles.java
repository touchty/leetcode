package deepFirst;

public class FriendCircles {
    private void dfs(int[][] M, int i) {
        for (int j = 0; j < M.length; j++){
            if (M[i][j] == 1){
                M[i][j] = M[j][i] = 0;
                dfs(M,j);
            }
        }
    }

    public int findCircleNum(int[][] M){
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1){
                count++;
                dfs(M,i);
            }
        }
        return count;
    }

}
