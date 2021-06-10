package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class realizarReserva extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
	private JFormattedTextField dataInicial;
	private JFormattedTextField dataFinal;
	private JFormattedTextField caixaDeTextoCPF;
	private JList listaDeTiposDeQuarto;
	private JLabel lblNewLabel_2_2;
	private JList listaDeTiposDeQuarto_1;
	private JLabel lblNewLabel_2_3;
	private JTextField valorTotal;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					realizarReserva frame = new realizarReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public realizarReserva() throws ParseException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(126, 208, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REALIZAR RESERVA");
		lblNewLabel.setBounds(304, 52, 233, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 126, 36, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Data Inicial:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 187, 94, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_5 = new JLabel("Data Final:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(453, 187, 84, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tipo De Quarto: ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 246, 134, 22);
		contentPane.add(lblNewLabel_2_1);
		
		dataInicial = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataInicial.setBounds(114, 180, 207, 32);
		contentPane.add(dataInicial);
		
		dataFinal = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataFinal.setBounds(547, 180, 207, 32);
		contentPane.add(dataFinal);
		
		caixaDeTextoCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		caixaDeTextoCPF.setBounds(56, 119, 265, 32);
		contentPane.add(caixaDeTextoCPF);
		
		listaDeTiposDeQuarto = new JList();
		listaDeTiposDeQuarto.setBounds(154, 246, 167, 22);
		contentPane.add(listaDeTiposDeQuarto);
		
		lblNewLabel_2_2 = new JLabel("Quarto:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(470, 246, 67, 22);
		contentPane.add(lblNewLabel_2_2);
		
		listaDeTiposDeQuarto_1 = new JList();
		listaDeTiposDeQuarto_1.setBounds(547, 246, 207, 22);
		contentPane.add(listaDeTiposDeQuarto_1);
		
		lblNewLabel_2_3 = new JLabel("Valor Total:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(10, 404, 94, 22);
		contentPane.add(lblNewLabel_2_3);
		
		valorTotal = new JTextField("R$ ####,##");
		valorTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		valorTotal.setBounds(114, 402, 207, 32);
		contentPane.add(valorTotal);
		valorTotal.setColumns(10);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setBackground(UIManager.getColor("Button.focus"));
		btnConfirmar.setBounds(704, 478, 112, 32);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(UIManager.getColor("Button.focus"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(582, 478, 112, 32);
		contentPane.add(btnCancelar);
		
		lblNewLabel_3.setBounds(-21, 447, 887, 22);
		contentPane.add(lblNewLabel_3);
		
	}
}
