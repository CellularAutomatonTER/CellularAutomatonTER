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
import javax.swing.JSeparator;


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
	
	/** Component of window */
	private final JPanel m_panelControl = new JPanel();
	private final JButton m_buttonReset = new JButton("Reset");
	private final JCheckBox chckbxNewCheckBox = new JCheckBox("Remember this setting");
	private final JPanel m_panelRulesSetting = new JPanel();
	private final JLabel m_labelAlphabet = new JLabel("Alphabet (0 to ?):");
	private final JFormattedTextField formattedTextField = new JFormattedTextField();
	private final JLabel m_labelRules = new JLabel("Rules (0 to 255):");
	private final JFormattedTextField formattedTextField_1 = new JFormattedTextField();
	private final JButton btnOk = new JButton("OK");


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
		this.setSize(470,320);
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
		getContentPane().add(m_panelControl, BorderLayout.SOUTH);
		GroupLayout gl_panel_1 = new GroupLayout(m_panelControl);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_buttonReset, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(chckbxNewCheckBox)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox)
						.addComponent(btnOk, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(m_buttonReset, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		m_panelControl.setLayout(gl_panel_1);
		
		m_labelAlphabet.setFont(new Font(m_labelAlphabet.getFont().getName(), m_labelAlphabet.getFont().getStyle(), 15));// new font size is 15
		m_labelRules.setFont(new Font(m_labelRules.getFont().getName(), m_labelRules.getFont().getStyle(), 15));// new font size is 15
		
		getContentPane().add(m_panelRulesSetting, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JButton btnNewButton = new JButton("Personalize");
		
		
		GroupLayout gl_panel_5 = new GroupLayout(m_panelRulesSetting);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10000, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 10000, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(m_labelAlphabet, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(m_labelRules, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelAlphabet)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(39)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelRules, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		m_panelRulesSetting.setLayout(gl_panel_5);
		
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
