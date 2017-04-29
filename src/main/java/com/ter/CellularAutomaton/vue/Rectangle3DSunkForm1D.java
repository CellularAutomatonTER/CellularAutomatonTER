package com.ter.CellularAutomaton.vue;

import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell1D;

public class Rectangle3DSunkForm1D implements IForm {

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		g.fill3DRect(abscissaX * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, false);//Draw a rectangle 3D sunk witch represent the cell
	}

}
