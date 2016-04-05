package gui.Navscreen;

import java.io.File;
import java.util.Scanner;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class JavaFxTest {

	private Button buttonattr;
	private VBox layout1;
	private Stage window;
	private Scene scene;

	private String dialogText1 = "";
	private String dialogText2 = "";
	private String dialogText3 = "";
	private String dialogText4 = "";

	private Text text;
	private Text statusText;
	private Animation animation;

	private Button buttoninv;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private String eventText;

	private double width = 1200;
	private double height = Double.MAX_VALUE;
	private ImageView iv1;
	private ImageView iv2;
	private Image image;

	private Rectangle2D bounds;
	private Screen screen;
	private double widthScreen;
	private double heightScreen;

	
	
	
	
	public JavaFxTest() {
		
		window = new Stage();
		screen = Screen.getPrimary();
		bounds = screen.getVisualBounds();
		window.setWidth(bounds.getWidth());
		window.setHeight(bounds.getHeight());
		widthScreen = bounds.getWidth();
		heightScreen = bounds.getHeight();

		layout1 = new VBox();
		layout1.setAlignment(Pos.CENTER);
		scene = new Scene(layout1, widthScreen, heightScreen);
		scene.getStylesheets().add("StyleSheet.css");

		addImage();
		addtext();
		addbutton();
		Attributes();
		status(100);
		inventory();

		layout1.getChildren().addAll(iv1, text, button1, button2, button3, button4, statusText, buttoninv, buttonattr);
		setEventText();
		
		
		window.setResizable(false);
		window.setScene(scene);

		window.show();
	}

	public void addbutton() {
		// Knappar
		button1 = new Button(dialogText1);
		button1.setOnAction(e -> test1());
		button1.setMaxWidth(width);

		button2 = new Button(dialogText2);
		button2.setOnAction(e -> test2());
		button2.setMaxWidth(width);

		button3 = new Button(dialogText3);
		button3.setOnAction(e -> test3());
		button3.setMaxWidth(width);

		button4 = new Button(dialogText4);
		button4.setOnAction(e -> test4());
		button4.setMaxWidth(width);
	}

	public void addtext() {

		text = new Text();
		text.setWrappingWidth(1200);
		text.setFont(new Font(20));

		text.setTextAlignment(TextAlignment.JUSTIFY);
		text.setText(eventText);
		text.setFill(Color.WHITE);

		textanimation();
	}

	public void addImage() {
		image = new Image("JWET8.jpg");
		iv1 = new ImageView();
		iv1.setImage(image);
		iv1.setFitWidth(1200);

	}

	public void textanimation() {
		animation = new Transition() {
			{

				setCycleDuration(Duration.millis(2000));
			}

			protected void interpolate(double frac) {
				final int length = eventText.length();
				final int n = Math.round(length * (float) frac);
				text.setText(eventText.substring(0, n));
			}

		};
		animation.play();
	}

	public void setDialog(String dialog, int n) {
	
	 if (n == 1) {
	 dialogText1 = dialog;
	 button1.setText(dialogText1);
	 }else
	 if (n == 2) {
	 dialogText2 = dialog;
	 button2.setText(dialogText2);
	 }
	 else if (n == 3) {
	 dialogText3 = dialog;
	 button3.setText(dialogText3);
	 }
	 else if (n == 4) {
	 dialogText4 = dialog;
	 button4.setText(dialogText4);
	
	 }
	 }

	public void inventory() {
		buttoninv = new Button("Inventory");
		buttoninv.setOnAction(e -> new Inventory());
		buttoninv.setMaxHeight(600);
		buttoninv.setMaxWidth(200);
	}

	public void Attributes() {
		buttonattr = new Button("Attributes");
		buttonattr.setOnAction(e -> new Attributes());

		buttonattr.setMaxWidth(200);
	}

	public void status(int Nhp) {
		String hp = "Healthpoints: ";
		int nhp = Nhp;
		statusText = new Text();
		statusText.setFont(new Font(20));
		statusText.setTextAlignment(TextAlignment.CENTER);
		statusText.setFill(Color.WHITE);
		statusText.setText(hp + nhp);
	}
 
	public void setEventText() {
		eventText = "You take the stairs down to the subway station, trying to brace your self as much as possible for the stench. "
				+ "Gravel and bits of broken glass crunch under foot as you sidestep the small piles of detritus scatteredhaphazardly all over the station. "
				+ "The smell is unbearable. A combination of rotting garbage, stale urine and the remains of rats and other animals have mixed together to form a smell that defies any attempt at ignore it. "
				+ "You've almost reached the train when a sudden movement to the side catches you attention.." + "\n"

				+ "\n"
				+ "[Pick a one of the playable options available to you. The attributes required to succeed are written"
				+ "next to the option. The more point you have of a certain attributes, the higher your chances of"
				+ "success when using that attribute.]";

		setDialog("Ambush! Run! Dodge the attack",1);
		button2.setText("Pull out your gun and take aim at the possible attacker");
		button3.setText("Confront however is in the shadows");
		button4.setText("Attack them bare handed");
	}

	public void test1() {
		eventText = "Instincts take over and you immediately burst into motion, nearly escapes a blow from a shady figure."
				+ "\n" + "They found me.....";
		text.setText(eventText);
		textanimation();
		button1.setText("Dont look back and run as fast as you can towards the train");
		button2.setText("Unload a swarm of bullets at the direction of the shady figure");
		button3.setText("Try reasoning with the attacker");
		button4.setText("Throw the gun at the floor and scream at the top of your lungs your most fierce battle cry");
	}

	public void test2() {
		eventText = "Your fast movement has given you the upper hand, the shaded figure tries to grab something underneath his coat.";
		text.setText(eventText);
		textanimation();
		button1.setText("Fire the gun mercilessly at the attacker, aiming for the head");
		button2.setText("Not sure what the intentions of the man are, you hesitate. ");
		button3.setText("Fire the gun, but with the intentions to disable the attacker not kill him.");
		button4.setText("Scream WAIT!! and slowly put the gun on the ground");
	}

	public void test3() {
		eventText = "I have no intention of being caught. You know who i am right? " + "\n"
				+ "The man stares at you with blank eyes" + "\n" + "\n" + "\n"
				+ "The man whispers: Doesn't matter, i'm a dead man anyway.";
		text.setText(eventText);
		textanimation();
		button1.setText("Try convincing the man out of the fight");
		button2.setText(
				"Throw some dust that you scraped up in your pocket at the attacker and start to run againt the leaving train");
		button3.setText("Begin speaking in tongues ");
		button4.setText("Use the converstions as a distraction and fire your gun at the attackers");
	}

	public void test4() {
		eventText = "The man reacts faster the you could imagien possiable, draws and strange looking device." + "\n"
				+ "\n" + "\n" + "Before you even comprehend the situation the man uses the device on you and "
				+ "suddenely a sharp pain goes through your hole body.......";

		text.setText(eventText);
		textanimation();
		button1.setText("Fall to the ground, pretending to faint");
		button2.setText("ignore the pain and tackle the attacker");
		button3.setText("Scream of pain and ask the attackers why he did that?");
		button4.setText("Stand completely still and pretend that the device did not work");
	}

}
