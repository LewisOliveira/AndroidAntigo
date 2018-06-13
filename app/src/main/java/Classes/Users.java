package Classes;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Objects;

public class Users {
    private long id;
    private String nome;
    private String email;
    private String senha;
    private long colecaoid;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public long getColecaoid(){
        return colecaoid;
    }
    public void setColecaoid(long colecaoid){
        this.colecaoid = colecaoid;
    }

    public Edicao procuraArrayEdicao(ArrayList<Edicao> edicoes, String titulo, int numeroEdicao) {
        for (int i = 0; i < edicoes.size(); i++) {
            if ((edicoes.get(i).getTitulo().equals(titulo)) && (edicoes.get(i).getNumeroEdicao() == numeroEdicao)) {
                return edicoes.get(i);
            }
        }
        return null;
    }
/*
    public boolean insereQuadrinhoColecao(Edicao edicao){
        this.colecao.getColecao().add(edicao);
        return true;
    }

    public boolean insereQuadrinhoColecao(ArrayList<Edicao> edicoes, String titulo,int numeroEdicao){
        Edicao editarEdicao = this.procuraArrayEdicao(edicoes,titulo,numeroEdicao);
        if(editarEdicao != null) {
            this.colecao.getColecao().add(editarEdicao);
            if (this.colecao.naQueroTer(titulo,numeroEdicao))
                this.colecao.getQueroTer().remove(editarEdicao);
            return true;
        }
        return false;
    }

    public boolean insereQuadrinhosNaoGostei(ArrayList<Edicao> edicoes, String titulo, int numeroEdicao){
        Edicao editarEdicao = this.procuraArrayEdicao(edicoes,titulo,numeroEdicao);
        if(editarEdicao != null){
            this.colecao.getNaoGostei().add(editarEdicao);
            return true;
        }
        return false;
    }

    public boolean insereQuadrinhosQueroTer(ArrayList<Edicao> edicoes, String titulo, int numeroEdicao){
        Edicao editarEdicao = this.procuraArrayEdicao(edicoes,titulo,numeroEdicao);
        if((editarEdicao != null) && !this.colecao.naColecao(titulo,numeroEdicao)){
            this.colecao.getQueroTer().add(editarEdicao);
            return true;
        }
        return false;
    }

    public boolean removerQuadrinhoColecao(String titulo, int numeroEdicao){
        for(int i = 0; i < this.colecao.getColecao().size(); i++){
            if((this.colecao.getColecao().get(i).getTitulo() == titulo) && (this.colecao.getColecao().get(i).getNumeroEdicao() == numeroEdicao)) {
                this.colecao.getColecao().remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removerQuadrinhoNaoGostei(String titulo, int numeroEdicao){
        for(int i = 0; i < this.colecao.getNaoGostei().size(); i++){
            if((this.colecao.getNaoGostei().get(i).getTitulo() == titulo) && this.colecao.getNaoGostei().get(i).getNumeroEdicao() == numeroEdicao){
                this.colecao.getNaoGostei().remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removerQuadrinhosQueroTer(String titulo, int numeroEdicao){
        for(int i = 0; i < this.colecao.getQueroTer().size(); i++){
            if((this.colecao.getQueroTer().get(i).getTitulo() == titulo) && (this.colecao.getQueroTer().get(i).getNumeroEdicao() == numeroEdicao)){
                this.colecao.getQueroTer().remove(i);
                return true;
            }
        }
        return false;
    }
    */

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Users))
            return false;

        Users users = (Users) o;
        if(!Objects.equals(this.email, users.email))
            return false;
        return true;
    }


}

