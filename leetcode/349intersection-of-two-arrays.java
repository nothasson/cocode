class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        //把nums1中的元素全部加入到集合set1中
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            //查看nums2中的元素是否存在集合set1中，如果存在，
            //就加入到集合list中，然后再把这个元素从set1中移除
            if (set1.contains(nums2[i])) {
                list.add(nums2[i]);
                set1.remove(nums2[i]);
            }
        }

        //下面一大坨是把集合list转换为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}