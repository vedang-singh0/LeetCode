class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int visited[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int p[] : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, adj, visited, ans)) {
                    return new int[0];
                }
            }
        }
        int res[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = ans.get(numCourses-i-1);
        }

        return res;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int visited[], ArrayList<Integer> ans) {
        if (visited[node] == 1) {
            return false;
        }
        if (visited[node] == 2) {
            return true;
        }
        visited[node] = 1;
        for (int next : adj.get(node)) {
            if (!dfs(next, adj, visited, ans)) {
                return false;
            }
        }
        visited[node] = 2;
        ans.add(node);
        return true;
    }
}