package com.ter.CellularAutomaton.controller;

import java.awt.Color;

import com.ter.CellularAutomaton.vue.IForm;

@FunctionalInterface
public interface IInitializeSimulationRules1D {
	public void initializeSimulation(Cell1D[][] cells, int nbCellWidth, int nbCellHeight, IRules1D cellularAutomaton, IForm formOfCells, Color colorOfCells);
}
