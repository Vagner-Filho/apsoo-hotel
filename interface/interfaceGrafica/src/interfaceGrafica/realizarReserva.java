package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.UIManager;

public class realizarReserva extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(126, 208, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel realizarReservaLabel = new JLabel("REALIZAR RESERVA");
		realizarReservaLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		realizarReservaLabel.setBounds(304, 52, 238, 32);
		contentPane.add(realizarReservaLabel);
		
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cpfLabel.setBounds(10, 126, 36, 13);
		contentPane.add(cpfLabel);
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataInicial.setBounds(10, 187, 94, 13);
		contentPane.add(lblDataInicial);
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataFinal.setBounds(453, 187, 84, 13);
		contentPane.add(lblDataFinal);
		
		JLabel lblTipoDeQuarto = new JLabel("Tipo De Quarto:");
		lblTipoDeQuarto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeQuarto.setBounds(10, 246, 134, 22);
		contentPane.add(lblTipoDeQuarto);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValorTotal.setBounds(10, 404, 94, 22);
		contentPane.add(lblValorTotal);
		
		JLabel lblQuarto = new JLabel("Quarto:");
		lblQuarto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuarto.setBounds(470, 246, 62, 22);
		contentPane.add(lblQuarto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(UIManager.getColor("Button.focus"));
		btnCancelar.setBounds(582, 470, 112, 32);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(UIManager.getColor("Button.focus"));
		btnConfirmar.setBounds(704, 470, 112, 32);
		contentPane.add(btnConfirmar);
		
		JFormattedTextField cpfCaixaDeTexto = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		cpfCaixaDeTexto.setBounds(56, 119, 265, 32);
		contentPane.add(cpfCaixaDeTexto);
		
		JFormattedTextField dataInicialCaixaDeTexto = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataInicialCaixaDeTexto.setBounds(114, 180, 207, 32);
		contentPane.add(dataInicialCaixaDeTexto);
		
		JFormattedTextField dataFinalCaixaDeTexto = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataFinalCaixaDeTexto.setBounds(547, 180, 207, 32);
		contentPane.add(dataFinalCaixaDeTexto);
		
		JList tipoDeQuartoLista = new JList();
		tipoDeQuartoLista.setBounds(154, 246, 167, 22);
		contentPane.add(tipoDeQuartoLista);
		
		JList quartoLista = new JList();
		quartoLista.setBounds(547, 246, 207, 22);
		contentPane.add(quartoLista);
		
		JFormattedTextField valorTotalCaixaDeTexto = new JFormattedTextField();
		valorTotalCaixaDeTexto.setBounds(114, 402, 207, 32);
		contentPane.add(valorTotalCaixaDeTexto);
	}
}
