package hospedagemhotel.model;

import hospedagemhotel.controller.Sistema;

public class Hospedagem {
	private int idHospedagem;
    private String data;
    private String horario;
    private Funcionario funcionario;
    private Reserva reserva;

    public Hospedagem(){
		Sistema sis = new Sistema();
		setIdHospedagem(sis.numeroAleatorio());
	}
    
	public Hospedagem(String data, String horario, Funcionario funcionario, Reserva reserva) {
        setData(data);
        setHorario(horario);
        setFuncionario(funcionario);
        setReserva(reserva);
        Sistema sis = new Sistema();
		setIdHospedagem(sis.numeroAleatorio());
    }


	public int getIdHospedagem() {
		return idHospedagem;
	}

	public void setIdHospedagem(int idHospedagem) {
		this.idHospedagem = idHospedagem;
	}

	public void setData(String data) {
        this.data = data;
    }
    
    public String getData() {
        return data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }
    
    public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	
}
