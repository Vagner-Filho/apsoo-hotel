package hospedagemhotel.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospedagemhotel.Sistema;
import hospedagemhotel.bd.Conexao;
import hospedagemhotel.entidades.Hospede;

public class procurarHospede extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					procurarHospede frame = new procurarHospede();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public procurarHospede() {
		setTitle("Buscar H\u00F3spede");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(126, 208, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUSCAR H\u00D3SPEDE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(304, 52, 219, 32);
		contentPane.add(lblNewLabel);
		
		JFormattedTextField cpfCaixaDeTexto = new JFormattedTextField();
		cpfCaixaDeTexto.setBounds(244, 152, 328, 41);
		contentPane.add(cpfCaixaDeTexto);
		
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cpfLabel.setBounds(195, 152, 50, 37);
		contentPane.add(cpfLabel);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setBounds(341, 223, 140, 40);
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("botao confirmar clicado");
				
				Sistema sis = new Sistema();
				//System.out.println(cpfCaixaDeTexto.getText());
				//sis.buscarHospede(cpfCaixaDeTexto.getText());
				Hospede hos = new Hospede();
				hos = Conexao.buscarHospede(cpfCaixaDeTexto.getText());
				System.out.println(hos.getNome());
			}
		});
		contentPane.add(btnBuscar);
	}

}
