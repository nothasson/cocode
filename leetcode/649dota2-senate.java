//一个循环队列
class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll(), dIndex = dire.poll();
            if (rIndex < dIndex) radiant.offer(rIndex + n);
            else dire.offer(dIndex + n);
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}