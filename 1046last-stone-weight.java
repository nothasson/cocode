class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            q.add(stone);
        }
        int num1;
        int num2;
        while (q.size() > 1) {
            num1 = q.poll();
            num2 = q.poll();
            q.add(num1 - num2);
        }
        return q.isEmpty() ? 0 : q.peek();
    }
}