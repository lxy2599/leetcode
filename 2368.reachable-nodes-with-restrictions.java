/*
 * @lc app=leetcode id=2368 lang=java
 *
 * [2368] Reachable Nodes With Restrictions
 */

// @lc code=start
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; ++i){
            adj[i] = new ArrayList<>();
        }
        // 邻接表建图
        for (int i = 0; i < n - 1; ++i){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        // 广度优先遍历用到的队列
        Queue<Integer> q = new LinkedList<Integer>();

        // 限制节点的集合
        Set<Integer> traversed = new HashSet<Integer>();
        for(int i : restricted){
            traversed.add(i);
        }

        int res = 0;
        q.add(0);
        res++;

        // 开始遍历
        while(!q.isEmpty()){
            int node = q.poll();
            traversed.add(node);
            // 遍历edges数组
            for(int i : adj[node]){
                // 判断是否是已经遍历过的或者受限节点
                if(!traversed.contains(i)){
                    q.add(i);
                    res++;
                }
            }
        }

        return res;
    }
}
// @lc code=end

