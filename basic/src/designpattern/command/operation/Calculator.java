package designpattern.command.operation;

import java.util.ArrayList;
import java.util.List;

/** 
 * �������࣬���������мӷ���ť��������ť�����г����ͻָ��İ�ť 
 */  
public class Calculator {  
	
	/** 
	* ����Ĳ�������ʷ��¼���ڳ���ʱ���� 
	*/  
	private List<Command> undoCmds = new ArrayList<>();   
	
	/** 
	* �����������ʷ��¼���ڻָ�ʱ���� 
	*/  
	private List<Command> redoCmds = new ArrayList<>();  
	
    /** 
     * ����ִ�мӷ���������� 
     */  
    private Command addCmd = null;  
    /** 
     * ����ִ�м������������ 
     */  
    private Command substractCmd = null;  
    /** 
     * ����ִ�мӷ���������� 
     * @param addCmd ִ�мӷ���������� 
     */  
    public void setAddCmd(Command addCmd) {  
        this.addCmd = addCmd;  
    }  
    /** 
     * ����ִ�м������������ 
     * @param substractCmd ִ�м������������ 
     */  
    public void setSubstractCmd(Command substractCmd) {  
        this.substractCmd = substractCmd;  
    }     
    /** 
     * �ṩ���ͻ�ʹ�ã�ִ�мӷ� ���� 
     */  
    public void addPressed(){  
        this.addCmd.execute();  
        //�Ѳ�����¼����ʷ��¼����  
        undoCmds.add(this.addCmd);  
    }  
    /** 
     * �ṩ���ͻ�ʹ�ã�ִ�м��� ���� 
     */  
    public void substractPressed(){  
        this.substractCmd.execute(); 
        //�Ѳ�����¼����ʷ��¼����  
        undoCmds.add(this.substractCmd);  
    }  
    
    public void undoPressed(){  
    	if(this.undoCmds.size()>0){  
	        //ȡ�����һ������������  
	        Command cmd = this.undoCmds.get(this.undoCmds.size()-1);  
	        cmd.undo();  
	        //������лָ��Ĺ��ܣ��ǾͰ���������¼���ָ�����ʷ��¼����
	        this.redoCmds.add(cmd); 
	        //Ȼ������һ������ɾ������  
	        this.undoCmds.remove(cmd);  
	    }else{  
	        System.out.println("�ܱ�Ǹ��û�пɳ���������");  
	    } 
    }
    
    public void redoPressed(){  
        if(this.redoCmds.size()>0){  
            //ȡ�����һ������������  
            Command cmd = this.redoCmds.get(this.redoCmds.size()-1);  
            cmd.execute();        
            //����������¼���ɳ�������ʷ��¼����
            this.undoCmds.add(cmd);  
            //Ȼ������һ������ɾ����  
            this.redoCmds.remove(cmd);  
        }else{  
            System.out.println("�ܱ�Ǹ��û�пɻָ�������");  
        }  
    }  
}  