package hospedagemhotel.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospedagemhotel.model.Hospede;
import hospedagemhotel.persistencia.Conexao;
import hospedagemhotel.model.Reserva;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class realizarCheckin extends JFrame {

    private JPanel contentPane;
    private JTable tabelaReserva;

    /**
     * Create the frame.
     * 
     * @throws ParseException
     */
    public realizarCheckin() throws ParseException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 850, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(126, 208, 255));
        contentPane.setForeground(new Color(0, 0, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCheckin = new JLabel("CHECK-IN");
        lblCheckin.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblCheckin.setBounds(356, 22, 116, 32);
        contentPane.add(lblCheckin);

        JLabel lblCPF1 = new JLabel("CPF:");
        lblCPF1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCPF1.setBounds(10, 72, 36, 13);
        contentPane.add(lblCPF1);

        JFormattedTextField caixaDeTextoCPF = new JFormattedTextField();
        caixaDeTextoCPF.setBounds(56, 65, 265, 32);
        contentPane.add(caixaDeTextoCPF);

        JButton btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBackground(Color.BLACK);
        btnBuscar.setBounds(333, 65, 112, 32);
        btnBuscar.addActionListener(new ActionListener() {
            Hospede hos = new Hospede();

            public void actionPerformed(ActionEvent e) {

                Conexao con = new Conexao();

                hos = con.buscarHospede(caixaDeTextoCPF.getText());

                contentPane.updateUI();

                JFormattedTextField Nomeftf = new JFormattedTextField(hos.getNome());
                Nomeftf.setEditable(false);
                Nomeftf.setBounds(93, 120, 709, 32);
                contentPane.add(Nomeftf);

                JLabel lblNome = new JLabel("Nome:");
                lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblNome.setBounds(10, 130, 52, 22);
                contentPane.add(lblNome);

                JLabel lblCPF2 = new JLabel("CPF:");
                lblCPF2.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblCPF2.setBounds(10, 174, 52, 22);
                contentPane.add(lblCPF2);

                JLabel lblCEP = new JLabel("CEP:");
                lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblCEP.setBounds(10, 218, 52, 22);
                contentPane.add(lblCEP);

                JFormattedTextField CPFftf = new JFormattedTextField(hos.getCpf());
                CPFftf.setEditable(false);
                CPFftf.setBounds(93, 163, 249, 32);
                contentPane.add(CPFftf);

                JFormattedTextField CEPftf = new JFormattedTextField(hos.getEndereco().getCep());
                CEPftf.setEditable(false);
                CEPftf.setBounds(93, 208, 249, 32);
                contentPane.add(CEPftf);

                JFormattedTextField Ruaftf = new JFormattedTextField(hos.getEndereco().getRua());
                Ruaftf.setEditable(false);
                Ruaftf.setBounds(93, 251, 355, 32);
                contentPane.add(Ruaftf);

                JLabel lblRua = new JLabel("Rua:");
                lblRua.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblRua.setBounds(10, 261, 52, 22);
                contentPane.add(lblRua);

                JLabel lblCompl = new JLabel("Compl.:");
                lblCompl.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblCompl.setBounds(10, 303, 66, 22);
                contentPane.add(lblCompl);

                JFormattedTextField Complftf = new JFormattedTextField(hos.getEndereco().getComplemento());
                Complftf.setEditable(false);
                Complftf.setBounds(93, 294, 709, 32);
                contentPane.add(Complftf);

                JLabel lblTelefone = new JLabel("Telefone:");
                lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblTelefone.setBounds(10, 347, 74, 22);
                contentPane.add(lblTelefone);

                JFormattedTextField Telefoneftf = new JFormattedTextField(hos.getTelefone());
                Telefoneftf.setEditable(false);
                Telefoneftf.setBounds(93, 337, 292, 32);
                contentPane.add(Telefoneftf);

                JLabel lblDataDeNasc = new JLabel("Data de Nasc.:");
                lblDataDeNasc.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblDataDeNasc.setBounds(10, 389, 116, 22);
                contentPane.add(lblDataDeNasc);

                JFormattedTextField DataDeNascftf = new JFormattedTextField(hos.getDataNasc());
                DataDeNascftf.setEditable(false);
                DataDeNascftf.setBounds(136, 380, 249, 32);
                contentPane.add(DataDeNascftf);

                JFormattedTextField Numftf = new JFormattedTextField(hos.getEndereco().getNumero());
                Numftf.setEditable(false);
                Numftf.setBounds(400, 208, 96, 32);
                contentPane.add(Numftf);

                JLabel lblNumero = new JLabel("N\u00BA:");
                lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblNumero.setBounds(356, 216, 36, 22);
                contentPane.add(lblNumero);

                JLabel lblUF = new JLabel("UF:");
                lblUF.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblUF.setBounds(506, 216, 36, 22);
                contentPane.add(lblUF);

                JFormattedTextField UFftf = new JFormattedTextField(hos.getEndereco().getEstado());
                UFftf.setEditable(false);
                UFftf.setBounds(543, 208, 96, 32);
                contentPane.add(UFftf);

                JLabel lblSexo = new JLabel("Sexo:");
                lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblSexo.setBounds(649, 216, 52, 22);
                contentPane.add(lblSexo);

                JFormattedTextField Sexoftf = new JFormattedTextField(hos.getSexo());
                Sexoftf.setEditable(false);
                Sexoftf.setBounds(706, 208, 96, 32);
                contentPane.add(Sexoftf);

                JLabel lblBairro = new JLabel("Bairro:");
                lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblBairro.setBounds(459, 261, 52, 22);
                contentPane.add(lblBairro);

                JFormattedTextField Bairroftf = new JFormattedTextField(hos.getEndereco().getBairro());
                Bairroftf.setEditable(false);
                Bairroftf.setBounds(516, 251, 286, 32);
                contentPane.add(Bairroftf);

                JButton btnCancelar = new JButton("CANCELAR");
                btnCancelar.setBackground(Color.BLACK);
                btnCancelar.setBounds(568, 618, 112, 32);
                contentPane.add(btnCancelar);

                JButton btnConfirmar = new JButton("CONFIRMAR");
                btnConfirmar.setBackground(Color.BLACK);
                btnConfirmar.setBounds(690, 618, 112, 32);
                contentPane.add(btnConfirmar);

                JLabel lblReservas = new JLabel("RESERVAS:");
                lblReservas.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblReservas.setBounds(10, 427, 96, 22);
                contentPane.add(lblReservas);

                JList tabelaReserva = new JList();
                tabelaReserva.setBounds(10, 460, 792, 147);
                contentPane.add(tabelaReserva);
				
            }
        });
        contentPane.add(btnBuscar);
    }
}