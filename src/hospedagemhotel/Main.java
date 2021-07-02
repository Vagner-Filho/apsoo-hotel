package hospedagemhotel;

import java.awt.EventQueue;


import hospedagemhotel.persistencia.Conexao;

import hospedagemhotel.view.telaMenu;


public class Main {
	
    public static void main(String[] args) {

		
		Conexao.InitBD();
		
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
}