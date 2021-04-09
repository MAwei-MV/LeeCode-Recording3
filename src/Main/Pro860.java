package Main;

public class Pro860 {
    public static void main(String args[]){
        int a[]={5,5,5,10,20};
        Pro860 p=new Pro860();
        System.out.println(p.lemonadeChange(a));
    }

    public boolean lemonadeChange(int[] bills) {
      int temp0=0;
      int temp1=0;
      for(int i=0;i<bills.length;i++){
       switch(bills[i]){
           case(5): temp0++;
           break;
           case(10):if(temp0==0) return false;
            else {
                temp0--;
                temp1++;
                break;
           }
           case(20):if((temp0>=1&&temp1>=1)||temp0>=3){
               if(temp1>=1){
                   temp1--;
                   temp0--;
               }
               else{
                   temp0-=3;
               }
               break;
           }
            else return false;
       }
      }
      return true;
    }
}
