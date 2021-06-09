package hospedagemhotel.entidades;

public class Hospedagem {
    private Date data;
    private int horario;
    private Funcionario funcionario;
    private Reserva reserva;
    
    //Arrumar
    public Hospedagem(int dia, int mes, int ano, int horario, Funcionario funcionario, Reserva reserva) {
        setData(dia, mes, ano);
        setHorario(horario);
        setFuncionario(funcionario);
        setReserva(reserva);
    }

    public void setData(int dia, int mes, int ano) {
        data = new Date(dia, mes, ano);
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

	//Arrumar
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Reserva getReserva() {
		return reserva;
	}
	
	//Arrumar
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
    
    
}
