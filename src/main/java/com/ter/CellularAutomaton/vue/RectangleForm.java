package com.ter.CellularAutomaton.vue;

import java.awt.Color;
import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell1D;

public class RectangleForm implements IForm {

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		g.fillRect(abscissaX * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, Cell1D.CELL_SIZE);//Draw a rectangle witch represent the cell
	}

}
