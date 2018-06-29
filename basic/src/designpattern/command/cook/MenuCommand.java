package designpattern.command.cook;

import java.util.ArrayList;
import java.util.Collection;

/** 
 * �˵������Ǹ���������� 
 */  
public class MenuCommand implements Command {  
    /** 
     * ������¼��ϱ��˵��Ķ����Ʒ��Ҳ���Ƕ��������� 
     */  
    private Collection<Command> col = new ArrayList<>();  
    /** 
     * ��ˣ��Ѳ�Ʒ���뵽�˵��� 
     * @param cmd �ͻ���Ĳ� 
     */  
    public void addCommand(Command cmd){  
        col.add(cmd);  
    }  
	@Override
	public void setCookApi(CookApi cookApi) {
		
	}
	@Override
	public int getTableNum() {

		return 0;
	}  
    public void execute() {  
        CommandQueue.addMenu(this);
    }
    
    /** 
     * ��ȡ�˵��еĶ��������� 
     * @return �˵��еĶ��������� 
     */  
    public Collection<Command> getCommands(){  
        return this.col;  
    }
}  