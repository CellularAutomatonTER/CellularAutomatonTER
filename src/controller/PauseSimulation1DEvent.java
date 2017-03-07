package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimulationState;
import vue.MainWindow1D;

public class PauseSimulation1DEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private MainWindow1D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public PauseSimulation1DEvent(MainWindow1D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.setm_simulationState(SimulationState.PAUSE);
	}

}
