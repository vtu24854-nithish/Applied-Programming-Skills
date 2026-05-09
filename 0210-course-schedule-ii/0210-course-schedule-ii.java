class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites) {

            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {

            if(indegree[i] == 0)
                q.offer(i);
        }

        int[] result = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()) {

            int node = q.poll();
            result[index++] = node;

            for(int nei : graph.get(node)) {

                indegree[nei]--;

                if(indegree[nei] == 0)
                    q.offer(nei);
            }
        }

        if(index == numCourses)
            return result;

        return new int[0];
    }
}