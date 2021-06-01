package hospedagemhotel.entidades;

public class Hospedagem {
    private Date data;
    private int horario;

    public Hospedagem(Date data, int horario) {
        setData(data);
        setHorario(horario);
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
}
