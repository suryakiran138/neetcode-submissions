class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean first=false,second=false,third=false;
        for(int[] triplet: triplets){
            if(!first) first = triplet[0]==target[0] && triplet[1]<=target[1] &&
             triplet[2]<=target[2];
            if(!second) second = triplet[0]<=target[0] && triplet[1]==target[1] &&
             triplet[2]<=target[2];
            if(!third) third = triplet[0]<=target[0] && triplet[1]<=target[1] &&
             triplet[2]==target[2];
        }
        return first && second && third;
    }
}
