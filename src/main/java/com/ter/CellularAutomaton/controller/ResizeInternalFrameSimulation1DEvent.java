package com.ter.CellularAutomaton.controller;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ter.CellularAutomaton.vue.InternalFrameSimulation1D;

public class ResizeInternalFrameSimulation1DEvent implements ComponentListener {
	
	/******ATTRIBUTES******/
	// For the logging.
	private static final Logger logger = LogManager.getLogger(ResizeInternalFrameSimulation1DEvent.class.getName()); // TestLog4j1.class.getName() must be change in yourClassName.class.getName().

	private InternalFrameSimulation1D m_currentInternalFrameSimulation1D;

	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ResizeInternalFrameSimulation1DEvent(InternalFrameSimulation1D currentInternalFrameSimulation1D) {
		super();
		this.m_currentInternalFrameSimulation1D = currentInternalFrameSimulation1D;
	}
	
	
	@Override
	public void componentResized(ComponentEvent e) {
		if(logger.isDebugEnabled()){
			logger.debug("Resizing the internal frame");
		}
		this.m_currentInternalFrameSimulation1D.setm_width(this.m_currentInternalFrameSimulation1D.getWidth());
		this.m_currentInternalFrameSimulation1D.setm_height(this.m_currentInternalFrameSimulation1D.getHeight());
		
		this.m_currentInternalFrameSimulation1D.getm_simulation().setm_nbCellWidth(this.m_currentInternalFrameSimulation1D.getm_width()/Cell1D.CELL_SIZE);
		this.m_currentInternalFrameSimulation1D.getm_simulation().setm_nbCellHeight(this.m_currentInternalFrameSimulation1D.getm_height()/Cell1D.CELL_SIZE);
		
		this.m_currentInternalFrameSimulation1D.getm_simulation().initByDefaultSimulation();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
