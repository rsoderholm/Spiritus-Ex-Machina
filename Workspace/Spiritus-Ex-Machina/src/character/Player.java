package character;

public class Player extends Character {
	
	private int maxhealth;
	public Player(){
		super();
		setMaxhealth(getHealth());
	}
	public int getMaxhealth() {
		return maxhealth;
	}
	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}
}
