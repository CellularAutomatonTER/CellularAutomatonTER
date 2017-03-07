package main;

import vue.MainWindow1D;
import vue.MainWindow2D;


/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		MainWindow2D SimulatorWindow = new MainWindow2D();
		MainWindow1D SimulatorWindow1D = new MainWindow1D();
		SimulatorWindow.runSimulation();
	}
}
