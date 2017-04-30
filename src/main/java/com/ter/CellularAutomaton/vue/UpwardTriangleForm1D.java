package com.ter.CellularAutomaton.vue;

import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell1D;

public class UpwardTriangleForm1D implements IForm {
	
	
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public UpwardTriangleForm1D(MainWindow1D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		int[] x={abscissaX * Cell1D.CELL_SIZE,abscissaX * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE/2,abscissaX * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE};
		int[] y={ordinateY * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE};
		g.fillPolygon(x,y,3);//Draw a upward triangle witch represent the cell
	}

}
