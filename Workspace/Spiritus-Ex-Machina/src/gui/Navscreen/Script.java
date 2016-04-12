package gui.Navscreen;

import game.Controller;

public final class Script {
	private String eventText;
	private Controller controller;
	
	
	public Script(Controller controller){
		this.controller = controller;
		controller.addNavigation("ett", () -> this.test1());
		controller.addNavigation("tva", () -> this.test2());
		controller.addNavigation("tre", () -> this.test3());
		controller.addNavigation("fyra", () -> this.test4());
	}
	
	public void test1() {
		eventText = "Instincts take over and you immediately burst into motion, nearly escapes a blow from a shady figure."
				+ "\n" + "They found me.....";
		
		controller.getGUI().setEventText(eventText);
		controller.getGUI().setDialog("Dont look back and run as fast as you can towards the train",1, "ett");
		controller.getGUI().setDialog("Unload a swarm of bullets at the direction of the shady figure",2, "tva");
		controller.getGUI().setDialog("Try reasoning with the attacker",3, "tre");
		controller.getGUI().setDialog("Throw the gun at the floor and scream at the top of your lungs your most fierce battle cry",4, "fyra");
		
	}
	public void combat(){
		controller.getGUI().setEventText("");
	}
	

	public void test2() {
		eventText = "Your fast movement has given you the upper hand, the shaded figure tries to grab something underneath his coat.";

			
		controller.getGUI().setEventText(eventText);
		controller.getGUI().setDialog("Fire the gun mercilessly at the attacker, aiming for the head",1, "ett");
		controller.getGUI().setDialog("Not sure what the intentions of the man are, you hesitate. ",2, "tva");
		controller.getGUI().setDialog("Fire the gun, but with the intentions to disable the attacker not kill him.",3, "tre");
		controller.getGUI().setDialog("Scream WAIT!! and slowly put the gun on the ground",4, "fyra");
	}

	public void test3() {
		eventText = "I have no intention of being caught. You know who i am right? " + "\n"
				+ "The man stares at you with blank eyes" + "\n" + "\n" + "\n"
				+ "The man whispers: Doesn't matter, i'm a dead man anyway.";
		controller.getGUI().setEventText(eventText);
	
		controller.getGUI().setDialog("Try convincing the man out of the fight",1, "ett");
		controller.getGUI().setDialog("Throw some dust that you scraped up in your pocket at the attacker and start to run againt the leaving train",2, "tva");
		controller.getGUI().setDialog("Begin speaking in tongues ",3, "tre");
		controller.getGUI().setDialog("Use the converstions as a distraction and fire your gun at the attackers",4, "fyra");
	}

	public void test4() {
		eventText = "The man reacts faster the you could imagien possiable, draws and strange looking device." + "\n"
				+ "\n" + "\n" + "Before you even comprehend the situation the man uses the device on you and "
				+ "suddenely a sharp pain goes through your hole body.......";

		controller.getGUI().setEventText(eventText);
	
		controller.getGUI().setDialog("Fall to the ground, pretending to faint",1, "ett");
		controller.getGUI().setDialog("ignore the pain and tackle the attacker",2, "tva");
		controller.getGUI().setDialog("Scream of pain and ask the attackers why he did that?",3, "tre");
		controller.getGUI().setDialog("Stand completely still and pretend that the device did not work",4, "fyra");
	}
}
