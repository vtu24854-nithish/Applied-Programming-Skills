class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                if(grid[i][j] == 2)
                    q.offer(new int[]{i, j});

                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        int time = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] cur = q.poll();

                for(int[] d : dir) {

                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];

                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols
                            && grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}