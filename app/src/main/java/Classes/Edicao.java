package Classes;

public class Edicao extends Quadrinhos {
    private int id;
    private String autores;
    private int numeroEdicao;
    private String capa;
    private String descricao;
    private long ISBN;
    private int anoPublicacaoBrasil;
    private String mesPublicacaoBrasil;
    private int anoPublicacaoOriginal;
    private String mesPublicacaoOriginal;
    private int rankingid;
/*
    public void addRating(Rating newRating) {
        if (rating.isEmpty()) {
            this.rating.add(newRating);
            return;
        }
        for (int i = 0; i < this.rating.size(); i++) {
            if (this.rating.get(i).getUsuario().getEmail().equals(newRating.getUsuario().getEmail())) {
                this.rating.get(i).setNota(newRating.getNota());
                return;
            }
        }
        this.rating.add(newRating);
    }

    public float getMediaRating() {
        float soma = 0;
        for (int i = 0; i < this.rating.size(); i++) {
            soma = (float) soma + this.rating.get(i).getNota();
        }

        if (soma == 0) {
            return 0;
        }

        float media = (float) soma / this.rating.size();
        return media;
    }
*/
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getLicenciante() {
        return licenciante;
    }

    public void setLicenciante(String licenciante) {
        this.licenciante = licenciante;
    }

    public String getAutores(){
        return autores;
    }

    public void setAutores(String autores){
        this.autores = autores;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public int getAnoPublicacaoBrasil() {
        return anoPublicacaoBrasil;
    }

    public void setAnoPublicacaoBrasil(int anoPublicacaoBrasil) {
        this.anoPublicacaoBrasil = anoPublicacaoBrasil;
    }

    public String getMesPublicacaoBrasil() {
        return mesPublicacaoBrasil;
    }

    public void setMesPublicacaoBrasil(String mesPublicacaoBrasil) {
        this.mesPublicacaoBrasil = mesPublicacaoBrasil;
    }

    public int getAnoPublicacaoOriginal() {
        return anoPublicacaoOriginal;
    }

    public void setAnoPublicacaoOriginal(int anoPublicacaoOriginal) {
        this.anoPublicacaoOriginal = anoPublicacaoOriginal;
    }

    public String getMesPublicacaoOriginal() {
        return mesPublicacaoOriginal;
    }

    public void setMesPublicacaoOriginal(String mesPublicacaoOriginal) {
        this.mesPublicacaoOriginal = mesPublicacaoOriginal;
    }

    public int getRankingid(){
        return rankingid;
    }

    public void setRankingid(int rankingid){
        this.rankingid = rankingid;
    }
}
