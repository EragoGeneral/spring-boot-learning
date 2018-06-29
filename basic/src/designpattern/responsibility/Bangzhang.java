package designpattern.responsibility;

public class Bangzhang extends Officer {
	
	public Bangzhang(String name) {
		super(name);
	}

	@Override
	public void handleMission(Mission mission) {
		if (mission.getEnemyNumber() > 0 && mission.getEnemyNumber() < 10) {
			System.out.println("�೤"+name+"�ӵ�"+mission.getSoldierName()+"�ľ���"+",��������Ϊ"+mission.getEnemyNumber()+",�����´���սָ��");
		}else{
			if(this.successor != null){
				this.successor.handleMission(mission);
			}
		}
	}

}
