package hospedagemhotel.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import java.sql.Date; import java.text.SimpleDateFormat;


import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import hospedagemhotel.controller.Sistema;
import hospedagemhotel.model.Quarto;
import hospedagemhotel.model.TipoDeQuarto;
import hospedagemhotel.model.Hospede;

public class realizarReserva extends JFrame {

	private JPanel contentPane;
	private Quarto quarto;

	Sistema sis = new Sistema();

	/**
	 * Create the frame.
	 * @throws ParseException 
	*/
	public realizarReserva() throws ParseException {
		setTitle("Realizar Reserva");
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
		
		JFormattedTextField cpfCaixaDeTexto = new JFormattedTextField();
		cpfCaixaDeTexto.setBounds(56, 119, 265, 32);
		contentPane.add(cpfCaixaDeTexto);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBackground(UIManager.getColor("Button.focus"));
		btnBuscar.setBounds(331, 124, 99, 22);
		btnBuscar.addActionListener(new ActionListener(){
			Hospede hos = new Hospede();
			public void actionPerformed(ActionEvent e) {
				System.out.println("botao confirmar clicado");
				
				Sistema sis = new Sistema();
				String val;
				
				hos = sis.buscarHospede(cpfCaixaDeTexto.getText());
				val = cpfCaixaDeTexto.getText();

				JLabel nomeLabel = new JLabel();
				nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				nomeLabel.setBounds(470, 117, 200, 37);

				if(hos == null){
					JOptionPane.showMessageDialog(null, "Hóspede não cadastrado");
				}else if (val.length() <= 0 || val.length() > 11){
					JOptionPane.showMessageDialog(null, "CPF inválido!");
				} else {
					nomeLabel.setText("Hóspede: " + hos.getNome());

					
				}

				contentPane.updateUI();
				contentPane.add(nomeLabel);
			}
		});
		contentPane.add(btnBuscar);

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
		
	/*	JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValorTotal.setBounds(10, 404, 94, 22);
		contentPane.add(lblValorTotal);*/
		
		JLabel lblQuarto = new JLabel("Quarto:");
		lblQuarto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuarto.setBounds(470, 246, 62, 22);
		contentPane.add(lblQuarto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(UIManager.getColor("Button.focus"));
		btnCancelar.setBounds(582, 470, 112, 32);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo cancelar a reserva e retornar ao menu inicial?", "Cancelar Reserva", 0);
				if (resposta == 0) {
					JOptionPane.showMessageDialog(null, sis.cancelarReserva());
					dispose();
				}
			}
		});

		
		JFormattedTextField dataInicialCaixaDeTexto = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataInicialCaixaDeTexto.setBounds(114, 180, 207, 32);
		contentPane.add(dataInicialCaixaDeTexto);
		
		JFormattedTextField dataFinalCaixaDeTexto = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataFinalCaixaDeTexto.setBounds(547, 180, 207, 32);
		contentPane.add(dataFinalCaixaDeTexto);
		
		TipoDeQuarto[] tipos = sis.verTiposDeQuarto();

		JList tipoDeQuartoLista = new JList(tipos);
		//tipoDeQuartoLista.setListData(tipos);
		tipoDeQuartoLista.setBounds(154, 246, 167, 70);
		contentPane.add(tipoDeQuartoLista);
		
		tipoDeQuartoLista.addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent e){
				//System.out.println(tipoDeQuartoLista.getSelectedValue());

				String tipoDesejado = tipoDeQuartoLista.getSelectedValue().toString();

				TipoDeQuarto tipoDeQuartoDesejado = new TipoDeQuarto();
		
				for (TipoDeQuarto tipo : tipos) {

					if(tipo != null){
						//System.out.println(tipo.getDescricao());
						if((tipo.getDescricao()).equals(tipoDesejado)){
							tipoDeQuartoDesejado = tipo;
						}
					}
					
				
				}

				contentPane.updateUI();
				Quarto[] quartos = sis.verQuartosDisponiveis(tipoDeQuartoDesejado);
				JList quartoLista = new JList(quartos);
				quartoLista.setBounds(547, 246, 220, 70);
				contentPane.add(quartoLista);

				
				quartoLista.addListSelectionListener(new ListSelectionListener(){
					
					public void valueChanged(ListSelectionEvent e){
						//System.out.println(quartoLista.getSelectedValue().toString().substring(0, 1));
						
						String localizacao = quartoLista.getSelectedValue().toString().substring(13, 15);
						

						for (Quarto quarto : quartos) {							
							if(quarto != null){
								//System.out.println(quarto.getLocalizacao());
	
								if(quarto.getLocalizacao().equals(localizacao)){
									System.out.println(quarto.getLocalizacao());
									setQuarto(quarto);
								}
							}
							
							
						}

					}
				});
				
			}

			
		});
		
		
		/*JFormattedTextField valorTotalCaixaDeTexto = new JFormattedTextField();
		valorTotalCaixaDeTexto.setBounds(114, 402, 207, 32);
		contentPane.add(valorTotalCaixaDeTexto);*/


		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(UIManager.getColor("Button.focus"));
		btnConfirmar.setBounds(704, 470, 112, 32);
		btnConfirmar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("botao confirmar clicado");
				sis.confirmarReserva(cpfCaixaDeTexto.getText(), dataInicialCaixaDeTexto.getText(), dataFinalCaixaDeTexto.getText(), getQuarto());
				
				JOptionPane.showMessageDialog(contentPane, "Reserva realizada com sucesso!");
				dispose();
				
			}
		});
		contentPane.add(btnConfirmar);
	}


	public void setQuarto(Quarto quarto){
		this.quarto = quarto;
	}

	public Quarto getQuarto(){
		return this.quarto;
	}
}
