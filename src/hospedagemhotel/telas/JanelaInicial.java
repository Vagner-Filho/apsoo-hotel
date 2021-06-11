package hospedagemhotel.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class JanelaInicial extends JFrame {
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldCep;
	private JTextField textFieldTelefone;
	private JTextField textFieldUF;
	private JTextField textFieldSexo;
	private JTextField textFieldNumero;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldComplemento;
	private JTextField textFieldDia;
	private JTextField textFieldMes;
	private JTextField textFieldAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaInicial frame = new JanelaInicial();
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
	public JanelaInicial() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(JanelaInicial.class.getResource("/Janelas/predioIcone1.2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(126, 208, 255));
		setBounds(100, 100, 850, 550);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(126, 208, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(173, 409, 105, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldNome.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	Nome n�o preenchido");

				} else if (textFieldCPF.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	CPF n�o preenchido");

				} else if (textFieldCep.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	Cep n�o preenchido");
				} else if (textFieldTelefone.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	Telefone n�o preenchido");
				} else if (textFieldDia.getText().length() <= 0 || textFieldMes.getText().length() <= 0
						|| textFieldAno.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	Data n�o preenchida");
				} else if (textFieldUF.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	Estado n�o preenchido");
				} else if (textFieldSexo.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	Sexo n�o preenchido");
				} else if (textFieldNumero.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	Numero n�o preenchido");
				} else if (textFieldRua.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	Rua n�o preenchida");
				} else if (textFieldBairro.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Erro: 	Bairro n�o preenchido");
				}

				else {

				}

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(58, 409, 105, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(62, 161, 215, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(62, 192, 215, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);

		textFieldCep = new JTextField();
		textFieldCep.setBounds(62, 223, 215, 20);
		contentPane.add(textFieldCep);
		textFieldCep.setColumns(10);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(62, 254, 215, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		textFieldUF = new JTextField();
		textFieldUF.setBounds(335, 161, 32, 20);
		contentPane.add(textFieldUF);
		textFieldUF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(24, 164, 42, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(34, 195, 42, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cep:");
		lblNewLabel_2.setBounds(30, 226, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setBounds(6, 257, 84, 14);
		contentPane.add(lblNewLabel_3);

		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(408, 161, 32, 20);
		contentPane.add(textFieldSexo);
		textFieldSexo.setColumns(10);

		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(335, 192, 46, 20);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);

		textFieldRua = new JTextField();
		textFieldRua.setBounds(335, 223, 105, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);

		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(335, 254, 105, 20);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);

		textFieldComplemento = new JTextField();
		textFieldComplemento.setBounds(335, 285, 105, 20);
		contentPane.add(textFieldComplemento);
		textFieldComplemento.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("UF:");
		lblNewLabel_4.setBounds(304, 164, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Sexo:");
		lblNewLabel_5.setBounds(376, 164, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("N\u00BA:");
		lblNewLabel_6.setBounds(304, 195, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Rua:");
		lblNewLabel_7.setBounds(298, 226, 28, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Bairro:");
		lblNewLabel_8.setBounds(287, 257, 63, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Complemento:");
		lblNewLabel_9.setBounds(245, 288, 93, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Data de nascimento:");
		lblNewLabel_10.setBounds(57, 288, 136, 14);
		contentPane.add(lblNewLabel_10);

		textFieldDia = new JTextField();
		textFieldDia.setBounds(62, 313, 32, 20);
		contentPane.add(textFieldDia);
		textFieldDia.setColumns(10);

		textFieldMes = new JTextField();
		textFieldMes.setBounds(161, 313, 32, 20);
		contentPane.add(textFieldMes);
		textFieldMes.setColumns(10);

		textFieldAno = new JTextField();
		textFieldAno.setBounds(245, 313, 32, 20);
		contentPane.add(textFieldAno);
		textFieldAno.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Dia:");
		lblNewLabel_11.setBounds(32, 316, 46, 14);
		contentPane.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("M\u00EAs:");
		lblNewLabel_12.setBounds(128, 313, 46, 14);
		contentPane.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Ano:");
		lblNewLabel_13.setBounds(218, 316, 46, 14);
		contentPane.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(JanelaInicial.class.getResource("/Janelas/cadastro.png")));
		lblNewLabel_14.setBounds(-80, 37, 954, 92);
		contentPane.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(589, 291, 46, 14);
		contentPane.add(lblNewLabel_15);
	}
}
