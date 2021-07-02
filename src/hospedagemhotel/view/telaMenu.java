package hospedagemhotel.view;

import hospedagemhotel.persistencia.Conexao;

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
	 * Create the frame.
	 */
	public telaMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(telaMenu.class.getResource("images/predioIcone1.2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 550);
		contentPane = new JPanel();

		contentPane.setLayout(null);
		contentPane.setBackground(new Color(126, 208, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblNewLabel = new JLabel();
		//lblNewLabel.setIcon(new ImageIcon(telaMenu.class.getResource("images/paginainicial.png")));
		lblNewLabel.setBounds(0, 0, 851, 511);
		contentPane.add(lblNewLabel);


		JButton BotaoReserva = new JButton("RESERVA");
		BotaoReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == BotaoReserva) {
					try {
						realizarReserva frameReserva = new realizarReserva();
						frameReserva.setVisible(true);

					} catch (Exception a) {
						a.printStackTrace();
					}

				}

			}
		});
		lblNewLabel.add(BotaoReserva);
		BotaoReserva.setBounds(364, 244, 100, 35);

		JButton BotaoCheckIN = new JButton("CHECK-IN");
		lblNewLabel.add(BotaoCheckIN);
		BotaoCheckIN.setBounds(364, 289, 100, 35);
		BotaoCheckIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == BotaoCheckIN) {
					try {
						realizarCheckin frameReserva = new realizarCheckin();
						frameReserva.setVisible(true);

					} catch (Exception a) {
						a.printStackTrace();
					}

				}
			}
		});

	}
}