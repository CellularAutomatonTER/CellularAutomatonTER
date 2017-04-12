package com.ter.CellularAutomaton.controller;

import com.ter.CellularAutomaton.vue.MainWindow1D;

public class RunApplication implements Runnable{
	
	/******ATTRIBUTES******/
	private MainWindow1D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RunApplication(MainWindow1D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
    public void run() {
    	this.window.runSimulation();                   
    }               
  } 