package Classes;

        import com.example.pc.hqapp.R;

        import java.util.ArrayList;

public class Edicao extends Quadrinhos {
    private String autores;
    private int numeroEdicao;
    private int capa;
    private String descricao;
    private long ISBN;
    private int anoPublicacaoBrasil;
    private String mesPublicacaoBrasil;
    private int anoPublicacaoOriginal;
    private String mesPublicacaoOriginal;
    private ArrayList<Rating> rating;


    public Edicao(String titulo, String editora, String licenciante, int totalEdicoes, String autores, int numeroEdicao, int capa, String descricao, long ISBN, int anoPublicacaoBrasil, String mesPublicacaoBrasil, int anoPublicacaoOriginal, String mesPublicacaoOriginal) {
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.licenciante = licenciante;
        this.numeroEdicao = numeroEdicao;
        this.capa = capa;
        this.descricao = descricao;
        this.ISBN = ISBN;
        this.anoPublicacaoBrasil = anoPublicacaoBrasil;
        this.mesPublicacaoBrasil = mesPublicacaoBrasil;
        this.anoPublicacaoOriginal = anoPublicacaoOriginal;
        this.mesPublicacaoOriginal = mesPublicacaoOriginal;
        rating = new ArrayList<Rating>();
    }



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

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    public int getCapa() {
        return capa;
    }

    public void setCapa(int capa) {
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

    public static Edicao edicaoNova = new Edicao("Homem Aranha - O melhor","Abril","Marvel",4,"Todd Mcfarlane",1,R.mipmap.imagem1,"Melhores Historias do aranha por Todd Mcfarlane",12345678912345L, 1996, "Dezembro", 1987, "Março");
    public Edicao edicaoNova2 = new Edicao("Alias", "Panini", "Marvel",  5,"Brian Michael Bendis & Michael Gaydos",  1, R.mipmap.imagem2, "Primeiro Volume Jessica Jones",9788573516777L , 2018, "Janeiro", 2001, "Novembro");
    public Edicao edicaoNova3 = new Edicao("Bidu - Caminhos","Panini","Mauricio de Souza Produções",1,"Eduardo Damasceno & Luís Felipe Garrocho",1,R.mipmap.imagem3,"Graphic Novel sobre o Bidu",8583680264L,2015,"Janeiro",2015,"Janeiro");
    public Edicao edicaoNova4 = new Edicao("Black Hole","Darkside","Charles Burns",1,"Charles Burns",1,R.mipmap.imagem4,"Graphic Novel completa do Charles Burns",8594540515L,2017,"Outubro",2005,"Abril");
    public Edicao edicaoNova5 = new Edicao("Creepshow","Darkside","Sem Licenciante",1,"Bernie Wrightson & Stephen King",1,R.mipmap.imagem5,"Homenagem aos quadrinhos dos anos 50",8594540639L,2017,"Outubro",1982,"Novembro");
    public Edicao edicaoNova6 = new Edicao("Guardiões do Louvre","Pipoca & Nanquim","Louvre Éditions",1,"Jiro Taniguchi",1,R.mipmap.imagem6,"Mangá originalmente lançado na frança, parte de um selo de quadrinhos do Louvre",9788593685094L,2018,"Abril",2014,"Novembro");
    public Edicao edicaoNova7 = new Edicao("Espadas e Bruxas","Pipoca & Nanquim","Esteban Maroto",1,"Esteban Maroto",1,R.mipmap.imagem7,"Compilação dos contos de barbaro do Esteban Maroto",978859365001L,2017,"Maio",2012,"Setembro");
    public Edicao edicaoNova8 = new Edicao("Lavagem","Mino","Shiko",1,"Shiko",1,R.mipmap.imagem8,"Publicação do Ilustrador Shiko",8569032005L,2015,"Abril",2015,"Abril");
}
