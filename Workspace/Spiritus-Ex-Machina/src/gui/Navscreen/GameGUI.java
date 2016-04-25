package gui.Navscreen;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import game.Controller;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
import character.Player;

public class GameGUI {

	private boolean showinv;
	private boolean showattr;
	private Button buttonattr;
	private GridPane gridInventory;
	private GridPane gridAttribute;
	private VBox left;
	private VBox right;
	private BorderPane pane;
	private Stage window;
	private Scene scene;
	
	private Label labelarmor;
	private ImageView ivarmor;
	private String attributesArmor;
	private Image imageArmor;
	
	private Label labelgun;
	private ImageView ivgun;
	private String attributesGun;
	private Image imageGun;
	
	private Label labelstim;
	private ImageView ivstim;
	private String attributesStim;
	private Image imageStim;
	
	private Label labelmelee;
	private ImageView ivmelee;
	private String attributesMelee;
	private Image imageMelee;
	
	
	private Label labelint;
	private ImageView ivint;
	private int inte;
	private String attributesInt;
	private Image imageInt;

	private Label labelstr;
	private ImageView ivstr;
	private int str;
	private String attributesStr;
	private Image imageStr;

	private Label labelpre;
	private ImageView ivpre;
	private int pre;
	private String attributesPre;
	private Image imagePre;

	private Label labelwit;
	private ImageView ivwit;
	private int wit;
	private String attributesWit;
	private Image imageWit;

	private Label labeldex;
	private ImageView ivdex;
	private int dex;
	private String attributesDex;
	private Image imageDex;

	private Label labelmani;
	private ImageView ivmani;
	private int mani;
	private String attributesMani;
	private Image imageMani;

	private Label labelres;
	private ImageView ivres;
	private int res;
	private String attributesRes;
	private Image imageRes;

	private Label labelsta;
	private ImageView ivsta;
	private int sta;
	private String attributesSta;
	private Image imageSta;

	private Label labelcomp;
	private ImageView ivcomp;
	private int comp;
	private String attributesComp;
	private Image imageComp;

	
	private Text Evtext;
	private Text statusText;
	private Animation animation;

	private Button buttoninv;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private String eventText;

	private double width;
	private ImageView iv1;
	private Image image;

	private Rectangle2D bounds;
	private double widthScreen;
	private double heightScreen;
	private String altOne;
	private String altTwo;
	private String altThree;
	private String altFour;
	private Controller controller;

	public GameGUI(Controller controller) {
		this.controller = controller;
		window = new Stage();
	

		bounds = Screen.getPrimary().getVisualBounds();
		widthScreen = bounds.getWidth();
		heightScreen = bounds.getHeight();
		pane = new BorderPane();

		if (widthScreen < 1600) {
			width = 600;
		} else
			width = 1200;

		addImage();
		addtext();
		addbutton();
		
		addHealth();
		addinventory();
		addAttributeWindow();
		addInventoryWindow();

		left = new VBox();
		left.getChildren().addAll(gridAttribute);
		left.setAlignment(Pos.CENTER);
		left.setVisible(false);

		right = new VBox();
		right.getChildren().addAll(gridInventory);
		right.setAlignment(Pos.CENTER);
		right.setVisible(false);

		VBox center = new VBox();
		center.getChildren().addAll(iv1, Evtext, button1, button2, button3, button4, buttoninv, buttonattr);
		center.setAlignment(Pos.CENTER);

		pane.setCenter(center);
		pane.setLeft(left);
		pane.setRight(right);

		scene = new Scene(pane, widthScreen, heightScreen);
		scene.getStylesheets().add("StyleSheet.css");

		buttonHandler();

		if (widthScreen < 1600) {
			button1.setStyle("-fx-font: 10 arial");
			button2.setStyle("-fx-font: 10 arial");
			button3.setStyle("-fx-font: 10 arial");
			button4.setStyle("-fx-font: 10 arial");
			buttoninv.setStyle("-fx-font: 10 arial");
			buttonattr.setStyle("-fx-font: 10 arial");
			Evtext.setFont(new Font(10));

			iv1.setFitHeight(200);
		}
		window.setResizable(false);
		window.setScene(scene);
		window.setFullScreen(true);
		window.show();
	}

	public void textanimation() {
		animation = new Transition() {
			{

				setCycleDuration(Duration.millis(2000));
			}

			protected void interpolate(double frac) {
				final int length = eventText.length();
				final int n = Math.round(length * (float) frac);
				Evtext.setText(eventText.substring(0, n));
			}

		};
		animation.play();
	}

	public void addAttributeWindow() {
		
		buttonattr = new Button("Attributes");
		buttonattr.setMaxWidth(200);
		
		inte = controller.getPlayer().getIntelligence();
		str = controller.getPlayer().getStrength();
		pre = controller.getPlayer().getPresence();
		wit = controller.getPlayer().getWits();
		dex = controller.getPlayer().getDexterity();
		mani = controller.getPlayer().getManipulation();
		res = controller.getPlayer().getResolve();
		sta = controller.getPlayer().getStamina();
		comp = controller.getPlayer().getComposure();
		
		gridAttribute = new GridPane();
		gridAttribute.prefHeight(700);
		gridAttribute.prefWidth(300);
		gridAttribute.setHgap(0);
		gridAttribute.setVgap(0);
		gridAttribute.setPadding(new Insets(0, 10, 0, 10));

		// Intelligence
		imageInt = new Image("int.png");
		ivint = new ImageView();
		ivint.setImage(imageInt);
		ivint.setFitWidth(50);
		ivint.setFitHeight(50);
		attributesInt = "Intelligence: " + inte;
		labelint = new Label(attributesInt, ivint);
		labelint.setMinWidth(300);

		// Strength
		imageStr = new Image("str.png");
		ivstr = new ImageView();
		ivstr.setImage(imageStr);
		ivstr.setFitWidth(50);
		ivstr.setFitHeight(50);
		attributesStr = "Strength: " + str;
		labelstr = new Label(attributesStr, ivstr);
		labelstr.setMinWidth(300);

		// Presence
		imagePre = new Image("pre.png");
		ivpre = new ImageView();
		ivpre.setImage(imagePre);
		ivpre.setFitWidth(50);
		ivpre.setFitHeight(50);
		attributesPre = "Presence: " + pre;
		labelpre = new Label(attributesPre, ivpre);
		labelpre.setMinWidth(300);

		// Wits
		imageWit = new Image("wit.png");
		ivwit = new ImageView();
		ivwit.setImage(imageWit);
		ivwit.setFitWidth(50);
		ivwit.setFitHeight(50);
		attributesWit = "Wits: " + wit;
		labelwit = new Label(attributesWit, ivwit);
		labelwit.setMinWidth(300);

		// Dexterity
		imageDex = new Image("dex.png");
		ivdex = new ImageView();
		ivdex.setImage(imageDex);
		ivdex.setFitWidth(50);
		ivdex.setFitHeight(50);
		attributesDex = "Dexterity: " + dex;
		labeldex = new Label(attributesDex, ivdex);
		labeldex.setMinWidth(300);

		// Manipulation
		imageMani = new Image("mani.png");
		ivmani = new ImageView();
		ivmani.setImage(imageMani);
		ivmani.setFitWidth(50);
		ivmani.setFitHeight(50);
		attributesMani = "Manipulation: " + mani;
		labelmani = new Label(attributesMani, ivmani);
		labelmani.setMinWidth(300);

		// Resolve
		imageRes = new Image("res.png");
		ivres = new ImageView();
		ivres.setImage(imageRes);
		ivres.setFitWidth(50);
		ivres.setFitHeight(50);
		attributesRes = "Resolve: " + res;
		labelres = new Label(attributesRes, ivres);
		labelres.setMinWidth(300);

		/// Stamina
		imageSta = new Image("sta.png");
		ivsta = new ImageView();
		ivsta.setImage(imageSta);
		ivsta.setFitWidth(50);
		ivsta.setFitHeight(50);
		attributesSta = "Stamina: " + sta;
		labelsta = new Label(attributesSta, ivsta);
		labelsta.setMinWidth(300);
		// // Composure
		imageComp = new Image("comp.png");
		ivcomp = new ImageView();
		ivcomp.setImage(imageComp);
		ivcomp.setFitWidth(50);
		ivcomp.setFitHeight(50);
		attributesComp = "composure: " + comp;
		labelcomp = new Label(attributesComp, ivcomp);
		labelcomp.setMinWidth(300);

		// "Composure: " + comp

		gridAttribute.add(labelstr, 1, 0);
		gridAttribute.add(labelint, 1, 1);
		gridAttribute.add(labelpre, 1, 2);
		gridAttribute.add(labelwit, 1, 3);
		gridAttribute.add(labeldex, 1, 4);
		gridAttribute.add(labelmani, 1, 5);
		gridAttribute.add(labelres, 1, 6);
		gridAttribute.add(labelsta, 1, 7);
		gridAttribute.add(labelcomp, 1, 8);
		gridAttribute.add(statusText, 1, 9);
	}

	public void addInventoryWindow() {
		gridInventory = new GridPane();
		gridInventory.prefHeight(700);
		gridInventory.prefWidth(300);
		gridInventory.setHgap(0);
		gridInventory.setVgap(0);
		gridInventory.setPadding(new Insets(0, 10, 0, 10));
		
		imageArmor = new Image("armor.png");
		ivarmor = new ImageView();
		ivarmor.setImage(imageArmor);
		ivarmor.setFitWidth(50);
		ivarmor.setFitHeight(50);
		attributesArmor = "Aegis Heavy Body Armor" ;
		labelarmor = new Label(attributesArmor, ivarmor);
		labelarmor.setMinWidth(300);
		
		imageGun = new Image("gun.png");
		ivgun = new ImageView();
		ivgun.setImage(imageGun);
		ivgun.setFitWidth(50);
		ivgun.setFitHeight(50);
		attributesGun = "M-5 Phalanx " ;
		labelgun = new Label(attributesGun, ivgun);
		labelgun.setMinWidth(300);
		
		imageStim = new Image("stim.png");
		ivstim = new ImageView();
		ivstim.setImage(imageStim);
		ivstim.setFitWidth(50);
		ivstim.setFitHeight(50);
		attributesStim = "Bio-gel: " + "x2";
		labelstim = new Label(attributesStim, ivstim);
		labelstim.setMinWidth(300);
		
		imageMelee = new Image("melee.png");
		ivmelee = new ImageView();
		ivmelee.setImage(imageMelee);
		ivmelee.setFitWidth(50);
		ivmelee.setFitHeight(50);
		attributesMelee = "Titanium knife: ";
		labelmelee = new Label(attributesMelee, ivmelee);
		labelmelee.setMinWidth(300);
		
		gridInventory.add(labelarmor, 1, 0);
		gridInventory.add(labelgun, 1, 1);
		gridInventory.add(labelstim, 1, 2);
		gridInventory.add(labelmelee, 1, 3);
	}

	public void addbutton() {
		// Knappar

		button1 = new Button("");
		button1.setMaxWidth(width);

		button2 = new Button("");
		button2.setMaxWidth(width);

		button3 = new Button("");
		button3.setMaxWidth(width);

		button4 = new Button("");
		button4.setMaxWidth(width);
	}

	public void addtext() {

		Evtext = new Text();
		Evtext.setWrappingWidth(width);
		Evtext.setFont(new Font(20));

		Evtext.setTextAlignment(TextAlignment.JUSTIFY);
		// Evtext.setText(eventText);
		Evtext.setFill(Color.WHITE);

	}

	public void addImage() {
		image = new Image("JWET8.jpg");
		iv1 = new ImageView();
		iv1.setImage(image);
		iv1.setFitWidth(width);

	}

	public void addinventory() {
		buttoninv = new Button("Inventory");
		buttoninv.setMaxHeight(600);
		buttoninv.setMaxWidth(200);
	}



	public void addHealth() {

		statusText = new Text();
		statusText.setFont(new Font(40));
		statusText.setTextAlignment(TextAlignment.CENTER);
		statusText.setFill(Color.GREEN);
		statusText.setWrappingWidth(300);
		statusText.setText(
				"Healthpoints: " + controller.getPlayer().getHealth() + "/" + controller.getPlayer().getMaxhealth());
	}

	public void changeHealth() {
		statusText.setText(
				"Healthpoints: " + controller.getPlayer().getHealth() + "/" + controller.getPlayer().getMaxhealth());

		if ((float)0.66 >=(float) controller.getPlayer().getHealth()/(float)controller.getPlayer().getMaxhealth()) {
			statusText.setFill(Color.ORANGE);
		} 
		if ((float)0.33 >= (float)controller.getPlayer().getHealth()/(float)controller.getPlayer().getMaxhealth()) {
			statusText.setFill(Color.RED);
		}

	}

	public void init() {
		controller.navigation("init");

	}

	public void setAttributes() {
		inte = controller.getPlayer().getIntelligence();
		str = controller.getPlayer().getStrength();
		pre = controller.getPlayer().getPresence();
		wit = controller.getPlayer().getWits();
		dex = controller.getPlayer().getDexterity();
		mani = controller.getPlayer().getManipulation();
		res = controller.getPlayer().getResolve();
		sta = controller.getPlayer().getStamina();
		comp = controller.getPlayer().getComposure();
		
		attributesInt = "Intelligence: " + inte;
		labelint.setText(attributesInt);
		
		attributesStr = "Strength: " + str;
		labelstr.setText(attributesStr);
		
		attributesPre = "Presence: " + pre;
		labelpre.setText(attributesPre);
		
		attributesWit = "Wits: " + wit;
		labelwit.setText(attributesWit);
		
		attributesDex = "Dexterity: " + dex;
		labeldex.setText(attributesDex);
		
		attributesMani = "Manipulation: " + mani;
		labelmani.setText(attributesMani);
		
		attributesRes = "Resolve: " + res;
		labelres.setText(attributesRes);
		
		attributesSta = "Stamina: " + sta;
		labelsta.setText(attributesMani);
		
		attributesComp = "composure: " + comp;
		labelcomp.setText(attributesComp);
	}

	public void setEventText(String txt) {
		this.eventText = txt;
		Evtext.setText(eventText);
		textanimation();
	}

	public void setDialog(String dialog, int n, String navKey) {
		if (dialog != null)
			switch (n) {
			case 1:
				button1.setDisable(false);
				button1.setText(dialog);
				altOne = navKey;
				break;
			case 3:
				button2.setDisable(false);
				button2.setText(dialog);
				altTwo = navKey;
				break;
			case 5:
				button3.setDisable(false);
				button3.setText(dialog);
				altThree = navKey;
				break;
			case 7:
				button4.setDisable(false);
				button4.setText(dialog);
				altFour = navKey;
				break;
			}
	}

	public void disableButtons() {
		button1.setText("");
		button2.setText("");
		button3.setText("");
		button4.setText("");
		button1.setDisable(true);
		button2.setDisable(true);
		button3.setDisable(true);
		button4.setDisable(true);
	}

	public void setImage(String img) {
		image = new Image(img);
		iv1.setImage(image);
	}

	public void buttonHandler() {

		button1.setOnAction(e -> {
			if (controller.getActiveCombat() == null)
				controller.navigation(altOne);
			else {
				controller.getActiveCombat().performCharacterAction(altOne);
			}
		});

		button2.setOnAction(e -> {
			if (controller.getActiveCombat() == null)
				controller.navigation(altTwo);
			else {
				controller.getActiveCombat().performCharacterAction(altTwo);
			}
		});

		button3.setOnAction(e -> {
			if (controller.getActiveCombat() == null)
				controller.navigation(altThree);
			else {
				controller.getActiveCombat().performCharacterAction(altThree);
			}
		});

		button4.setOnAction(e -> {
			if (controller.getActiveCombat() == null)
				controller.navigation(altFour);
			else {
				controller.getActiveCombat().performCharacterAction(altFour);
			}
		});

		buttonattr.setOnAction(e -> {
			if (showattr == false) {
				showattr = true;
				left.setVisible(showattr);
				setAttributes();
			} else if (showattr == true) {
				showattr = false;
				left.setVisible(showattr);
				setAttributes();
			}
		});

		buttoninv.setOnAction(e -> {
			if (showinv == false) {
				showinv = true;
				right.setVisible(showinv);
			} else if (showinv == true) {
				showinv = false;
				right.setVisible(showinv);
			}
		});
	}
}
