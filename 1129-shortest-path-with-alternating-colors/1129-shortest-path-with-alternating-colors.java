class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : redEdges) {
            graph[e[0]].add(new int[]{e[1], 0});
        }

        for(int[] e : blueEdges) {
            graph[e[0]].add(new int[]{e[1], 1});
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        boolean[][] visited = new boolean[n][2];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, -1});

        int dist = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] cur = q.poll();

                int node = cur[0];
                int color = cur[1];

                if(ans[node] == -1)
                    ans[node] = dist;

                for(int[] nei : graph[node]) {

                    int next = nei[0];
                    int nextColor = nei[1];

                    if(nextColor != color && !visited[next][nextColor]) {

                        visited[next][nextColor] = true;
                        q.offer(new int[]{next, nextColor});
                    }
                }
            }

            dist++;
        }

        return ans;
    }
}