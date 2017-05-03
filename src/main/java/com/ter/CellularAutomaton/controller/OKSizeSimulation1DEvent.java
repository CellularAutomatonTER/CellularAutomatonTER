package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.SizeSimulationWindow;

public class OKSizeSimulation1DEvent implements ActionListener {


	/******ATTRIBUTES******/
	private SizeSimulationWindow m_sizeSimulationWindow;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public OKSizeSimulation1DEvent(SizeSimulationWindow sizeSimulationWindow) {
		super();
		this.m_sizeSimulationWindow = sizeSimulationWindow;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	//Convert string number to int number and return the int number
	private static int convertStringNumberToIntNumber(String stringNumber){
		//Convert
		return Integer.parseInt(stringNumber,10);//Convert string number to int number and return the int number
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		m_sizeSimulationWindow.getm_mainWindow1D().setm_simulationState(SimulationState.PAUSE);
		String space = " ";
		String stringInputWidthOfSimulation = m_sizeSimulationWindow.getm_formattedTextFieldWidthOfSimulation().getText();
		stringInputWidthOfSimulation = stringInputWidthOfSimulation.replaceAll("\\s","");//Delete space in string
		System.out.println(stringInputWidthOfSimulation);
		int intInputWidthOfSimulation = convertStringNumberToIntNumber(stringInputWidthOfSimulation);// Convert string number to int number and stock the int number.
		m_sizeSimulationWindow.getm_mainWindow1D().getm_internalFrameSimulation().getm_simulation().setm_nbCellWidth(intInputWidthOfSimulation/Cell1D.CELL_SIZE);//Set the new number of cell which define the width of simulation 
		
		String stringInputHeightOfSimulation = m_sizeSimulationWindow.getm_formattedTextFieldHeightOfSimulation().getText();
		String stringInputHeightOfSimulationWithoutSpace = stringInputHeightOfSimulation.replaceAll(space,"");//Delete space in string
		int intInputHeightOfSimulation = convertStringNumberToIntNumber(stringInputHeightOfSimulationWithoutSpace);// Convert string number to int number and stock the int number.
		m_sizeSimulationWindow.getm_mainWindow1D().getm_internalFrameSimulation().getm_simulation().setm_nbCellHeight(intInputHeightOfSimulation/Cell1D.CELL_SIZE);//Set the new number of cell which define the height of simulation 
		
		m_sizeSimulationWindow.getm_mainWindow1D().getm_internalFrameSimulation().getm_simulation().initByDefaultSimulation();
		m_sizeSimulationWindow.getm_mainWindow1D().setm_simulationState(SimulationState.RUN);
		
		this.m_sizeSimulationWindow.dispose();//Close the current the window
	}
}