package designpattern.mediator.mainboard;


/**
 * 主板类，实现中介者接口
 */
public class MotherBoard implements Mediator {

	/**
     * 需要知道要交互的同事类——光驱类
     */
    private CDDriver cdDriver = null;
    /**
     * 需要知道要交互的同事类——CPU类
     */
    private CPU cpu = null;
    /**
     * 需要知道要交互的同事类——显卡类
     */
    private VideoCard videoCard = null;
    /**
     * 需要知道要交互的同事类——声卡类
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
			//表示光驱读取数据了
			this.opeCDDriverReadData((CDDriver)colleague);
		}else if(colleague == cpu){
			//表示CPU处理完了
			this.opeCPU((CPU)colleague);
		}
	}
	
	/**
	* 处理光驱读取数据过后与其它对象的交互
	* @param cd 光驱同事对象
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
