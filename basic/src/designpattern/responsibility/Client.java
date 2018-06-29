package designpattern.responsibility;

public class Client {
	public static void main(String[] args) {
		
		Officer banZhang = new Bangzhang("��С��");
		Officer paiZhang = new PaiZhang("��С��");
		Officer yingZhang = new YingZhang("��С��");
		
		banZhang.setSuccessor(paiZhang);
		paiZhang.setSuccessor(yingZhang);
		
		Mission m1 = new Mission("��С��", 8);
		banZhang.handleMission(m1);
		
		Mission m2 = new Mission("��С��", 36);
		banZhang.handleMission(m2);

        Mission m3 = new Mission("��С��", 188);
        banZhang.handleMission(m3);

        Mission m4 = new Mission("��С��", 269);
        banZhang.handleMission(m4);
	}
}
