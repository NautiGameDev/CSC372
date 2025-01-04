package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;



public class Main extends Application 
{
	Scene scene;
	GridPane gridPane;
	TextArea textBox;
	MenuButton menuButton;
	MenuItem menuGetDateTime;
	MenuItem menuSaveDateTime;
	MenuItem menuChangeColor;
	MenuItem menuCloseProgram;
	String color;
		
	
	@Override
	public void start(Stage appStage)
	{
		gridPane = new GridPane();
		scene = new Scene(gridPane, 400, 200);
		
		setMenu();
		setTextBox();
		setGridPane();
		setRandomColor();
	
		appStage.setScene(scene);
		appStage.setTitle("Module 3 Option 1 Assignment");
		appStage.show();
	}
	
	private void setMenu()
	{
		//Init menu button and items
		menuGetDateTime = new MenuItem("Show Date/Time");
		menuSaveDateTime = new MenuItem("Save Date/Time");
		menuChangeColor = new MenuItem("Change Color");
		menuCloseProgram = new MenuItem("Close Program");
		menuButton = new MenuButton("Menu", null, menuGetDateTime, menuSaveDateTime, menuChangeColor, menuCloseProgram);
		
		//Set-up menu actions
		menuGetDateTime.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					ShowDateTime();
				}
			}
		);
		
		menuSaveDateTime.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					SaveDateTime();
				}
			}
		);
		
		menuChangeColor.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					ChangeColor();
				}
			}
		);
		
		menuCloseProgram.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					CloseProgram();
				}
			}	
		);
	}
	
	private void setTextBox()
	{
		textBox = new TextArea();
		textBox.setEditable(false);
		textBox.setPrefColumnCount(35);
		textBox.setPrefHeight(150);
	}
	
	private void setGridPane()
	{
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.setVgap(10);
		gridPane.add(menuButton, 0, 0);
		gridPane.add(textBox, 0, 1);
	}
	
	private void setRandomColor()
	{
		String[] colors = {"#b3ffb3", "#00e600", "#009900", "#004d00"};
		Random random = new Random();
		int randomNumber = random.nextInt(colors.length);
		color = colors[randomNumber];
	}
	
	private void ShowDateTime()
	{
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		String[] currentDateTime = dateTimeFormatter.format(localDateTime).split(" ");
		
		textBox.setText("Date: " + currentDateTime[0] + "\n" +
				"Time: " + currentDateTime[1]);
	}
	
	private void SaveDateTime()
	{
		try
		{
			File myFile = new File("localDateTime.txt");
			myFile.createNewFile();
			
			FileWriter fileWriter = new FileWriter("localDateTime.txt");
			fileWriter.write(textBox.getText());
			fileWriter.close();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("File localDateTime.txt has been saved successfully.");
			alert.show();
			
		}
		catch (Exception exception)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Error creating file \n" + exception);
			alert.show();
		}
	}
	
	private void ChangeColor()
	{	
		gridPane.setStyle("-fx-background-color: " + color);
	}
	
	private void CloseProgram()
	{
		Platform.exit();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
