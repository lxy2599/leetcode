/*
 * @lc app=leetcode id=2368 lang=java
 *
 * [2368] Reachable Nodes With Restrictions
 */

// @lc code=start
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // 广度优先遍历用到的队列
        Queue<Integer> q = new LinkedList<Integer>();

        // 限制节点的集合
        Set<Integer> set = new HashSet<Integer>();
        for(int i : restricted){
            set.add(i);
        }

        // 已经遍历过的集合
        Set<Integer> traversed = new HashSet<Integer>();

        int res = 0;
        q.add(0);
        res++;

        // 开始遍历
        while(!q.isEmpty()){
            int node = q.poll();
            traversed.add(node);
            // 遍历edges数组
            for(int i = 0; i < n - 1; i++){
                // 判断是否是已经遍历过的或者受限节点
                if(edges[i][0] == node && !set.contains(edges[i][1]) && !traversed.contains(edges[i][1])){
                    q.add(edges[i][1]);
                    res++;
                }else if(edges[i][1] == node && !set.contains(edges[i][0]) && !traversed.contains(edges[i][0])){
                    q.add(edges[i][0]);
                    res++;
                }
            }
        }

        return res;
    }
}
// @lc code=end

