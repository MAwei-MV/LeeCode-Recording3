package Main;

public class Pro88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int flag = n;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[i + flag] = nums1[i];
                i--;
            } else {
                nums1[i + flag] = nums2[j];
                j--;
                flag--;
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
        }
    }
}
