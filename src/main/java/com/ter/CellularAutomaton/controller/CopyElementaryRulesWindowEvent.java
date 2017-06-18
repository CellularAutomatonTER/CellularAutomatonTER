package com.ter.CellularAutomaton.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;

public class CopyElementaryRulesWindowEvent implements ActionListener {
	/******ATTRIBUTES******/
	private ElementaryRulesWindow m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CopyElementaryRulesWindowEvent(ElementaryRulesWindow window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	private String printClipboard (){
	    //display what is currently on the clipboard
	    System.out.println("Clipboard contains:" + this.getClipboardContents());
	    return "Clipboard contains: " + this.getClipboardContents();
	}
	
	 /**
	  * Get the String residing on the clipboard.
	  *
	  * @return any text found on the Clipboard; if none found, return an
	  * empty String.
	  */
	  private String getClipboardContents() {
	    String result = "";
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    //odd: the Object param of getContents is not currently used
	    Transferable contents = clipboard.getContents(null);
	    boolean hasTransferableText =
	      (contents != null) &&
	      contents.isDataFlavorSupported(DataFlavor.stringFlavor)
	    ;
	    if (hasTransferableText) {
	      try {
	        result = (String)contents.getTransferData(DataFlavor.stringFlavor);
	      }
	      catch (UnsupportedFlavorException | IOException ex){
	        System.out.println(ex);
	        ex.printStackTrace();
	      }
	    }
	    return result;
	  }
	
	  /**
	  * Place a String on the clipboard, and make this class the
	  * owner of the Clipboard's contents.
	  */
	  public void setClipboardContents(String aString){
			StringSelection stringSelection = new StringSelection(aString);
			Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
			clpbrd.setContents(stringSelection, null);
	  }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedText = m_window.getm_formattedTextFieldRadius().getSelectedText(); // Get selected text.
		setClipboardContents(selectedText); // Put selected text in the clipboard.
		//printClipboard();
	}


}
