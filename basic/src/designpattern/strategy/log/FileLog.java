package designpattern.strategy.log;

/**
* ����־��¼���ļ�
*/
public class FileLog extends LogStrategyTemplate{
    public void doLog(String msg) {
       System.out.println("���ڰ� '"+msg+"' ��¼���ļ���");
    }
}
