package designpattern.command.cook;

/** 
 * ��ʦ���������� 
 */  
public class CoolCook implements CookApi {
	
	/** 
     * ��ʦ���� 
     */  
    private String name;  
	
	@Override
	public void cook(int tableNum, String name) {
		//ÿ�����˵�ʱ���ǲ�һ���ģ��ø��������ģ��һ��  
        int cookTime = (int)(20 * Math.random());  
		System.out.println(this.name+"��ʦ����Ϊ"+tableNum +"��������"+name);
		try {  
            //���߳���Ϣ��ô��ʱ�䣬��ʾ��������  
            Thread.sleep(cookTime);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(this.name+"��ʦΪ"+tableNum +"���������ˣ�"+name+",���ƺ�ʱ="+cookTime+"��");  
	}  
} 
