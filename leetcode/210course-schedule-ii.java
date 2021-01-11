//在207的基础上稍微改一下就好了。
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int length = numCourses;
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        int[] result = new int[length];
        Arrays.fill(result, -1);
        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            result[length - numCourses] = pre;
            numCourses--;
            for (int cur : adjacency.get(pre))
                if (--indegrees[cur] == 0) queue.add(cur);
        }
        for (int i = 0; i < length; i++) {
            if (result[i] == -1) return new int[0];
        }
        return result;
    }
}