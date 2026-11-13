class Solution {

    private boolean possible(int[] points,int m ,long mid){

        long tillnow=0,moves=0,skipnextmoves=0;
        for(int p:points){

            if(moves>m) return false;
            long gamemoves = (mid+p-1)/p;

            if(tillnow>=gamemoves) {
                tillnow=0;
                skipnextmoves+=1;
            }

            else{
                long alreadyaddedpoints = p*tillnow;
                long gamesrequired=(mid-alreadyaddedpoints+p-1)/p;
                moves+=(gamesrequired*2)-1;

                tillnow=Math.max(0L,gamesrequired-1); //should  not be negative

                moves+=skipnextmoves;

                skipnextmoves=0;
            }

            
        }

        return moves<=m;
    }
    public long maxScore(int[] points, int m) {
        long l=0;
        long r=(long) 1e15;
        long result = 0;

        while(l<=r){
            long mid = l + (r-l)/2;
            if(possible(points,m,mid)){
                result = mid;
                l=mid+1;
            }
            else r=mid-1;

        }

        return result;
    }
}