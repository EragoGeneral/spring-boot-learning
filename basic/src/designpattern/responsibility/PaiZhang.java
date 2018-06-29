package designpattern.responsibility;

public class PaiZhang extends Officer {

	public PaiZhang(String name) {
		super(name);
	}

	@Override
	public void handleMission(Mission mission) {
		if (mission.getEnemyNumber() > 10 && mission.getEnemyNumber() < 50) {
			System.out.println("排长"+name+"接到"+mission.getSoldierName()+"的军情"+",敌人数量为"+mission.getEnemyNumber()+",可以下达作战指令");
		}else{
			if(this.successor != null){
				this.successor.handleMission(mission);
			}
		}
	}

}
