package BattelshipTesting;

import java.util.Random;
import java.util.Scanner;

import interfaces.IManagerIO;

/**
 * Class to manager Input/Outputs
 * @author Cristian Vega
 *
 */
public class ManagerIO implements IManagerIO {
	private Scanner scanner = new Scanner(System.in);;
	Random rn;

	public ManagerIO() {

	}

	public int inInt() {
		return scanner.nextInt();
	}

	public void out(String data) {
		System.out.print(data);
	}

	public void out(int data) {
		System.out.print(data);
	}

	public int getRandomInt() {
		rn = new Random();
		return rn.nextInt(10) + 1;
	}

	public int getRandomOrientacion() {
		rn = new Random();
		return rn.nextInt(4) + 0;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

}