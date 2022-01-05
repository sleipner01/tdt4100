package of6.lf;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GameController {

	// Oppgave 3
	private Game game;
	
	@FXML
	Pane board;

	// Oppgave 11 (ekstra)
	@FXML Text winText = new Text();
	@FXML Text loseText = new Text();
	
	// Oppgave 3
	@FXML
	public void initialize() {
		setInitialGameState();
		createBoard();
		drawBoard();
	
	}

	// Oppgave 11 (ekstra)
	private void setInitialGameState() {
		game = new Game(16, 12);
		game.getTile(6, 11).setGround();
		game.getTile(7, 11).setGround();
		game.getTile(8, 11).setGround();
		game.getTile(6, 10).setGround();
		game.getTile(7, 10).setGround();
		game.getTile(8, 10).setGround();
		game.getTile(9, 10).setGround();
		game.getTile(6, 9).setGround();
		game.getTile(7, 9).setGround();
		game.getTile(8, 9).setGround();
		game.getTile(9, 9).setGround();
		game.getTile(6, 8).setGround();
		game.getTile(8, 6).setGround();
		game.getTile(10, 6).setGround();
		game.getTile(5, 5).setGround();
		game.getTile(5, 6).setFruit();
		game.getTile(9, 6).setFruit();
		game.getTile(8, 3).setGoal();

		game.addSnakeToTiles(game.getTile(9, 8), game.getTile(8, 8));
		
	}
	
	// Oppgave 4
	private void createBoard() {
		board.getChildren().clear();
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				Pane tile = new Pane();
				tile.setTranslateX(x*30);
				tile.setTranslateY(y*30);
				tile.setPrefWidth(30);
				tile.setPrefHeight(30);
				tile.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
				board.getChildren().add(tile);
			}
		}
	}
	
	// Oppgave 6
	private void drawBoard() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				board.getChildren().get(y*game.getWidth() + x).setStyle("-fx-background-color: " + getTilecolor(game.getTile(x, y)) + ";");
			}
		}
		
		// Oppgave 10
		if(game.isGameWon()) {
			winText.setText("Du vant!");
			winText.setStyle("-fx-font-size: 40px");
			winText.setFill(Color.GREEN);
			winText.setTranslateX(160.0);
			winText.setTranslateY(200.0);
			board.getChildren().add(winText);
		} else if(game.isGameOver()) {
			loseText.setText("Game Over");
			loseText.setStyle("-fx-font-size: 40px");
			loseText.setFill(Color.RED);
			loseText.setTranslateX(160.0);
			loseText.setTranslateY(200.0);
			board.getChildren().add(loseText);
		}
	}
	
	// Oppgave 8
	@FXML
	public void handleUp() {
		game.moveUp();
		drawBoard();
	}

	@FXML
	public void handleDown() {
		game.moveDown();
		drawBoard();
	}

	@FXML
	public void handleLeft() {
		game.moveLeft();
		drawBoard();
	}
	
	@FXML
	public void handleRight() {
		game.moveRight();
		drawBoard();
	}

	@FXML
	public void handleReset() {
		if (board.getChildren().contains(loseText)) {
			board.getChildren().remove(loseText);
		}
		if (board.getChildren().contains(winText)) {
			board.getChildren().remove(winText);
		}
		setInitialGameState();
		drawBoard();
	}
	
	// Oppgave 5
    private String getTilecolor(Tile tile) {
    	if (game.isSnakeHead(tile)) { 
    		// Oppgave 7
    		return "#1db121";
    	} else if(tile.isSnake()) {
    		return "#24d628";
    	} else if(tile.isGround()) {
    		return "#a26f42";
    	} else if(tile.isFruit()) {
    		return "#e5303a";
    	} else if(tile.isGoal()) {
    		return "#f6ec5a";
    	} else {
    		return "#7bcaf2";
    	}
    }
}
