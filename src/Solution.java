class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        boolean destroyed = false;
        int count = 0;
        if(dist.length == 0) return 0;

        while(!destroyed && count<dist.length){
            float minRat = Float.MAX_VALUE;
            int minIndex = 0;
            for(int i = 0; i<dist.length;i++){
                if(dist[i] <= 0) continue;
                float ratio = (float)dist[i]/ (float)speed[i];
                if(ratio < minRat) {
                    minRat = ratio;
                    minIndex = i;
                }
            }
            count++;
            dist[minIndex] = -1;
            for(int i = 0;i<dist.length; i++){
                if(dist[i]>0){
                    dist[i] -= speed[i];
                    if(dist[i] <= 0){
                        destroyed = true;
                        return count;
                    }
                }
            }
        }
        return count;
    }
}