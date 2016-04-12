package character;

public abstract class Character {

	private int intelligence;
	private int strength;
	private int presence;
	private int wits;
	private int dexterity;
	private int manipulation;
	private int resolve;
	private int stamina;
	private int composure;
	private int health;
	
	public Character(){
		setIntelligence(2);
		setStrength(2);
		setPresence(2);
		setWits(2);
		setDexterity(2);
		setManipulation(2);
		setResolve(2);
		setStamina(2);
		setComposure(2);
		setHealth((strength + stamina + resolve)*2);
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getWits() {
		return wits;
	}
	public void setWits(int wits) {
		this.wits = wits;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getManipulation() {
		return manipulation;
	}
	public void setManipulation(int manipulation) {
		this.manipulation = manipulation;
	}
	public int getResolve() {
		return resolve;
	}
	public void setResolve(int resolve) {
		this.resolve = resolve;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getComposure() {
		return composure;
	}
	public void setComposure(int composure) {
		this.composure = composure;
	}

	public int getPresence() {
		return presence;
	}

	public void setPresence(int presence) {
		this.presence = presence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}