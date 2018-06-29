package designpattern.responsibility;

public class Mission {

	private String soldierName;
	private int enemyNumber;
	
	public Mission() {
		super();
	}

	public Mission(String soldierName, int enemyNumber) {
		super();
		this.soldierName = soldierName;
		this.enemyNumber = enemyNumber;
	}

	public String getSoldierName() {
		return soldierName;
	}

	public void setSoldierName(String soldierName) {
		this.soldierName = soldierName;
	}

	public int getEnemyNumber() {
		return enemyNumber;
	}

	public void setEnemyNumber(int enemyNumber) {
		this.enemyNumber = enemyNumber;
	}
}
