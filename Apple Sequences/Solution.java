class Solution{
    public static int appleSequence(int n, int m, String arr){
        //code here
        int st=0;
        int end=0;
        int ans=0;
        while(end!=n){
            if(m>0){
                if(arr.charAt(end)=='O'){
                    m--;
                }
            } else {
                if(arr.charAt(end)=='O'){
                    while(arr.charAt(st)!='O'){
                        st++;
                    }
                    st++;
                }
            }
            ans=Math.max(ans,end-st+1);
            end++;
        }
        return ans;
    }
}
