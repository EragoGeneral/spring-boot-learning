package designpattern.command.operation;

import java.util.ArrayList;
import java.util.List;

/** 
 * 计算器类，计算器上有加法按钮、减法按钮，还有撤销和恢复的按钮 
 */  
public class Calculator {  
	
	/** 
	* 命令的操作的历史记录，在撤销时候用 
	*/  
	private List<Command> undoCmds = new ArrayList<>();   
	
	/** 
	* 命令被撤销的历史记录，在恢复时候用 
	*/  
	private List<Command> redoCmds = new ArrayList<>();  
	
    /** 
     * 持有执行加法的命令对象 
     */  
    private Command addCmd = null;  
    /** 
     * 持有执行减法的命令对象 
     */  
    private Command substractCmd = null;  
    /** 
     * 设置执行加法的命令对象 
     * @param addCmd 执行加法的命令对象 
     */  
    public void setAddCmd(Command addCmd) {  
        this.addCmd = addCmd;  
    }  
    /** 
     * 设置执行减法的命令对象 
     * @param substractCmd 执行减法的命令对象 
     */  
    public void setSubstractCmd(Command substractCmd) {  
        this.substractCmd = substractCmd;  
    }     
    /** 
     * 提供给客户使用，执行加法 功能 
     */  
    public void addPressed(){  
        this.addCmd.execute();  
        //把操作记录到历史记录里面  
        undoCmds.add(this.addCmd);  
    }  
    /** 
     * 提供给客户使用，执行减法 功能 
     */  
    public void substractPressed(){  
        this.substractCmd.execute(); 
        //把操作记录到历史记录里面  
        undoCmds.add(this.substractCmd);  
    }  
    
    public void undoPressed(){  
    	if(this.undoCmds.size()>0){  
	        //取出最后一个命令来撤销  
	        Command cmd = this.undoCmds.get(this.undoCmds.size()-1);  
	        cmd.undo();  
	        //如果还有恢复的功能，那就把这个命令记录到恢复的历史记录里面
	        this.redoCmds.add(cmd); 
	        //然后把最后一个命令删除掉，  
	        this.undoCmds.remove(cmd);  
	    }else{  
	        System.out.println("很抱歉，没有可撤销的命令");  
	    } 
    }
    
    public void redoPressed(){  
        if(this.redoCmds.size()>0){  
            //取出最后一个命令来重做  
            Command cmd = this.redoCmds.get(this.redoCmds.size()-1);  
            cmd.execute();        
            //把这个命令记录到可撤销的历史记录里面
            this.undoCmds.add(cmd);  
            //然后把最后一个命令删除掉  
            this.redoCmds.remove(cmd);  
        }else{  
            System.out.println("很抱歉，没有可恢复的命令");  
        }  
    }  
}  