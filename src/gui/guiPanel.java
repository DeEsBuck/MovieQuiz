package gui;
import javax.swing.*;


	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JApplet;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JRadioButton;
	import javax.swing.LookAndFeel;
	import javax.swing.UIManager;
	import javax.swing.UIManager.LookAndFeelInfo;

	public class guiPanel extends JApplet implements ActionListener {

	  JButton Start;
	  JLabel  lblMessage = new JLabel();
	  
	  public guiPanel() {
	    setLayout( new FlowLayout() );
	    
	    Start = new JButton("Hello");
	    lblMessage = new JLabel("Nichts angeklickt");
	  }
	  
	  public void init() {
	    // Aktion zu Hello-Button hinzufuegen
	    Start.addActionListener( this );
	    
	    // Elemente auf JApplet einfuegen
	    add( lblMessage );
	    add( Start );
	  }
	  
	  public void start() {
	  }
	  
	  public void stop() {
	    // stoppe Ausführung
	  }
	  public void destroy() {
	    // initialisierte Ressourcen freigeben
	  }

	  public void actionPerformed(ActionEvent arg0) {
	    lblMessage.setText( "JButton wurde gedrueckt!" );
	  }
	}


