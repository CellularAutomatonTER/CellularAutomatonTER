package com.ter.CellularAutomaton.vue;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import com.ter.CellularAutomaton.controller.CloseElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


public class ElementaryRulesWindow extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	private JMenuBar m_menuBar = new JMenuBar();

	/** The menu file. */
	//Tab in MenuBar
	private JMenu m_menuFile = new JMenu("File");
	
	/** The menu bar file item 1. */
	// In file menu

	/** The menu bar file item 1. */
	private JMenuItem m_menuBarFileItem1 = new JMenuItem("Close");

	/** The menu bar file item 2. */
	private JMenuItem m_menuBarFileItem2 = new JMenuItem("Quit");
	private final JPanel panel_1 = new JPanel();
	private final JButton btnReset = new JButton("Reset");
	private final JCheckBox chckbxNewCheckBox = new JCheckBox("Set Actual Setting By Default");
	private final JButton btnOk = new JButton("OK");
	private final Component rigidArea = Box.createRigidArea(new Dimension(80, 20));
	private final Component rigidArea_1 = Box.createRigidArea(new Dimension(80, 20));
	private final JPanel panel_2 = new JPanel();


	/**
	 * Create the application.
	 */
	public ElementaryRulesWindow() {
		
		buildComponentWindow();//Build component of window
		
		this.initMenuMnemonic();//Set mnemonic of the MenuBar
		
		this.initMenuBar();//We initialize our menuBar
		
		this.addListenerMenuBar();//We initialize Listener of menuBar
		
		//Set the window visible
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void buildComponentWindow() {
		this.setTitle("Elementary Rules Window");
		this.setSize(480,310);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
	/**
	 * Inits the menu bar.
	 */
	private void initMenuBar(){
		//We initialize our menuBar 
		this.constructTabFileMenuBar();//Construction of the tab "File" of menuBar
		
		this.setJMenuBar(m_menuBar);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		panel_1.add(btnReset);
		
		panel_1.add(rigidArea);
		
		panel_1.add(chckbxNewCheckBox);
		
		panel_1.add(rigidArea_1);
		
		panel_1.add(btnOk);
		getContentPane().add(panel_5, BorderLayout.CENTER);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 464, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 217, Short.MAX_VALUE)
		);
		panel_5.setLayout(gl_panel_5);
		
		this.initAcceleratorMenuBar();//Adding all Accelerator of the MenuBar
	}
	
	/**
	 * Construct tab file menu bar.
	 */
	private void constructTabFileMenuBar(){
		//Construction of the tab "File" of menuBar
		this.m_menuFile.add(m_menuBarFileItem1);//Adding a tab "Close" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItem2);//Adding a tab "Quit" in tab File in MenuBar
		this.m_menuBar.add(m_menuFile);//the File tab is added to MenuBar
	}
	
	
	/******Mnemonic******/
	/**
	 * Inits the menu mnemonic.
	 */
	private void initMenuMnemonic(){
		//add all the mnémonic for the MenuBar
		m_menuFile.setMnemonic('F');
	}
	
	/******Accelerator******/
	/**
	 * *Init the accelerators**.
	 */
	private void initAcceleratorMenuBar(){
		//add all the accelerators for the items
		this.initAcceleratorFile(); //accelerator of tab File
	}
	
	private void initAcceleratorFile(){
		//add all the accelerators for the items of tab File
		m_menuBarFileItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK)); //add accelerators of Close in tab File
		m_menuBarFileItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK)); //add accelerators of Quit in tab File
	}
	
	/******Listeners MenuBar******/
	//add listeners MenuBar
	private void addListenerMenuBar (){
		this.addListenerFile(); //add listener of tab File
	}

	//add listeners for tab File in MenuBar
	private void addListenerFile (){
		m_menuBarFileItem1.addActionListener(new CloseElementaryRulesWindowEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}
}
