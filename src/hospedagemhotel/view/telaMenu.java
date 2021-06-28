package Janelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class telaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaMenu frame = new telaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telaMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(telaMenu.class.getResource("/Janelas/predioIcone1.2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 550);
		contentPane = new JPanel();
		
 
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(126, 208, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(telaMenu.class.getResource("/Janelas/paginainicial.png")));
		lblNewLabel.setBounds(0, 0, 851, 511);
		contentPane.add(lblNewLabel);

		
		JButton BotãoReserva = new JButton("RESERVA");
		BotãoReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lblNewLabel.add(BotãoReserva);
		BotãoReserva.setBounds(364, 244, 100, 35);
		
		JButton BotaoCheckIN = new JButton("CHECK-IN");
		lblNewLabel.add(BotaoCheckIN);
		BotaoCheckIN.setBounds(364, 289, 100, 35);
	}
}
