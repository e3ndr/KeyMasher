package ga.endedglory.keymasher;

import static java.awt.event.KeyEvent.VK_ALT;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class guiStop {

	private JFrame frame;
	private final Action action = new SwingAction();
    private Robot robot;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiStop window = new guiStop();
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
	public guiStop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(225,150));
		frame.pack();
		frame.setResizable(false);
		frame.setTitle("Key Masher");
		
		JButton btnStop = new JButton("Stop key mashing");
		btnStop.setAction(action);
		frame.getContentPane().add(btnStop, BorderLayout.CENTER);
		
	}

	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Stop key mashing");
			putValue(SHORT_DESCRIPTION, "Stops KeyMasher");
		}
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Stopped!");
			System.out.println("Stopped!");
			try {
				robot = new Robot();
			} catch (AWTException e1) {}
			robot.keyRelease(VK_ALT); 
			System.exit(0);
		}
	}
}
