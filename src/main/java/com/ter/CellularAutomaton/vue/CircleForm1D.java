package com.ter.CellularAutomaton.vue;

import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell1D;

public class CircleForm1D implements IForm {

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		g.fillOval(abscissaX * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, Cell1D.CELL_SIZE) ;//Draw a fill circle witch represent the cell
	}

}
