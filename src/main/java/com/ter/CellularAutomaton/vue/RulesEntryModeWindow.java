package com.ter.CellularAutomaton.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class RulesEntryModeWindow {

	private JFrame m_frame;


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
		
		JPanel panel = new JPanel();
		m_frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Elementary");
		panel_1.add(btnNewButton, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("Additive");
		panel_2.add(btnNewButton_1, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_2 = new JButton("Pattern");
		panel_3.add(btnNewButton_2, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_3 = new JButton("Script");
		panel_4.add(btnNewButton_3, BorderLayout.CENTER);
	}

}
