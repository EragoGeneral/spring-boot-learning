package designpattern.responsibility;

public class Client {
	public static void main(String[] args) {
		
		Officer banZhang = new Bangzhang("张小三");
		Officer paiZhang = new PaiZhang("李小四");
		Officer yingZhang = new YingZhang("王小五");
		
		banZhang.setSuccessor(paiZhang);
		paiZhang.setSuccessor(yingZhang);
		
		Mission m1 = new Mission("周小妹", 8);
		banZhang.handleMission(m1);
		
		Mission m2 = new Mission("曾小妹", 36);
		banZhang.handleMission(m2);

        Mission m3 = new Mission("李小妹", 188);
        banZhang.handleMission(m3);

        Mission m4 = new Mission("孙小妹", 269);
        banZhang.handleMission(m4);
	}
}
