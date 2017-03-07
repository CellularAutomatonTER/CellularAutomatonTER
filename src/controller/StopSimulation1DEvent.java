package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimulationState;
import vue.MainWindow1D;

public class StopSimulation1DEvent implements ActionListener  {
	/******ATTRIBUTES******/
	private MainWindow1D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public StopSimulation1DEvent(MainWindow1D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.setm_simulationState(SimulationState.STOP);
	}
}
