package Classes;

public class Colecao {
    private long id;
    private long tipo;
    private String descricao;
    private long edicaoid;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public long getTipo(){
        return tipo;
    }
    public  void setTipo(long tipo){
        this.tipo = tipo;
    }

    public  String getDescricao(){
        if(getTipo() == 1)
            return "Minha Coleção";
        else if(getTipo() == 2)
            return "Não Gostei";
        else if(getTipo() == 3)
            return "Quero Ter";
        else
            return "Tipo inválido";
    }

    public long getEdicaoid(){
        return edicaoid;
    }
    public void setEdicaoid(long edicaoid){
        this.edicaoid = edicaoid;
    }

    /*public boolean naColecao(String titulo, int numeroEdicao){
        for(int i = 0; i< this.colecao.size(); i++){
            if((this.colecao.get(i).getTitulo() == titulo) && (this.colecao.get(i).getNumeroEdicao() == numeroEdicao))
                return true;
        }
        return false;
    }

    public boolean naQueroTer(String titulo, int numeroEdicao){
        for(int i = 0; i< this.queroTer.size(); i++){
            if((this.queroTer.get(i).getTitulo() == titulo) && (this.queroTer.get(i).getNumeroEdicao() == numeroEdicao))
                return true;
        }
        return false;
    }

    public boolean naNaoGostei(String titulo, int numeroEdicao){
        for(int i = 0; i< this.naoGostei.size(); i++){
            if((this.naoGostei.get(i).getTitulo() == titulo) && (this.naoGostei.get(i).getNumeroEdicao() == numeroEdicao))
                return true;
        }
        return false;
    }*/
}
