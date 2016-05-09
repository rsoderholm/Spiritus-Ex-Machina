/*
 * AttributeGUI
 * 
 * Version information
 *
 * 03/05/2016
 * 
 * Hassan Alhasani
 */
package gui.Navscreen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * This comment should contain any class-wide or interface-wide information.
 * 
 */
public class AttributeGUI1 extends Application {
	private HBox bottomPane;
	private HBox topPane;
	private VBox leftMenu;
	private VBox centerMenu;
	private VBox rightMenu;
	private BorderPane borderPane;

	private Stage window;
	private Scene scene;

	
	private Text head;
	private String 
	valueRemaining, 
	value1, 
	value2, 
	value3, 
	value4, 
	value5, 
	value6, 
	value7, 
	value8, 
	value9;

	private int 
	valuesRemaining, 
	values1, 
	values2, 
	values3, 
	values4, 
	values5, 
	values6, 
	values7, 
	values8, 
	values9;

	private Label 
	lblIntValue, 
	lblStrValue, 
	lblPreValue, 
	lblWtsValue, 
	lblDexValue, 
	lblManValue, 
	lblResValue,
	lblStaValue, 
	lblCmpValue,
	lblPower,
	lblFinesse, 
	lblResistance;
	
	private Label  
	label2, 
	label3, 
	label4, 
	label5, 
	label6, 
	label7, 
	label8, 
	label9, 
	label11;
	
	private	Button 
	btnIntPlus, btnIntMinus, 
	btnStrPlus, btnStrMinus, 
	btnPrePlus, btnPreMinus, 
	btnWtsPlus, btnWtsMinus,
	btnDexPlus, btnDexMinus, 
	btnManPlus, btnManMinus, 
	btnResPlus, btnResMinus, 
	btnStaPlus, btnStaMinus,
	btnComPlus, btnComMinus, 
	done;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		initValues();
		topPane();
		leftPane();
		centerPane();
		rightPane();
		bottomPane();
		mainLayotBorderPane();

		scene = new Scene(borderPane);
		scene.getStylesheets().add("StyleSheet2.css");
		window.setScene(scene);
		window.setTitle("Deus ex Machina");
		window.setFullScreen(true);
		window.show();
	}

	/**
	 * 
	 * @param choose
	 */
	public void setPosValue(int choose) {

		switch (choose) {
		case 1:
			values1++;
			value1 = "" + values1;
			lblIntValue.setText(value1);
			break;
		case 2:
			values2++;
			value2 = "" + values2;
			lblStrValue.setText(value2);
			break;
		case 3:
			values3++;
			value3 = "" + values3;
			lblPreValue.setText(value3);
			break;
		case 4:
			values4++;
			value4 = "" + values4;
			lblWtsValue.setText(value4);
			break;
		case 5:
			values5++;
			value5 = "" + values5;
			lblDexValue.setText(value5);
			break;
		case 6:
			values6++;
			value6 = "" + values6;
			lblManValue.setText(value6);
			break;
		case 7:
			values7++;
			value7 = "" + values7;
			lblResValue.setText(value7);
			break;
		case 8:
			values8++;
			value8 = "" + values8;
			lblStaValue.setText(value8);
			break;
		case 9:
			values9++;
			value9 = "" + values9;
			lblCmpValue.setText(value9);
			break;
		case 10:
			valuesRemaining++;
			valueRemaining = "" + valuesRemaining;
			head.setText("Attributes remaining: " + valueRemaining);
			break;
		}
	}

	/**
	 * 
	 * @param choose
	 */
	public void setNegValue(int choose) {

		switch (choose) {
		case 1:
			values1--;
			value1 = "" + values1;
			lblIntValue.setText(value1);
			break;
		case 2:
			values2--;
			value2 = "" + values2;
			lblStrValue.setText(value2);
			break;
		case 3:
			values3--;
			value3 = "" + values3;
			lblPreValue.setText(value3);
			break;
		case 4:
			values4--;
			value4 = "" + values4;
			lblWtsValue.setText(value4);
			break;
		case 5:
			values5--;
			value5 = "" + values5;
			lblDexValue.setText(value5);
			break;
		case 6:
			values6--;
			value6 = "" + values6;
			lblManValue.setText(value6);
			break;
		case 7:
			values7--;
			value7 = "" + values7;
			lblResValue.setText(value7);
			break;
		case 8:
			values8--;
			value8 = "" + values8;
			lblStaValue.setText(value8);
			break;
		case 9:
			values9--;
			value9 = "" + values9;
			lblCmpValue.setText(value9);
			break;
		case 10:
			valuesRemaining--;
			valueRemaining = "" + valuesRemaining;
			head.setText("Attributes remaining: " + valueRemaining);
			break;
		}
	}

	/**
	 * Sets all BordePanes
	 */
	public void mainLayotBorderPane() {
		borderPane = new BorderPane();
		borderPane.setTop(topPane);
		borderPane.setCenter(centerMenu);
		borderPane.setLeft(leftMenu);
		borderPane.setRight(rightMenu);
		borderPane.setBottom(bottomPane);
	}

	/**
	 * Initates values
	 */
	public void initValues() {
		valuesRemaining = 9;
		values1 = 1;
		values2 = 1;
		values3 = 1;
		values4 = 1;
		values5 = 1;
		values6 = 1;
		values7 = 1;
		values8 = 1;
		values9 = 1;

		valueRemaining = "" + valuesRemaining;
		value1 = "" + values1;
		value2 = "" + values2;
		value3 = "" + values3;
		value4 = "" + values4;
		value5 = "" + values5;
		value6 = "" + values6;
		value7 = "" + values7;
		value8 = "" + values8;
		value9 = "" + values9;

		lblIntValue = new Label(value1);
		lblStrValue = new Label(value2);
		lblPreValue = new Label(value3);
		lblWtsValue = new Label(value4);
		lblDexValue = new Label(value5);
		lblManValue = new Label(value6);
		lblResValue = new Label(value7);
		lblStaValue = new Label(value8);
		lblCmpValue = new Label(value9);
	}

	/**
	 * Top pane - "Attributes remaining"
	 */
	public void topPane() {
		// Top pane - "Attributes remaining"
		topPane = new HBox();
		head = new Text();

		head.setFont(new Font(65));
		head.setFill(Color.WHITE);
		head.setText("Attributes remaining: " + valueRemaining);
		head.setTextAlignment(TextAlignment.JUSTIFY);
		topPane.getChildren().addAll(head);

		topPane.setAlignment(Pos.CENTER);

	}

	/**
	 * Left Pane - Power attributes
	 */
	public void leftPane() {
		leftMenu = new VBox(15);
		lblPower = new Label("Power attributes");

		// INT
		label2 = new Label("Intelligence (Int)");
		btnIntPlus = new Button("+");
		btnIntPlus.setOnAction(e -> {
			if ((valuesRemaining > 0) && (values1 < 5)) {
				setPosValue(1);
				setNegValue(10);
			}
		});
		btnIntMinus = new Button("-");
		btnIntMinus.setOnAction(e -> {
			if ((values1 > 1)) {
				setNegValue(1);
				setPosValue(10);
			}
		});

		// STR
		label3 = new Label("Strength (Str)");

		btnStrPlus = new Button("+");
		btnStrPlus.setOnAction(e -> {
			if ((valuesRemaining > 0) && (values2 < 5)) {
				setPosValue(2);
				setNegValue(10);
			}
		});
		btnStrMinus = new Button("-");
		btnStrMinus.setOnAction(e -> {
			if ((values2 > 1)) {
				setNegValue(2);
				setPosValue(10);
			}
		});

		// PRE
		label4 = new Label("Presence (Prs)");
		btnPrePlus = new Button("+");
		btnPrePlus.setOnAction(e -> {
			if ((valuesRemaining > 0) && (values3 < 5)) {
				setPosValue(3);
				setNegValue(10);
			}
		});
		btnPreMinus = new Button("-");
		btnPreMinus.setOnAction(e -> {
			if ((values3 > 1)) {
				setNegValue(3);
				setPosValue(10);
			}
		});

		leftMenu.getChildren().addAll(lblPower, label2, btnIntPlus, lblIntValue, btnIntMinus, label3, btnStrPlus,
				lblStrValue, btnStrMinus, label4, btnPrePlus, lblPreValue, btnPreMinus);
		leftMenu.setAlignment(Pos.CENTER);
	}

	/**
	 * Right pane - Resistance attributes
	 */
	public void rightPane() {
		rightMenu = new VBox(15);
		lblResistance = new Label("Resistance attributes");

		// RES
		label8 = new Label("Resolve (Res)");
		btnResPlus = new Button("+");
		btnResPlus.setOnAction(e -> {
			if ((valuesRemaining > 0) && (values7 < 5)) {
				setPosValue(7);
				setNegValue(10);
			}
		});
		btnResMinus = new Button("-");
		btnResMinus.setOnAction(e -> {
			if ((values7 > 1)) {
				setNegValue(7);
				setPosValue(10);
			}
		});

		// STA
		label9 = new Label("Stamina (Sta)");
		btnStaPlus = new Button("+");
		btnStaPlus.setOnAction(e -> {
			if ((valuesRemaining > 0) && (values8 < 5)) {
				setPosValue(8);
				setNegValue(10);
			}
		});
		btnStaMinus = new Button("-");
		btnStaMinus.setOnAction(e -> {
			if ((values8 > 1)) {
				setNegValue(8);
				setPosValue(10);
			}
		});

		// COM
		label11 = new Label("Composure (Cmp)");
		btnComPlus = new Button("+");
		btnComPlus.setOnAction(e -> {
			if ((valuesRemaining > 0) && (values9 < 5)) {
				setPosValue(9);
				setNegValue(10);
			}
		});
		btnComMinus = new Button("-");
		btnComMinus.setOnAction(e -> {
			if ((values9 > 1)) {
				setNegValue(9);
				setPosValue(10);
			}
		});

		rightMenu.getChildren().addAll(lblResistance, label8, btnResPlus, lblResValue, btnResMinus, label9, btnStaPlus,
				lblStaValue, btnStaMinus, label11, btnComPlus, lblCmpValue, btnComMinus);
		rightMenu.setAlignment(Pos.CENTER);
	}

	/**
	 * Center pane - Finesse attributes
	 */
	public void centerPane() {
		centerMenu = new VBox(15);
		lblFinesse = new Label("Finesse attributes");

		// WTS
		label5 = new Label("Wits (Wts)");
		btnWtsPlus = new Button("+");
		btnWtsPlus.setOnAction(e -> {
			if ((valuesRemaining > 0) && (values4 < 5)) {
				setPosValue(4);
				setNegValue(10);
			}
		});
		btnWtsMinus = new Button("-");
		btnWtsMinus.setOnAction(e -> {
			if ((values4 > 1)) {
				setNegValue(4);
				setPosValue(10);
			}
		});

		// DEX
		label6 = new Label("Dexterity (Dex)");
		btnDexPlus = new Button("+");
		btnDexPlus.setOnAction(e -> {
			if ((valuesRemaining > 0) && (values5 < 5)) {
				setPosValue(5);
				setNegValue(10);
			}
		});
		btnDexMinus = new Button("-");
		btnDexMinus.setOnAction(e -> {
			if ((values5 > 1)) {
				setNegValue(5);
				setPosValue(10);
			}
		});

		// MAN
		label7 = new Label("Manipulation (Man)");
		btnManPlus = new Button("+");
		btnManPlus.setOnAction(e -> {
			if ((valuesRemaining > 0) && (values6 < 5)) {
				setPosValue(6);
				setNegValue(10);
			}
		});
		btnManMinus = new Button("-");
		btnManMinus.setOnAction(e -> {
			if ((values6 > 1)) {
				setNegValue(6);
				setPosValue(10);
			}
		});

		centerMenu.getChildren().addAll(lblFinesse, label5, btnWtsPlus, lblWtsValue, btnWtsMinus, label6, btnDexPlus,
				lblDexValue, btnDexMinus, label7, btnManPlus, lblManValue, btnManMinus);
		centerMenu.setAlignment(Pos.CENTER);
	}

	/**
	 * Bottom pane - "Done"-button
	 */
	public void bottomPane() {

		/*
		 * Done-knappen gör inget än. Inom paranteserna på
		 * "done.setOnAction();" skriver man in att den ska ta användaren
		 * tillbaka till huvudscenen.
		 * 
		 */
		bottomPane = new HBox();
		done = new Button("Done");
		// done.setOnAction(scene2 - Tillbaka till spelet);
		done.setPrefWidth(200);
		done.setOnAction(e -> {

		});
		bottomPane.getChildren().add(done);
		bottomPane.setAlignment(Pos.CENTER);
	}
}