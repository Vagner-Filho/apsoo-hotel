package hospedagemhotel.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import java.awt.event.*;    

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.ComponentInputMap;

import hospedagemhotel.controller.Sistema;
import hospedagemhotel.model.Quarto;
import hospedagemhotel.model.TipoDeQuarto;

public class realizarReserva extends JFrame {

	private JPanel contentPane;
	private ArrayList<Quarto>  quartos = new ArrayList<Quarto>();

	Sistema sis = new Sistema();


	/**
	 * Create the frame.
	 * @throws ParseException 
	*/
	public realizarReserva(String cpfHospede) throws ParseException {
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
		
		/*JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cpfLabel.setBounds(10, 126, 36, 13);
		contentPane.add(cpfLabel);*/
		
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
				sis.cancelarReserva();
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
				if(e.getValueIsAdjusting()){
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
		
					
					int y = 246;
					

					for (Quarto quarto : quartos){
						if(quarto != null){
							JCheckBox cb = new JCheckBox(quarto.toString());
							cb.setToolTipText(quarto.getLocalizacao());
							cb.setBounds(547, y, 250, 30);
							y += 30;
							contentPane.add(cb);

							cb.addItemListener(new ItemListener() {    
								public void itemStateChanged(ItemEvent e) {                 
									System.out.println("quarto escolhido");
							
									String localizacao = cb.getToolTipText();
		
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
						
					}
					
				}
				
				
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
				
				sis.confirmarReserva(cpfHospede, dataInicialCaixaDeTexto.getText(), dataFinalCaixaDeTexto.getText(), getQuarto());

				
				JOptionPane.showMessageDialog(contentPane, "Reserva realizada com sucesso!");
			
				
				
			}
		});
		contentPane.add(btnConfirmar);
	}


	public ArrayList<Quarto> getQuarto() {
		return quartos;
	}	
	
	public void setQuarto(Quarto quarto) {
		quartos.add(quarto);
	}
}

