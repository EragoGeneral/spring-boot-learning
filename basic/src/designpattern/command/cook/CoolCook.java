package designpattern.command.cook;

/** 
 * 厨师对象，做凉菜 
 */  
public class CoolCook implements CookApi {
	
	/** 
     * 厨师姓名 
     */  
    private String name;  
	
	@Override
	public void cook(int tableNum, String name) {
		//每次做菜的时间是不一定的，用个随机数来模拟一下  
        int cookTime = (int)(20 * Math.random());  
		System.out.println(this.name+"厨师正在为"+tableNum +"号桌做："+name);
		try {  
            //让线程休息这么长时间，表示正在做菜  
            Thread.sleep(cookTime);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(this.name+"厨师为"+tableNum +"号桌做好了："+name+",共计耗时="+cookTime+"秒");  
	}  
} 
