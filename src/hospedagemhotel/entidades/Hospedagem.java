package hospedagemhotel.entidades;

import java.util.ArrayList;

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
        this.data = new Date(data.getDia(), data.getMes(), data.getAno());
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
		this.funcionario = new Funcionario(funcionario.getNome(), funcionario.getCpf(), funcionario.getTelefone(),
				funcionario.getDataNasc(), funcionario.getEndereco(), funcionario.getLogin(), 
				funcionario.getSenha(), funcionario.getSalario(), funcionario.getCargo());
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = new Reserva(reserva.getIdReserva(), reserva.getHospede(), reserva.getFuncionario(), 
				reserva.getQuarto(), reserva.getDataInicial(), reserva.getDataFinal());
	}
	
	
	
}
