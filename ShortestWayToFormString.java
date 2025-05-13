import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC: O(mlogn)
//SC: O(n)
class ShortestWayToFormString {
  public int shortestWay(String source, String target) {
      Map<Character,List<Integer> > map=new HashMap<>();
      for(int i=0;i<source.length();i++){
          char ch=source.charAt(i);
          if(!map.containsKey(ch)){
              map.put(ch,new ArrayList<>());
          }
          map.get(ch).add(i);
      }

      int count=1;
      int tp=0;
      int sp=0;
      while(tp<target.length()){
          char tch=target.charAt(tp);
          if(!map.containsKey(tch)){
              return -1;
          }
          if(sp==source.length()){
              count++;
              sp=0;
          }
          char sch=source.charAt(sp);
          if(sch!=tch){
              List<Integer> li=map.get(tch);
              int bsidx = binarySearch(li,sp);
              if(bsidx==li.size()){
                  //reset
                  sp=li.get(0);
                  count++;

              }else{
                  sp=li.get(bsidx);                
              }
          }            
          sp++;
          tp++;
      }
      return count;
  }

  private int binarySearch(List<Integer> li,int target){
      int low=0;
      int high=li.size()-1;
      while(low<=high){
          int mid=low+(high-low)/2;
          if(li.get(mid)<target){
              low=mid+1;
          }else{
              high=mid-1;
          }
      }
      return low;
  }
}


/*
class Solution {
  public int shortestWay(String source, String target) {
      Set<Character > set=new HashSet<>();
      for(int i=0;i<source.length();i++){
          set.add(source.charAt(i));
      }

      int count=1;
      int sp=0;
      int tp=0;
      while(tp<target.length()){
          char tchar=target.charAt(tp);
          if(!set.contains(tchar)){
              return -1;
          }
          char schar=source.charAt(sp);
          if(schar==tchar){
              sp++;
              tp++;
              if(tp==target.length()){
                  return count;
              }
          }else{
              sp++;
          }
          if(sp==source.length()){
              sp=0;
              count++;
          }
      }
      return 332;
  }
}
*/