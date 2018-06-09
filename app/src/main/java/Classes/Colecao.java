package Classes;

import java.util.ArrayList;

public class Colecao {
    private ArrayList<Edicao> colecao;
    private ArrayList<Edicao> naoGostei;
    private ArrayList<Edicao> queroTer;

    public Colecao(){
        this.colecao = new ArrayList<Edicao>();
        this.naoGostei = new ArrayList<Edicao>();
        this.queroTer = new ArrayList<Edicao>();
    }
    //oi
    public ArrayList<Edicao> getColecao() {
        return colecao;
    }

    public void setColecao(ArrayList<Edicao> colecao) {
        this.colecao = colecao;
    }

    public ArrayList<Edicao> getNaoGostei() {
        return naoGostei;
    }

    public void setNaoGostei(ArrayList<Edicao> naoGostei) {
        this.naoGostei = naoGostei;
    }

    public ArrayList<Edicao> getQueroTer() {
        return queroTer;
    }

    public void setQueroTer(ArrayList<Edicao> queroTer) {
        this.queroTer = queroTer;
    }

    public boolean naColecao(String titulo, int numeroEdicao){
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
    }
}
