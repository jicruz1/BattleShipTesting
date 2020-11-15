package BattelshipTesting;

import java.util.Random;
import java.util.Scanner;

import interfaces.IManagerIO;

/**
 * Class to manager Input/Outputs
 * 
 * @author Cristian Vega
 *
 */
public class ManagerIO implements IManagerIO {
	private Scanner scanner = new Scanner(System.in);;
	Random rn;

	public ManagerIO() {

	}

	/**
	 * Function that prints a String in the output buffer
	 */
	public void out(String data) {
		System.out.print(data);
	}

	/**
	 * Function that prints an Integer in the output buffer
	 */
	public void out(int data) {
		System.out.print(data);
	}

	/**
	 * Function reads keyboard input from an Integer value
	 */
	public int inInt() {
		return scanner.nextInt();
	}

	/**
	 * Function that generates a random number between 0-10
	 */
	public int getRandomInt() {
		rn = new Random();
		return rn.nextInt(10) + 1;
	}

	/**
	 * Function that generates random orientation between 0-4
	 */
	public int getRandomOrientacion() {
		rn = new Random();
		return rn.nextInt(4) + 0;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

}