package designpattern.command.cook;

/** 
 * 命令对象，蒜泥白肉 
 */  
public class PorkCommand implements Command{  
    /** 
     * 持有具体做菜的厨师的对象 
     */  
    private CookApi cookApi = null;  
    /** 
     * 设置具体做菜的厨师的对象 
     * @param cookApi 具体做菜的厨师的对象 
     */  
    public void setCookApi(CookApi cookApi) {  
        this.cookApi = cookApi;  
    }  
  
    /** 
     * 点菜的桌号 
     */  
    private int tableNum;  
    /** 
     * 构造方法，传入点菜的桌号 
     * @param tableNum 点菜的桌号 
     */  
    public PorkCommand(int tableNum){  
        this.tableNum = tableNum;  
    }  
    public int getTableNum(){  
        return this.tableNum;  
    }
    
    public void execute() {  
        this.cookApi.cook(tableNum, "蒜泥白肉");  
    }  
}  