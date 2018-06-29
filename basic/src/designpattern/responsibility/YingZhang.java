package designpattern.responsibility;

public class YingZhang extends Officer{

	public YingZhang(String name) {
		super(name);
	}

	@Override
	public void handleMission(Mission mission) {
		if(mission.getEnemyNumber()>=50 && mission.getEnemyNumber()<200){
            System.out.println("Ӫ��"+name+"�ӵ�"+mission.getSoldierName()+"�ľ���"+",��������Ϊ"+mission.getEnemyNumber()+",�����´���սָ��");
        }else{
            System.out.println("�ӵ�"+mission.getSoldierName()+"�ľ���"+",��������Ϊ"+mission.getEnemyNumber()+",����̫���ˣ����ǿ�������һ�°ɣ�");
        }
	}

}
