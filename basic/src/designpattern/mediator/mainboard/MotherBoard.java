package designpattern.mediator.mainboard;


/**
 * �����࣬ʵ���н��߽ӿ�
 */
public class MotherBoard implements Mediator {

	/**
     * ��Ҫ֪��Ҫ������ͬ���ࡪ��������
     */
    private CDDriver cdDriver = null;
    /**
     * ��Ҫ֪��Ҫ������ͬ���ࡪ��CPU��
     */
    private CPU cpu = null;
    /**
     * ��Ҫ֪��Ҫ������ͬ���ࡪ���Կ���
     */
    private VideoCard videoCard = null;
    /**
     * ��Ҫ֪��Ҫ������ͬ���ࡪ��������
     */
    private SoundCard soundCard = null;
	
    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
     }
     public void setCpu(CPU cpu) {
        this.cpu = cpu;
     }
     public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
     }
     public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
     }
    
	@Override
	public void changed(Colleague colleague) {
		if(colleague == cdDriver){
			//��ʾ������ȡ������
			this.opeCDDriverReadData((CDDriver)colleague);
		}else if(colleague == cpu){
			//��ʾCPU��������
			this.opeCPU((CPU)colleague);
		}
	}
	
	/**
	* ���������ȡ���ݹ�������������Ľ���
	* @param cd ����ͬ�¶���
	*/
	public void opeCDDriverReadData(CDDriver cd){
		String data = cd.getData();
		this.cpu.executeData(data);
	}
	
	public void opeCPU(CPU cpu){
		String videoData = cpu.getVideoData();
		String soundData = cpu.getSoundData();
		this.videoCard.showData(videoData);
		this.soundCard.soundData(soundData);
	}
}
