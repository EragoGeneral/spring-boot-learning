package designpattern.command.operation;

/** 
 * ����ӿڣ�����ִ�еĲ�����֧�ֿɳ������� 
 */  
public interface Command {  
    /** 
     * ִ�������Ӧ�Ĳ��� 
     */  
    public void execute();  
    /** 
     * ִ�г��������Ӧ�Ĳ��� 
     */  
    public void undo();  
}  
