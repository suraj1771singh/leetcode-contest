class Solution {
    public int captureForts(int[] forts) {
        int n= forts.length;
        int maxi=0;
        for(int i=0; i<n; i++){
            if(forts[i]==1){
              
                int cnt=0;
                for(int j=i+1; j<n; j++){
                    if(forts[j]==1) break;
                    if(forts[j]==0) cnt++;
                    if(forts[j]==-1){
                        maxi=Math.max(maxi,cnt);
                        break;
                    }
                }
                cnt=0;
                for(int j=i-1; j>=0; j--){
                    if(forts[j]==1) break;
                    if(forts[j]==0) cnt++;
                    if(forts[j]==-1){
                        maxi=Math.max(maxi, cnt);
                        break;
                    }
                }
            }
        }
        return maxi;
    }
}