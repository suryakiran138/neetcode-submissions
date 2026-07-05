class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        boolean isOdd = total%2==1;
        int p1=0,p2=0,counter=0;
        int target1 = (total/2)-1;
        int target2 = target1+1;
        int val1=0,val2=0;
        while(p1<nums1.length && p2<nums2.length){
            System.out.println("1 p1"+p1+" p2"+p2);
            if(nums1[p1]<=nums2[p2]){
                if(target1==counter) val1 = nums1[p1];
                if(target2==counter) {
                    val2 = nums1[p1];
                    return isOdd ? (double)val2 : (double)(val1+val2)/2;
                }
                p1++;
            } else {
                if(target1==counter) val1 = nums2[p2];
                if(target2==counter) {
                    val2 = nums2[p2];
                    return isOdd ? (double)val2 : (double)(val1+val2)/2;
                }
                p2++;
            }
            counter++;
        }

        while(p1<nums1.length){
            System.out.println("2 p1"+p1+" p2"+p2);
            if(target1==counter) val1 = nums1[p1];
            if(target2==counter) {
                val2 = nums1[p1];
                return isOdd ? (double)val2 : (double)(val1+val2)/2;
            }
            p1++;
            counter++;
        }
        while(p2<nums2.length){
            System.out.println("3 p1"+p1+" p2"+p2);
            if(target1==counter) val1 = nums2[p2];
            if(target2==counter) {
                val2 = nums2[p2];
                return isOdd ? (double)val2 : (double)(val1+val2)/2;
            }
            p2++;
            counter++;
        }

        return -1;

    }
}
