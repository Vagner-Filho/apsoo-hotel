package hospedagemhotel.entidades;


public class Hospedagem {
    public String data;
    private int horario;
    private Funcionario funcionario;
    private Reserva reserva;

	public Hospedagem(String data, int horario, Reserva reserva, Funcionario funcionario) {
        setData(data);
        setHorario(horario);
        setFuncionario(funcionario);
        setReserva(reserva);
    }


	public void setData(String data) {
        this.data = data;
    }
    
    public String getData() {
        return data;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getHorario() {
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
