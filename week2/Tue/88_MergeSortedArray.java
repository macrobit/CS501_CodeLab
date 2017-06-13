/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
sorted array.

Note: You may assume that nums1 has enough space (size that is greater or
equal to m + n) to hold additional elements from nums2. The number of elements
initialized in nums1 and nums2 are m and n respectively.
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Corner Case
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return ;
        }
        

        
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while(i >= 0 && j >= 0) {
            // The bigger one is moved to the end, and index--
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        // if nums1 finish comparing first, copy left nums2 to the front of nums1 
        if(i < 0) {
            while(k >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
        // If nums2 finish comparing first, no need to change nums1.
        return;
    }
}
