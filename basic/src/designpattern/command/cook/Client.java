package designpattern.command.cook;

public class Client {  
    public static void main(String[] args) {  
        //��Ҫ������̨��������������������  
        CookManager.runCookManager();  
          
        //Ϊ�˼򵥣�ֱ����ѭ��ģ�������ŵ��  
        for(int i = 0; i < 10; i++){  
            //��������Ա  
            Waiter waiter = new Waiter();  
            //����������󣬾���Ҫ��Ĳ�  
            Command chop = new ChopCommand(i);  
            Command duck = new DuckCommand(i);  
//            Command pork = new PorkCommand(i);
  
            //��ˣ����ǰ���Щ���÷���Ա��¼����  
            waiter.orderDish(chop);  
            waiter.orderDish(duck);  
//            waiter.orderDish(pork);
  
            //������  
            waiter.orderOver();  
        }         
    }  
}  
