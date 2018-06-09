package Classes;

public class Rating {
    private Users usuario;
    private int nota;

    public Rating(Users usuario,int nota){
        this.usuario = usuario;
        this.nota = nota;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


}
