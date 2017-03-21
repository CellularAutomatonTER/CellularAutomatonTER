package com.ter.CellularAutomaton.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class RulesEntryModeWindow {

	private JFrame m_frame;
	private JPanel m_mainPanel;
	private JPanel m_panelElementary;
	private JButton m_buttonElementary;
	private JPanel m_panelAdditive;
	private JButton m_buttonAdditive;
	private JPanel m_panelPattern;
	private JButton m_buttonPattern;
	private JPanel m_panelScript;
	private JButton m_buttonScript;
	
	

	/**
	 * Create the application.
	 */
	public RulesEntryModeWindow() {
		buildMainPanel();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void buildMainPanel() {
		m_frame = new JFrame();
		m_frame.setTitle("Rules entry mode");
		m_frame.setSize(450, 300);
		m_frame.setLocationRelativeTo(null);
		m_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		buildPanelMain();//Build the main panel
	}
	
	/******Build Main Panel******/
	//Build the main panel
	private void buildPanelMain(){
		m_mainPanel = new JPanel();
		m_frame.getContentPane().add(m_mainPanel, BorderLayout.CENTER);
		m_mainPanel.setLayout(new BoxLayout(m_mainPanel, BoxLayout.Y_AXIS));
		
		buildComponentPanelMain();//Build the component of main panel
	}
	
	//Build the component of main panel
	private void buildComponentPanelMain(){
		buildPanelElementary();//Build the Elementary panel
		
		buildPanelAdditive();//Build the Additive panel
		
		buildPanelPattern();//Build the Pattern panel
		
		buildPanelScript();//Build the Script panel
	}
	
	/******Build Tab Elementary******/
	//Build the Elementary panel
	private void buildPanelElementary(){
		m_panelElementary = new JPanel();
		m_mainPanel.add(m_panelElementary);
		m_panelElementary.setLayout(new BorderLayout(0, 0));
		
		buildComponentPanelElementary();//Build the component of Elementary panel
	}
	
	//Build the component of Elementary panel
	private void buildComponentPanelElementary(){		
		m_buttonElementary = new JButton("Elementary");
		m_panelElementary.add(m_buttonElementary, BorderLayout.CENTER);
	}
	
	/******Build Tab Additive******/
	//Build the Additive panel
	private void buildPanelAdditive(){
		m_panelAdditive = new JPanel();
		m_mainPanel.add(m_panelAdditive);
		m_panelAdditive.setLayout(new BorderLayout(0, 0));
		
		buildComponentPanelAdditive();//Build the component of Additive panel
	}
	
	//Build the component of Additive panel
	private void buildComponentPanelAdditive(){		
		m_buttonAdditive = new JButton("Additive");
		m_panelAdditive.add(m_buttonAdditive, BorderLayout.CENTER);
	}
	
	/******Build Tab Pattern******/
	//Build the Pattern panel
	private void buildPanelPattern(){
		m_panelPattern = new JPanel();
		m_mainPanel.add(m_panelPattern);
		m_panelPattern.setLayout(new BorderLayout(0, 0));
		
		buildComponentPanelPattern();//Build the component of Pattern panel
	}
	
	//Build the component of Pattern panel
	private void buildComponentPanelPattern(){		
		m_buttonPattern = new JButton("Pattern");
		m_panelPattern.add(m_buttonPattern, BorderLayout.CENTER);
	}
	
	/******Build Tab Script******/
	//Build the Script panel
	private void buildPanelScript(){
		m_panelScript = new JPanel();
		m_mainPanel.add(m_panelScript);
		m_panelScript.setLayout(new BorderLayout(0, 0));
		
		buildComponentPanelScript();//Build the component of Script panel
	}
	
	//Build the component of Script panel
	private void buildComponentPanelScript(){		
		m_buttonScript = new JButton("Script");
		m_panelScript.add(m_buttonScript, BorderLayout.CENTER);
	}

}
