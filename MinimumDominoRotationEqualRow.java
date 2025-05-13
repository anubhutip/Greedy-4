

/*
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer,Integer> map=new HashMap<>();
        int target=1;
        for(int i=0;i<tops.length;i++){
             int top=tops[i];
             map.put(top,map.getOrDefault(top,0)+1);
             if(map.get(top)>=tops.length){
                target=top;
                break;
             }

             int bot=bottoms[i];
             map.put(bot,map.getOrDefault(bot,0)+1);
             if(map.get(bot)>=tops.length){
                target=bot;
                break;
             }
        }
        
        int arot=0;
        int brot=0;
        for(int i=0;i<tops.length;i++){
            int top=tops[i];
            int bot=bottoms[i];
            if(top!=target && bot!=target){
                return -1;
            }else if(top!=target){
                arot++;
            }else if(bot!=target){
                brot++;
            }
        }
        return Math.min(arot,brot);
    }
}
*/
//TC: O(2n)= O(n)
//SC: O(1)
class MinimumDominoRotationEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int a=tops[0];
        int resa=check(tops,bottoms,a);
        if(resa!=-1){
            return resa;
        }
        int b=bottoms[0];
        int resb=check(tops,bottoms,b);
        return resb;    
    }

    private int check(int[] tops,int[] bottoms,int target){
        int arot=0;
        int brot=0;
        for(int i=0;i<tops.length;i++){
            int top=tops[i];
            int bot=bottoms[i];
            if(top!=target && bot!=target){
                return -1;
            }else if(top!=target){
                arot++;
            }else if(bot!=target){
                brot++;
            }
        }
        return Math.min(arot,brot);
    }
}