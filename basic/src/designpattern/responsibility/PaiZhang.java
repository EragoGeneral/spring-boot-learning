package designpattern.responsibility;

public class PaiZhang extends Officer {

	public PaiZhang(String name) {
		super(name);
	}

	@Override
	public void handleMission(Mission mission) {
		if (mission.getEnemyNumber() > 10 && mission.getEnemyNumber() < 50) {
			System.out.println("�ų�"+name+"�ӵ�"+mission.getSoldierName()+"�ľ���"+",��������Ϊ"+mission.getEnemyNumber()+",�����´���սָ��");
		}else{
			if(this.successor != null){
				this.successor.handleMission(mission);
			}
		}
	}

}
