package of6.lf;

import java.util.ArrayList;

public class Game {
	
	private int height;
	private int width;
	private Tile[][] board;
    private ArrayList<Tile> snake;
    private boolean isGameWon = false;
    private boolean isGameOver = false;
	
    // Oppgave 1 a)
	public Game(int width, int height) {
		this.height = height;
		this.width = width;

		this.board = new Tile[height][width];
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				board[y][x] = new Tile(x, y);
			}
		}
	}
	
    // Oppgave 1 b)
	public boolean isTile(int x, int y) {
		return x >= 0 && y >= 0 && x < getWidth() && y < getHeight();
	}

    // Oppgave 1 c)
	public Tile getTile(int x, int y) {
		if (!isTile(x, y)) {
			throw new IllegalArgumentException("Coordinates out of bounds");
		}
		return this.board[y][x];
	}

	public int getHeight() {
		return height;
	}


	public int getWidth() {
		return width;
	}
	
	// Oppgave 3 a)
	public void addSnakeToTiles(Tile snakeHead, Tile snakeBody) {
		if (snake != null) {
            throw new IllegalStateException("Snake already created");
        }
		
		snake = new ArrayList<Tile>();
		
		snakeHead.setSnake();
		snakeBody.setSnake();
		snake.add(snakeHead);
		snake.add(snakeBody);
	}

    public void moveUp() {
        move(0, -1);
	    System.out.println(this);
    }

    public void moveDown() {
        move(0, 1);
	    System.out.println(this);
    }

    public void moveLeft() {
        move(-1, 0);
	    System.out.println(this);
    }

    public void moveRight() {
        move(1, 0);
	    System.out.println(this);
    }

	
	// Oppgave 4 a)
	private boolean canMoveTo(int dx, int dy) {
		
		// Snake head coordinates
		int targetX = snake.get(0).getX() + dx;
		int targetY = snake.get(0).getY() + dy;
		
		if(!isTile(targetX, targetY)) {
			return false;
		}
		
		Tile targetTile = getTile(targetX, targetY);
		boolean tileIsSnakeTail = (targetTile == snake.get(snake.size()-1));
		
		return !targetTile.hasCollision() || tileIsSnakeTail;
	}

	// Oppgave 4 b)
	private void move(int dx, int dy) {
		if(snake == null || isGameWon || isGameOver) {
    		throw new IllegalStateException("Not a valid game state for move");
		}
		if(!canMoveTo(dx, dy)) {
			throw new IllegalArgumentException("Not a valid move");
		}

		int targetX = snake.get(0).getX() + dx;
		int targetY = snake.get(0).getY() + dy;
		Tile targetTile = getTile(targetX, targetY);

		
		// Oppgave 5 b)
        if (targetTile.isGoal()) {
            isGameWon = true;
        }
		

		// Oppgave 5 a)
        if (!targetTile.isFruit()) {
        	snake.get(snake.size()-1).setAir();
        	snake.remove(snake.size()-1);
        }
		
		snake.add(0, targetTile);
		targetTile.setSnake();
		

        if (isGameWon) {
            return;
        }

        while (snakeInAir()) {
            isGameOver = false;
            for (Tile tile : snake) {
                if (!isTile(tile.getX(), tile.getY() + 1)) {
                    isGameOver = true;
                }
            }
            if (isGameOver) {
                break;
            }

            for (Tile tile : snake) {
                tile.setAir();
            }

            ArrayList<Tile> newSnake = new ArrayList<>();
            for (Tile tile : snake) {
                Tile newTile = getTile(tile.getX(), tile.getY() + 1);
                newTile.setSnake();
                newSnake.add(newTile);
            }
            snake = newSnake;
        }
	}
	
    private boolean snakeInAir() {
        for (Tile tile : snake) {
            if (isTile(tile.getX(), tile.getY() + 1) && getTile(tile.getX(), tile.getY() + 1).isGround()) {
                return false;
            }
        }
        return true;
    }
    
    
    
    // Ekstra metoder lagt til i ØF 6 (i videoene som kom ut i etterkant):
    public boolean isSnakeHead(Tile tile) {
    	return tile == snake.get(0);
    }
    
    public boolean isGameWon() {
		return isGameWon;
	}
    
    public boolean isGameOver() {
		return isGameOver;
    }
	
	
    // Oppgave 2
	@Override
	public String toString() {
		String boardString = "";
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (getTile(x, y) == snake.get(0)) {
					boardString += "e";
				} else {
					boardString += getTile(x, y);
				}
			}
			boardString += "\n";
		}
		// Oppgave 5b
		if (isGameWon) {
			boardString += "\n\nGame won!";
		} else if (isGameOver) {
			boardString = "\n\nYou Lost!";
        }
		return boardString;
	}
	
	public static void main(String[] args) {
	    Game game = new Game(16, 12);
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

	    game.addSnakeToTiles(game.getTile(8, 5), game.getTile(9, 5));
	    System.out.println(game);
	    game.moveLeft();
	    game.moveLeft();
	    
	}

}
