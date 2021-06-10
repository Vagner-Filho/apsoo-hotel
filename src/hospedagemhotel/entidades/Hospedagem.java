package hospedagemhotel.entidades;


public class Hospedagem {
    public Date data;
    private int horario;
    private Funcionario funcionario;
    private Reserva reserva;

	public Hospedagem(Date data, int horario, Reserva reserva, Funcionario funcionario) {
        setData(data);
        setHorario(horario);
        setFuncionario(funcionario);
        setReserva(reserva);
    }


	public void setData(Date data) {
        this.data = data;
    }
    
    public Date getData() {
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
