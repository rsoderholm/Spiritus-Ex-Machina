package gui.Navscreen;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Rectangle2D;
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

public class JavaFxTest  {

	VBox layout1;
	VBox layout2;
	Stage window;
	Scene scene;

	String dialogText1;
	String dialogText2;
	String dialogText3;
	String dialogText4;

	Text text;
	Animation animation;

	Button button1;
	Button button2;
	Button button3;
	Button button4;
	String eventText;
	Rectangle2D bounds;
	double width = Double.MAX_VALUE;
	double height = Double.MAX_VALUE;
	ImageView iv1;
	Image image;



	public JavaFxTest() {
		window = new Stage();
		layout1 = new VBox();
		scene = new Scene(layout1);
		scene.getStylesheets().add("StyleSheet.css");
		
		

		addImage();
		addtext();
		addbutton();
		layout1.getChildren().addAll(iv1, text, button1, button2, button3, button4);

		
		window.setResizable(false);
		window.setScene(scene);
		window.setHeight(900);
		window.setWidth(1200);
		window.show();
	}

	public void addbutton() {
		// Knappar
		button1 = new Button(dialogText1);
		button1.setOnAction(e -> textanimation());
		button1.setMaxWidth(width);

		button2 = new Button(dialogText2);
		button2.setOnAction(e -> text.setText("tempus convallis nibh, nec pharetra quam congue et"));
		button2.setMaxWidth(width);

		button3 = new Button(dialogText3);
		button3.setOnAction(e -> text.setText("Nulla a tellus dolor."));
		button3.setMaxWidth(width);

		button4 = new Button(dialogText4);
		button4.setOnAction(e -> text.setText("nec elementum risus, finibus elementum tortor"));
		button4.setMaxWidth(width);
	}

	public void addtext() {
		eventText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Vestibulum sed sem eget mauris semper sollicitudin eget ut lacus. "
				+ "Nulla tempus convallis nibh, nec pharetra quam congue et. Nulla a tellus dolor. D"
				+ "onec euismod ornare erat, at finibus lacus lobortis sed. "
				+ "Donec nec elementum risus, finibus elementum tortor. ";

		text = new Text();

		text.setWrappingWidth(1200);
		text.setFont(new Font(20));

		text.setTextAlignment(TextAlignment.JUSTIFY);
		text.setText(eventText);
		text.setFill(Color.WHITE);

		textanimation();
	}

	public void addImage() {
		image = new Image("1200x300.png");
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
			dialog = dialogText1;
		}
		if (n == 2) {
			dialog = dialogText2;
		}
		if (n == 3) {
			dialog = dialogText3;
		}
		if (n == 4) {
			dialog = dialogText4;
			
		}
	}
}
