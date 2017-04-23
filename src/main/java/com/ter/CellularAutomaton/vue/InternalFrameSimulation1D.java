package com.ter.CellularAutomaton.vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ter.CellularAutomaton.controller.Cell1D;
import com.ter.CellularAutomaton.controller.IInitializeSimulationRules1D;
import com.ter.CellularAutomaton.controller.ResizeInternalFrameSimulation1DEvent;
import com.ter.CellularAutomaton.controller.Switch1DTo2DSimulationEvent;

public class InternalFrameSimulation1D extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	// For the logging.
	private static final Logger logger = LogManager.getLogger(InternalFrameSimulation1D.class.getName()); // TestLog4j1.class.getName() must be change in yourClassName.class.getName().

	private int m_width;
	private int m_height;
	private int m_refreshRate; //Updates per seconde
	private int m_millis;
	private Screen m_screen;
	private Simulation1D m_simulation;
	private Color m_backgroundColor;

	/******CONSTRUCTOR******/
	public InternalFrameSimulation1D(String title, IForm formOfCells, ArrayList<Color> colorOfCells, Color backgroundColor, IInitializeSimulationRules1D initializeSimulationRule) {
		super(title,true,true,true,true);
		m_width=1000;
		m_height = 600;
		m_refreshRate = 30;
		m_millis = 1000/m_refreshRate;
		m_simulation = new Simulation1D(m_width, m_height, formOfCells, colorOfCells, initializeSimulationRule);
		m_screen = new Screen();
		m_backgroundColor=backgroundColor;
		
		setLayout(new BorderLayout());
		add(m_screen, BorderLayout.CENTER);
		
		this.isClosable();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.pack();
		this.setSize(m_width + this.getInsets().left +  + this.getInsets().right, m_height + this.getInsets().bottom +  + this.getInsets().top);
		
		addListenerInternalFrameSimulation1D();
		
		this.setVisible(true);
	}
	
	/******GETTERS******/
	public Simulation1D getm_simulation() {
		return m_simulation;
	}
	
	public int getm_width() {
		return m_width;
	}
	
	public int getm_height() {
		return m_height;
	}
	
	/******SETTERS******/
	public void setm_width(int width) {
		this.m_width = width;
	}
	
	public void setm_height(int height) {
		this.m_height = height;
	}
	
	public void setm_refreshRate(int refreshRate) {
		this.m_refreshRate = refreshRate;
	}

	
	/******CLASS METHODS******/
	
	/******Listeners on InternalFrameSimulation1D******/
	private void addListenerInternalFrameSimulation1D(){
		addListenerResize();//add listener of button TypeOfSimulator
	}
	
	private void addListenerResize(){
		this.addComponentListener(new ResizeInternalFrameSimulation1DEvent(this));
	}
	
	
	public void startUpdate() {
			m_millis = 1000/m_refreshRate;
			long before = System.currentTimeMillis();
			m_simulation.update();//Simulation update

			m_screen.repaint();
			long diff = m_millis - (System.currentTimeMillis() - before);

			try {
				if(diff > 0){
					Thread.sleep(diff);
				}
			}
			catch (Exception e) {
				if(logger.isErrorEnabled()){
				logger.error("Thread.sleep issue.");
			}
			}
	}


	public class Screen extends JLabel implements MouseMotionListener, MouseListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		
		/******CONSTRUCTOR******/
		public Screen(){
			addListenerInternalFrameSimulation1D();
		}
		
		
		/******CLASS METHODS******/
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(m_backgroundColor);
			g.fillRect(0, 0, getWidth(), getHeight());
			m_simulation.draw(g);
		}
		
		/******Listeners on InternalFrameSimulation1D******/
		private void addListenerInternalFrameSimulation1D(){
		    this.addMouseMotionListener(this);
		    this.addMouseListener(this);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			 int mx = e.getX()/Cell1D.CELL_SIZE;
			 int my = e.getY()/Cell1D.CELL_SIZE;
			 System.out.println("mouse X="+mx+" et mouse Y= "+my);
			 System.out.println("Vous avez cliqué sur la cellule de coordonne X="+mx+" et Y= "+my);
			 m_simulation.getCellInSimulation(mx, my).setm_state(1);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}


	


}
