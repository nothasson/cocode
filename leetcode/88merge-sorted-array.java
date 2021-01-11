//今天被安排了个人物，纯拧螺丝，看的眼睛都瞎了。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n -1;
        m--;
        n--;
        while(length>=0 && m>=0 && n>=0 ){
            if(nums1[m] > nums2[n])
                nums1[length--] = nums1[m--];
            else nums1[length--] = nums2[n--];
        }
        while(n>=0){
            nums1[length--] = nums2[n--];
        }
    }   
}