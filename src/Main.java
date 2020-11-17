import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 700,700);
        ImageView tomat = new ImageView(new Image("tomat.png"));
        ImageView potat = new ImageView(new Image("potat.jpg"));
        Rectangle background = new Rectangle(200, 50);
        background.setFill(Color.WHEAT);
        Label title = new Label("Now showing TOMATO", background);
        pane.setTop(title);
        pane.setAlignment(title, Pos.CENTER);
        title.setContentDisplay(ContentDisplay.CENTER);
        Button change = new Button("Change pic");
        change.setOnMouseClicked(e -> {
            if (pane.getChildren().remove(tomat)) {
                title.setText("Now showing POTATO");
                pane.setCenter(potat);
            } else {
                title.setText("Now showing TOMATO");
                pane.getChildren().remove(potat);
                pane.setCenter(tomat);
            }
        });
        pane.setBottom(change);
        pane.setAlignment(change, Pos.CENTER);
        pane.setCenter(tomat);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Practice");
        primaryStage.show();
    }
}