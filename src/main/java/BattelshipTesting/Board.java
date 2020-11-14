package BattelshipTesting;

import interfaces.IManagerIO;
import interfaces.IPlayer;
import utils.Constants;

/**
 * Class that manages the game board
 * 
 * @author Cristian Vega
 *
 */
public class Board {

	IManagerIO managerIO;
	int numberBoats;
	int[][] board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

	/**
	 * Default Constructor
	 * 
	 * @param managerIO
	 */
	public Board(IManagerIO managerIO) {
		this.managerIO = managerIO;
		iniBoard();
	}

	/**
	 * Initialize the board with all the squares as water(0)
	 */
	public void iniBoard() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.board[i][j] = 0;
			}
		}
	}

	/**
	 * Display the board by console A to K horizontal and 1 to 10 vertical
	 */
	public void showBoard() {
		System.out.println("     _______________________________________");
		System.out.println("    | A | B | C | D | F | G | H | I | J | K |");
		for (int i = 0; i < 10; i++) {
			System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
			if ((i + 1) == 10) {
				System.out.print("| " + (i + 1) + "|");
			} else {
				System.out.print("| " + (i + 1) + " |");
			}
			for (int j = 0; j < 10; j++) {
				if (board[i][j] == 1) {
					System.out.print(" B |");
				} else if (board[i][j] == 0 || board[i][j] == 4) {
					System.out.print("   |");
				} else if (board[i][j] == 2) {
					System.out.print(" X |");
				} else if (board[i][j] == 3) {
					System.out.print(" # |");
				}

			}
			System.out.println();
		}
		System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
	}

	/**
	 * Inserts a size N ship at a user-provided position on the board
	 * 
	 * @param actualBoatSize
	 */
	public void insertPosition(int actualBoatSize) {

		boolean insertada = false;
		Position posicion = new Position();
		while (!insertada) {
			posicion = this.readPosition();
			posicion.setOrientation(readOrientation());
			posicion.setSize(actualBoatSize);
			insertada = isValidOrientation(posicion);

			if (!insertada) {
				System.out.println("La posicion " + posicion.toString() + "\nNo es correcta!\nIntroduce una de nuevo!");
			}
		}
		insertBoat(posicion);
		posicion.toString();

	}

	/**
	 * Insert a ship in a position on the board
	 * 
	 * @param position
	 */
	public void insertBoat(Position position) {
		for (int i = 0; i < position.getSize(); i++) {
			switch (position.getOrientation()) {
			case 0:// ARRIBA
				board[position.getX()][position.getY() + i] = 1;
				boatProtection(new Position(position.getX(), position.getY() + i));
				break;
			case 1:// DEECHA
				board[position.getX() + i][position.getY()] = 1;
				boatProtection(new Position(position.getX() + i, position.getY()));
				break;
			case 2:// ABAJO
				board[position.getX()][position.getY() - i] = 1;
				boatProtection(new Position(position.getX(), position.getY() - i));
				break;
			case 3:
				board[position.getX() - i][position.getY()] = 1;
				boatProtection(new Position(position.getX() - i, position.getY()));
				break;
			}
		}
	}

	/**
	 * It makes that around a ship there cannot be another ship fulfilling this way
	 * one of the rules of the game
	 * 
	 * @param pos
	 */
	public void boatProtection(Position pos) {

		if (pos.getX() + 1 < 10) {
			if (board[pos.getX() + 1][pos.getY()] == 0) {
				board[pos.getX() + 1][pos.getY()] = 4;	//RIGHT
			}
		}
		if (pos.getY() - 1 >= 0) {
			if (board[pos.getX()][pos.getY() - 1] == 0) {
				board[pos.getX()][pos.getY() - 1] = 4;	//BELOW
			}
		}
		if (pos.getX() - 1 >= 0) {
			if (board[pos.getX() - 1][pos.getY()] == 0) {
				board[pos.getX() - 1][pos.getY()] = 4;	//LEFT
			}
		}
		if (pos.getY() + 1 < 10) {
			if (board[pos.getX()][pos.getY() + 1] == 0) {
				board[pos.getX()][pos.getY() + 1] = 4;	//UP
			}
		}
		if (pos.getY() + 1 < 10 && pos.getX() + 1 < 10) {
			if (board[pos.getX() + 1][pos.getY() + 1] == 0) {
				board[pos.getX() + 1][pos.getY() + 1] = 4;	// RIGHT - UP
			}
		}
		if (pos.getY() + 1 < 10 && pos.getX() - 1 >= 0) {
			if (board[pos.getX() - 1][pos.getY() + 1] == 0) {
				board[pos.getX() - 1][pos.getY() + 1] = 4;// LEFT - UP
			}
		}
		if (pos.getY() - 1 >= 0 && pos.getX() - 1 >= 0) {
			if (board[pos.getX() - 1][pos.getY() - 1] == 0) {
				board[pos.getX() - 1][pos.getY() - 1] = 4;// LEFT - DOWN
			}
		}
		if (pos.getY() - 1 >= 0 && pos.getX() + 1 < 10) {
			if (board[pos.getX() + 1][pos.getY() - 1] == 0) {
				board[pos.getX() + 1][pos.getY() - 1] = 4;// RIGTH - DOWN
			}
		}

	}

	/**
	 * Check if a ship can be inserted in a certain orientation
	 * 
	 * @param posicion
	 * @return
	 */
	private boolean isValidOrientation(Position posicion) {
		boolean respuesta = false;
		int correcte = 0;
		for (int i = 0; i < posicion.getSize(); i++) {
			switch (posicion.getOrientation()) {
			case 0:// ARRIBA
				if (posicion.getY() + i < 10) {
					if (board[posicion.getX()][posicion.getY() + i] == 0) {
						correcte++;
					}
				}
				break;
			case 1:
				if (posicion.getX() + i < 10) {
					if (board[posicion.getX() + i][posicion.getY()] == 0) {
						correcte++;
					}
				}
				break;
			case 2:
				if (posicion.getY() - i >= 0) {
					if (board[posicion.getX()][posicion.getY() - i] == 0) {
						correcte++;
					}
				}
				break;
			case 3:
				if (posicion.getX() - i >= 0) {
					if (board[posicion.getX() - i][posicion.getY()] == 0) {
						correcte++;
					}
				}
				break;
			}
		}
		if (correcte == posicion.getSize()) {

			respuesta = true;

		}
		return respuesta;
	}

	/**
	 * Receive the orientation of the boat from the player
	 * 
	 * @return
	 */
	public int readOrientation() {

		int orientacion = -1;
		boolean aux = false;
		while (!aux) {
			System.out.println("Orientacion:");
			System.out.println(" 0-Derecha \n 1-Abajo \n 2- Arriba \n 3-Izquierda \n");
			int ori = managerIO.inInt();

			if (ori >= 0 && ori < 4) {
				orientacion = ori;
				aux = true;
			}
		}
		return orientacion;
	}

	/**
	 * Ask the player for a placement position
	 * 
	 * @return
	 */
	public Position readPosition() {

		boolean aux = false;
		Position lectura = new Position();
		while (!aux) {

			while (!aux) {
				System.out.println("Posicion X (1-10):");
				int x = managerIO.inInt();
				if (x > 0 && x < 11) {
					lectura.setX(x - 1);
					aux = true;
				}
			}
			aux = false;
			while (!aux) {
				System.out.println("Posicion Y (1-10):");
				int y = managerIO.inInt();
				if (y > 0 && y < 11) {
					lectura.setY(y - 1);
					aux = true;
				}
			}
		}
		return lectura;
	}

	/**
	 * Insert an N-size boat in a user-supplied dashboard position
	 * 
	 * @param tamañoBarcoActual
	 */
	public void insertPosicion(int tamañoBarcoActual) {
		boolean insertada = false;
		Position position = new Position();
		while (!insertada) {
			position = readPosition();
			position.setOrientation(readOrientation());
			position.setSize(tamañoBarcoActual);
			insertada = isValidOrientation(position);

			if (!insertada) {
				System.out.println("La posicion " + position.toString() + "\nNo es correcta!\nIntroduce una de nuevo!");
			}
		}
		insertBoat(position);
		position.toString();
	}

	/**
	 * Generates a random boat orientation
	 * 
	 * @return
	 */
	public int generateOrientation() {

		int orientacion = -1;
		boolean aux = false;
		while (!aux) {
			int ori = managerIO.getRandomInt();
			if (ori >= 0 && ori < 4) {
				orientacion = ori;
				aux = true;
			}
		}
		return orientacion;
	}

	/**
	 * Generates a random placement position
	 * 
	 * @return
	 */
	public Position generatePosition() {

		boolean aux = false;
		Position generado = new Position();
		while (!aux) {

			while (!aux) {
				int x = managerIO.getRandomInt();

				if (x > 0 && x < 11) {
					generado.setX(x - 1);
					aux = true;
				}
			}
			aux = false;
			while (!aux) {
				int y = managerIO.getRandomInt();
				if (y > 0 && y < 11) {
					generado.setY(y - 1);
					aux = true;
				}
			}
		}
		return generado;
	}

	/**
	 * Insert an N-size boat in a random board position
	 * 
	 * @param tamañoBarcoActual
	 */
	public void insertPosicionRandom(int tamañoBarcoActual) {
		boolean insertada = false;
		Position posicion = new Position();
		while (!insertada) {
			posicion = generatePosition();
			posicion.setOrientation(generateOrientation());
			posicion.setSize(tamañoBarcoActual);
			insertada = isValidOrientation(posicion);
		}
		System.out.println("La IA-Random ya ha posicionado sus barcos!\n");
		insertBoat(posicion);
		posicion.toString();
	}

	/**
	 * The player attacks the machine
	 * 
	 * @param randomIA
	 */
	public void atacar(IPlayer randomIA) {
		Position posicion = new Position();
		posicion = readPosition();
		Board aux = randomIA.getOwn();

		if (aux.board[posicion.getX()][posicion.getY()] == 1 && this.board[posicion.getX()][posicion.getY()] < 2) {
			System.out.println("Barco TOCADO!");
			this.board[posicion.getX()][posicion.getY()] = 2;
			this.numberBoats--;
		} else {
			System.out.println("AGUA!");
			this.board[posicion.getX()][posicion.getY()] = 3;
		}

	}

	/**
	 * The machine randomly attacks the player
	 * 
	 * @param player
	 */
	public void atacarRandom(IPlayer player) {

		Position posicion = new Position();
		posicion = generatePosition();
		Board aux = player.getOwn();

		if (aux.board[posicion.getX()][posicion.getY()] == 1 && this.board[posicion.getX()][posicion.getY()] < 2) {
			System.out.println("Barco TOCADO!");
			this.board[posicion.getX()][posicion.getY()] = 2;
			this.numberBoats--;
		} else {
			System.out.println("AGUA!");
			this.board[posicion.getX()][posicion.getY()] = 3;
		}
	}

}
