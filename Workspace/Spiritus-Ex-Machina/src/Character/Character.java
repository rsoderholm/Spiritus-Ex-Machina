package Character;

public abstract class Character {
	private String name;
	private int intelligence;
	private int wits;
	private int resolve;
	private int strength;
	private int dexterity;
	private int stamina;
	private int Presence;
	private int manipulation;
	private int composure;
	private int physicalHealth;
	private int mentalHealth;

	public Character(){
		setIntelligence(2);
		setWits(2);
		setResolve(2);
		setStrength(2);
		setDexterity(2);
		setStamina(2);
		setPresence(2);
		setManipulation(2);
		setComposure(2);
		setPhysicalHealth((strength+stamina)*2);
		setMentalHealth((intelligence+resolve)*2);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getWits() {
		return wits;
	}
	public void setWits(int wits) {
		this.wits = wits;
	}
	public int getResolve() {
		return resolve;
	}
	public void setResolve(int resolve) {
		this.resolve = resolve;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getPresence() {
		return Presence;
	}
	public void setPresence(int presence) {
		Presence = presence;
	}
	public int getManipulation() {
		return manipulation;
	}
	public void setManipulation(int manipulation) {
		this.manipulation = manipulation;
	}
	public int getComposure() {
		return composure;
	}
	public void setComposure(int composure) {
		this.composure = composure;
	}
	public int getPhysicalHealth() {
		return physicalHealth;
	}
	public void setPhysicalHealth(int physicalHealth) {
		this.physicalHealth = physicalHealth;
	}

	public int getMentalHealth() {
		return mentalHealth;
	}

	public void setMentalHealth(int mentalHealth) {
		this.mentalHealth = mentalHealth;
	}

}
