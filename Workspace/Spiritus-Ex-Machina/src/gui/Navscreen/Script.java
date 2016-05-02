package gui.Navscreen;

import game.Controller;

public final class Script {
	private String eventText;
	private Controller controller;
	private String[] currentDialog = new String[9];
	
	
	public Script(Controller controller){
		this.controller = controller;
		controller.addNavigation("init", () -> this.init());
		controller.addNavigation("ett", () -> this.test1());
		controller.addNavigation("tva", () -> this.test2());
		controller.addNavigation("tre", () -> this.test3());
		controller.addNavigation("fyra", () -> this.test4());
		controller.addNavigation("fem", () -> this.test5());
		controller.addNavigation("combat1", () -> controller.startCombat("fem"));

	}
	
	private void init() {
		
		getCurrentDialog()[0]="You take the stairs down to the subway station, trying to brace your self as much as possible for the stench. "
				+ "Gravel and bits of broken glass crunch under foot as you sidestep the small piles of detritus scatteredhaphazardly all over the station. "
				+ "The smell is unbearable. A combination of rotting garbage, stale urine and the remains of rats and other animals have mixed together to form a smell that defies any attempt at ignore it. "
				+ "You've almost reached the train when a sudden movement to the side catches you attention.." + "\n"
				+ "\n"
				+ "[Pick a one of the playable options available to you. The attributes required to succeed are written"
				+ "next to the option. The more point you have of a certain attributes, the higher your chances of"
				+ "success when using that attribute.]";
		getCurrentDialog()[1]="Initiate Combat";
		getCurrentDialog()[2]="combat1";
		getCurrentDialog()[3]="Pull out your gun and take aim at the possible attacker";
		getCurrentDialog()[4]="tva";
		getCurrentDialog()[5]="Confront however is in the shadows";
		getCurrentDialog()[6]="tre";
		getCurrentDialog()[7]="Attack them bare handed";
		getCurrentDialog()[8]="fyra";
		controller.setupDialog(getCurrentDialog());
	}
	

	public void test1() {
		eventText = "Instincts take over and you immediately burst into motion, nearly escapes a blow from a shady figure."
				+ "\n" + "They found me.....";
		
		controller.getGUI().setEventText(eventText);
		controller.getGUI().setDialog("Dont look back and run as fast as you can towards the train",1, "ett");
		controller.getGUI().setDialog("Unload a swarm of bullets at the direction of the shady figure",3, "tva");
		controller.getGUI().setDialog("Try reasoning with the attacker",5, "tre");
		controller.getGUI().setDialog("Throw the gun at the floor and scream at the top of your lungs your most fierce battle cry",7, "fyra");
		
	}
	public void test2() {
		eventText = "Your fast movement has given you the upper hand, the shaded figure tries to grab something underneath his coat.";

			
		controller.getGUI().setEventText(eventText);
		controller.getGUI().setDialog("Fire the gun mercilessly at the attacker, aiming for the head",1, "ett");
		controller.getGUI().setDialog("Not sure what the intentions of the man are, you hesitate. ",3, "tva");
		controller.getGUI().setDialog("Fire the gun, but with the intentions to disable the attacker not kill him.",5, "tre");
		controller.getGUI().setDialog("Scream WAIT!! and slowly put the gun on the ground",7, "fyra");
	}

	public void test3() {
		eventText = "I have no intention of being caught. You know who i am right? " + "\n"
				+ "The man stares at you with blank eyes" + "\n" + "\n" + "\n"
				+ "The man whispers: Doesn't matter, i'm a dead man anyway.";
		controller.getGUI().setEventText(eventText);
	
		controller.getGUI().setDialog("Try convincing the man out of the fight",1, "ett");
		controller.getGUI().setDialog("Throw some dust that you scraped up in your pocket at the attacker and start to run againt the leaving train",3, "tva");
		controller.getGUI().setDialog("Begin speaking in tongues ",5, "tre");
		controller.getGUI().setDialog("Use the converstions as a distraction and fire your gun at the attackers",7, "fyra");
	}

	public void test4() {
		eventText = "The man reacts faster the you could imagien possiable, draws and strange looking device." + "\n"
				+ "\n" + "\n" + "Before you even comprehend the situation the man uses the device on you and "
				+ "suddenely a sharp pain goes through your hole body.......";

		controller.getGUI().setEventText(eventText);
	
		controller.getGUI().setDialog("Fall to the ground, pretending to faint",1, "ett");
		controller.getGUI().setDialog("ignore the pain and tackle the attacker",3, "tva");
		controller.getGUI().setDialog("Scream of pain and ask the attackers why he did that?",5, "tre");
		controller.getGUI().setDialog("Stand completely still and pretend that the device did not work",7, "fyra");
	}
	public void test5() {
		eventText = "Stumbling on the ground and spitting blood the man smiled. "
				+ "\n \"Heh... you\'ve gained nothing from this\" he said as the collapsed on the ground.";
		
		controller.getGUI().setEventText(eventText);
		controller.getGUI().setDialog("Dont look back and run as fast as you can towards the train",1, "combat1");
		controller.getGUI().setDialog("Unload a swarm of bullets at the direction of the shady figure",3, "tva");
		controller.getGUI().setDialog("Try reasoning with the attacker",5, "tre");
		controller.getGUI().setDialog("Throw the gun at the floor and scream at the top of your lungs your most fierce battle cry",7, "fyra");
		
	}

	public String[] getCurrentDialog() {
		return currentDialog;
	}

	public void setCurrentDialog(String[] currentDialog) {
		this.currentDialog = currentDialog;
	}
}
