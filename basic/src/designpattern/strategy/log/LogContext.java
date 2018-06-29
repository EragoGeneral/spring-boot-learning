package designpattern.strategy.log;

/**
 * ��־��¼��������
 */
public class LogContext {
	
	/**
	 * ��¼��־�ķ������ṩ���ͻ���ʹ��
	 * @param msg	��Ҫ��¼����־��Ϣ
	 */
	public void log(String msg){
		//�����������棬����ʵ�ֶԾ�����Ե�ʵ��
		LogStrategy strategy = new DbLog();
		try{
			strategy.log(msg);
		}catch(Exception e){
			//�����ˣ��Ǿͼ�¼���ļ���
			strategy = new FileLog();
			strategy.log(msg);
		}
	}
}
