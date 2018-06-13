package d2draft;

public class Hero {
	private int heroID;
	private String name;
	private String[] roles;
	//attributes
	private int teamFight;
	private int waveClear;
	private int catchCapability;
	private int towerPush;
	private int burstDamage;
	private int counterInitiate;
	private int disengage;
	private int lanePressure;
	private int roshTaking;
	private int splitPush;
	//have array of int for role/lane
	public Hero(int heroID, String[] roles, String name, int teamFight, int waveClear, int catchCapability, int towerPush, int burstDamage, int counterInitiate, int disengage, int lanePressure, int roshTaking, int splitPush) {
		this.heroID = heroID;
		this.roles = roles;
		this.name = name;
		this.teamFight = teamFight;
		this.waveClear = waveClear;
		this.catchCapability = catchCapability;
		this.towerPush = towerPush;
		this.burstDamage = burstDamage;
		this.counterInitiate = counterInitiate;
		this.disengage = disengage;
		this.lanePressure = lanePressure;
		this.roshTaking = roshTaking;
		this.splitPush = splitPush;
	}
	public String getName() {
		return this.name;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public void setTeamFight(int teamFight) {
		this.teamFight = teamFight;
	}
	public void setWaveClear(int waveClear) {
		this.waveClear = waveClear;
	}
	public void setCatchCapability(int catchCapability) {
		this.catchCapability = catchCapability;
	}
	public void setTowerPush(int towerPush) {
		this.towerPush = towerPush;
	}
	public void setBurstDamage(int burstDamage) {
		this.burstDamage = burstDamage;
	}
	public void setCounterInitiate(int counterInitiate) {
		this.counterInitiate = counterInitiate;
	}
	public void setDisengage(int disengage) {
		this.disengage = disengage;
	}
	public void setLanePressure(int lanePressure) {
		this.lanePressure = lanePressure;
	}
	public void setRoshTaking(int roshTaking) {
		this.roshTaking = roshTaking;
	}
	public void setSplitPush(int splitPush) {
		this.splitPush = splitPush;
	}
	public String toString() {
		return this.name;
	}
}
