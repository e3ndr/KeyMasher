package ga.endedglory.keymasher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class guiStart {

	private JFrame frame;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiStart window = new guiStart();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiStart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(250,75));
		frame.pack();
		frame.setResizable(false);
		frame.setTitle("Key Masher");
		
		textField = new JTextField();
		textField.setToolTipText("Enter keys to be mashed");
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.setAction(action);
		frame.getContentPane().add(btnStart, BorderLayout.EAST);

	}
	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Start");
			putValue(SHORT_DESCRIPTION, "Starts key mashing");
		}
		public void actionPerformed(ActionEvent e) {
	        main.start = true;
	        main.text = textField.getText();
	        System.out.println(main.text);
	        frame.setVisible(false); //you can't see me!
		}
	}
}
