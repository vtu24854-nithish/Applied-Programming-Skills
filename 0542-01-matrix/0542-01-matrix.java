class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()) {

            int[] cur = q.poll();

            for(int[] d : dir) {

                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if(nr >= 0 && nc >= 0 && nr < rows &&
                   nc < cols && mat[nr][nc] == -1) {

                    mat[nr][nc] = mat[cur[0]][cur[1]] + 1;

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }
}