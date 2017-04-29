package com.ter.CellularAutomaton.vue;

import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell1D;

public class DownwardTriangleForm1D implements IForm {

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		int[] x={abscissaX * Cell1D.CELL_SIZE,abscissaX * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE/2,abscissaX * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE};
		int[] y={ordinateY * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE};
		g.fillPolygon(x,y,3);//Draw a downward triangle witch represent the cell
	}

}
