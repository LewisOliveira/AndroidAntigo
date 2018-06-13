package Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Banco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco";
    private static final int VERSAO = 1;

    public Banco (Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table if not exists usuario (idUsuario integer PRIMARY KEY autoincrement, nome text, email text," +
                " senha text," +
                "colecaoid integer," +
                "FOREIGN KEY(colecaoid) REFERENCES Colecao(idColecao));");

        db.execSQL("create table if not exists colecao (idColecao integer PRIMARY KEY autoincrement," +
                " tipo integer," +
                " descricao text,"+
                " edicaoid text," +
                "foreign key(edicaoid) references edicao(idEdicao));");

        db.execSQL("create table if not exists edicao (idEdicao integer PRIMARY KEY autoincrement," +
                " titulo text," +
                " editora text," +
                " licenciantes text," +
                " autores text," +
                " numeroEdicao integer," +
                " capaURL text," +
                " descricao text," +
                " isbn integer," +
                " anoPublicacaoBrasil integer," +
                " mesPublicacaoBrasil text," +
                " anoPublicacaoOriginal integer," +
                " mesPublicacaoOriginal text," +
                " rankingid integer," +
                "foreign key (rankingid) references ranking(idRanking));");

        db.execSQL("create table if not exists ranking (idRanking integer primary key autoincrement, nota integer," +
                "usuarioid integer," +
                "foreign key (usuarioid) references usuario(idUsuario));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }

    public void inserirUsuario(Users usuario){
        SQLiteDatabase db = getWritableDatabase();
        try {
        ContentValues valores = new ContentValues();
        valores.put("nome",usuario.getNome());
        valores.put("email",usuario.getEmail());
        valores.put("senha",usuario.getSenha());
        valores.put("colecaoid",usuario.getColecaoid());

        db.insert("usuario",null,valores);
        } finally {
            db.close();
        }
    }

    public void inserirColecao(Colecao colecao){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues valores = new ContentValues();

            valores.put("tipo",colecao.getTipo());
            valores.put("edicaoid",colecao.getEdicaoid());
            db.insert("colecao",null,valores);

        } finally {
            db.close();
        }
    }

    public void inserirEdicoes(){
        SQLiteDatabase db = getWritableDatabase();
        try {
            //Inserir Homem Aranha - O melhor
            db.execSQL("insert into edicao (titulo,editora,licenciante,numeroEdicao,capaURL,descricao,isbn,anoPublicacaoBrasil,mesPublicacaoBrasil," +
                    "anoPublicacaoOriginal,mesPublicacaoOriginal) values('Homem Aranha - O melhor','Abril','Marvel',4,'Todd Mcfarlane',1," +
                    "'https://http2.mlstatic.com/o-melhor-do-homem-aranha-ns-123-e-4-ed-abril-todd-D_NQ_NP_873911-MLB27041635026_032018-F.webp'," +
                    "'Melhores Historias do aranha por Todd Mcfarlane',1234567891, 1996, 'Dezembro', 1987, 'Março');");
            //Alias
            db.execSQL("insert into edicao (titulo,editora,licenciante,numeroEdicao,capaURL,descricao,isbn,anoPublicacaoBrasil,mesPublicacaoBrasil," +
                    "anoPublicacaoOriginal,mesPublicacaoOriginal) values('Alias', 'Panini', 'Marvel',5 ,'Brian Michael Bendis & Michael Gaydos', 1," +
                    "'https://www.bedetheque.com/media/Couvertures/Couv_25073.jpg'," +
                    "'Primeiro Volume Jessica Jones',9788573516,2018,'Janeiro',2001,'Novembro');");
            //Bidu - Caminhos
            db.execSQL("insert into edicao (titulo,editora,licenciante,numeroEdicao,capaURL,descricao,isbn,anoPublicacaoBrasil,mesPublicacaoBrasil," +
                    "anoPublicacaoOriginal,mesPublicacaoOriginal) values('Bidu - Caminhos','Panini','Mauricio de Souza Produções',1," +
                    "'Eduardo Damasceno & Luís Felipe Garrocho',1," +
                    "'https://images-na.ssl-images-amazon.com/images/I/51KZfL1BpBL._SX341_BO1,204,203,200_.jpg'," +
                    "'Graphic Novel sobre o Bidu',8583680264,2015,'Janeiro',2015,'Janeiro');");
            //Black Hole
            db.execSQL("insert into edicao (titulo,editora,licenciante,numeroEdicao,capaURL,descricao,isbn,anoPublicacaoBrasil,mesPublicacaoBrasil," +
                    "anoPublicacaoOriginal,mesPublicacaoOriginal) values('Black Hole','Darkside','Charles Burns',1,'Charles Burns',1" +
                    ",'https://images-na.ssl-images-amazon.com/images/I/51LXEBjs1IL._SX346_BO1,204,203,200_.jpg'," +
                    "'Graphic Novel completa do Charles Burns',8594540515,2017,'Outubro',2005,'Abril');");
            //Creepshow
            db.execSQL("insert into edicao (titulo,editora,licenciante,numeroEdicao,capaURL,descricao,isbn,anoPublicacaoBrasil,mesPublicacaoBrasil," +
                    "anoPublicacaoOriginal,mesPublicacaoOriginal) values('Creepshow','Darkside','Sem Licenciante',1,'Bernie Wrightson & Stephen King',1," +
                    "'Rhttp://www.darksidebooks.com.br/wp-content/themes/darkside/scripts/timthumb.php?src=http://www.darksidebooks.com.br/wp-content/uploads/2017/09/creepshow-capa-thumb.png&w=220&zc=1'," +
                    "'Homenagem aos quadrinhos dos anos 50',8594540639,2017,'Outubro',1982,'Novembro');");
            //Guardiões do Louvre
            db.execSQL("insert into edicao (titulo,editora,licenciante,numeroEdicao,capaURL,descricao,isbn,anoPublicacaoBrasil,mesPublicacaoBrasil," +
                    "anoPublicacaoOriginal,mesPublicacaoOriginal) values('Guardiões do Louvre','Pipoca & Nanquim','Louvre Éditions',1,'Jiro Taniguchi',1," +
                    "'https://images-na.ssl-images-amazon.com/images/I/61-pN3yWHPL.jpg'," +
                    "'Mangá originalmente lançado na frança', 'parte de um selo de quadrinhos do Louvre',9788593685,2018,'Abril',2014,'Novembro');");
            //Espadas e Bruxas
            db.execSQL("insert into edicao (titulo,editora,licenciante,numeroEdicao,capaURL,descricao,isbn,anoPublicacaoBrasil,mesPublicacaoBrasil," +
                    "anoPublicacaoOriginal,mesPublicacaoOriginal) values('Espadas e Bruxas','Pipoca & Nanquim','Esteban Maroto',1," +
                    "'Esteban Maroto',1,'https://images-na.ssl-images-amazon.com/images/I/61YtTBKGxOL.jpg'," +
                    "'Compilação dos contos de barbaro do Esteban Maroto',9788593650,2017,'Maio',2012,'Setembro');");
            //Lavagem
            db.execSQL("insert into edicao (titulo,editora,licenciante,numeroEdicao,capaURL,descricao,isbn,anoPublicacaoBrasil,mesPublicacaoBrasil," +
                    "anoPublicacaoOriginal,mesPublicacaoOriginal) values('Lavagem','Mino','Shiko',1,'Shiko',1," +
                    "'https://itibancomics.files.wordpress.com/2015/04/capa-01.jpg'," +
                    "'Publicação do Ilustrador Shiko',8569032005,2015,'Abril',2015,'Abril');");

            /*

            //Inserir Homem Aranha - O melhor
            db.execSQL("insert into edicao values('Homem Aranha - O melhor','Abril','Marvel','Todd Mcfarlane',4," +
                    "'https://http2.mlstatic.com/o-melhor-do-homem-aranha-ns-123-e-4-ed-abril-todd-D_NQ_NP_873911-MLB27041635026_032018-F.webp'," +
                    "'Melhores Historias do aranha por Todd Mcfarlane',12345678912345, 1996, 'Dezembro', 1987, 'Março')");
            //Alias
            db.execSQL("insert into edicao values('Alias', 'Panini', 'Marvel','Brian Michael Bendis & Michael Gaydos', 5," +
                    "'https://www.bedetheque.com/media/Couvertures/Couv_25073.jpg'," +
                    "'Primeiro Volume Jessica Jones',9788573516777,2018,'Janeiro',2001,'Novembro')");
            //Bidu - Caminhos
            db.execSQL("insert into edicao values('Bidu - Caminhos','Panini','Mauricio de Souza Produções','Eduardo Damasceno & Luís Felipe Garrocho',1" +
                    ",'https://images-na.ssl-images-amazon.com/images/I/51KZfL1BpBL._SX341_BO1,204,203,200_.jpg'," +
                    "'Graphic Novel sobre o Bidu',8583680264,2015,'Janeiro',2015,'Janeiro')");
            //Black Hole
            db.execSQL("insert into edicao values('Black Hole','Darkside','Charles Burns','Charles Burns',1" +
                    ",'https://images-na.ssl-images-amazon.com/images/I/51LXEBjs1IL._SX346_BO1,204,203,200_.jpg'," +
                    "'Graphic Novel completa do Charles Burns',8594540515,2017,'Outubro',2005,'Abril')");
            //Creepshow
            db.execSQL("insert into edicao values('Creepshow','Darkside','Sem Licenciante','Bernie Wrightson & Stephen King',1," +
                    "'Rhttp://www.darksidebooks.com.br/wp-content/themes/darkside/scripts/timthumb.php?src=http://www.darksidebooks.com.br/wp-content/uploads/2017/09/creepshow-capa-thumb.png&w=220&zc=1'," +
                    "'Homenagem aos quadrinhos dos anos 50',8594540639,2017,'Outubro',1982,'Novembro')");
            //Guardiões do Louvre
            db.execSQL("insert into edicao values('Guardiões do Louvre','Pipoca & Nanquim','Louvre Éditions','Jiro Taniguchi',1," +
                    "'https://images-na.ssl-images-amazon.com/images/I/61-pN3yWHPL.jpg'," +
                    "'Mangá originalmente lançado na frança', 'parte de um selo de quadrinhos do Louvre',9788593685094,2018,'Abril',2014,'Novembro')");
            //Espadas e Bruxas
            db.execSQL("insert into edicao values('Espadas e Bruxas','Pipoca & Nanquim','Esteban Maroto'," +
                    "'Esteban Maroto',1,'https://images-na.ssl-images-amazon.com/images/I/61YtTBKGxOL.jpg'," +
                    "'Compilação dos contos de barbaro do Esteban Maroto',978859365001,2017,'Maio',2012,'Setembro')");
            //Lavagem
            db.execSQL("insert into edicao values('Lavagem','Mino','Shiko','Shiko',1," +
                    "'https://itibancomics.files.wordpress.com/2015/04/capa-01.jpg'," +
                    "'Publicação do Ilustrador Shiko',8569032005,2015,'Abril',2015,'Abril')");
            */
        }
        finally {
            db.close();
        }
    }

    public void inserirEdicao(){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues valores = new ContentValues();

            valores.put("titulo","Homem Aranha - O melhor");
            valores.put("editora","Abril");
            valores.put("licenciante","Marvel");
            valores.put("autores","Todd Mcfarlane");
            valores.put("numeroEdicao",4);
            valores.put("capa","https://http2.mlstatic.com/o-melhor-do-homem-aranha-ns-123-e-4-ed-abril-todd-D_NQ_NP_873911-MLB27041635026_032018-F.webp");
            valores.put("descricao","Melhores Historias do aranha por Todd Mcfarlane");
            valores.put("isbn",1234);
            valores.put("anoPublicacaoBrasil",1996);
            valores.put("mesPublicacaoBrasil","Dezembro");
            valores.put("anoPublicacaoOriginal",1987);
            valores.put("mesPublicacaoOriginal","Março");
            //valores.put("rankingid",edicao.getRankingid());

            db.insert("edicao",null,valores);
        } finally {
            db.close();
        }
    }

    public void inserirRanking(Rating ranking){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues valores = new ContentValues();
            valores.put("nota", ranking.getNota());
            valores.put("usuarioid",ranking.getUsuario());

            db.insert("ranking",null,valores);
        } finally {
            db.close();
        }
    }
    public ArrayList<Users> ListaUsuarios(){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Users> lista = new ArrayList<Users>();
        try{

            Cursor c = db.rawQuery("select * from usuario",null);

            if(c.getCount()>0){
                c.moveToFirst();
                do{
                    Users u = new Users();
                    u.setId(c.getLong(0));
                    u.setNome(c.getString(1));
                    u.setEmail(c.getString(2));
                    u.setSenha(c.getString(3));
                    u.setColecaoid(c.getLong(4));
                    lista.add(u);
                }while (c.moveToNext());
            }
            c.close();
        }
        finally {
            db.close();
        }
        return lista;
    }

    public ArrayList<Colecao> ListaColecao(){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Colecao> lista = new ArrayList<>();
        try{

            Cursor c = db.rawQuery("select * from colecao",null);

            if(c.getCount()>0){
                c.moveToFirst();
                do{
                    Colecao col = new Colecao();
                    col.setId(c.getLong(0));
                    col.setTipo(c.getLong(1));
                    //O index 2 é pra descrição.
                    col.setEdicaoid(c.getLong(3));
                    lista.add(col);
                }while (c.moveToNext());
            }
            c.close();
        }
        finally {
            db.close();
        }
        return lista;
    }

    public ArrayList<Edicao> ListaEdicao(){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Edicao> lista = new ArrayList<>();
        try{

            Cursor c = db.rawQuery("select * from edicao",null);

            if(c.getCount()>0){
                c.moveToFirst();
                do{
                    Edicao edt = new Edicao();

                    edt.setId(c.getInt(0));
                    edt.setTitulo(c.getString(1));
                    edt.setEditora(c.getString(2));
                    edt.setLicenciante(c.getString(3));
                    edt.setAutores(c.getString(4));
                    edt.setNumeroEdicao(c.getInt(5));
                    edt.setCapa(c.getString(6));
                    edt.setDescricao(c.getString(7));
                    edt.setISBN(c.getInt(8));
                    edt.setAnoPublicacaoBrasil(c.getInt(9));
                    edt.setMesPublicacaoBrasil(c.getString(10));
                    edt.setAnoPublicacaoOriginal(c.getInt(11));
                    edt.setMesPublicacaoOriginal(c.getString(12));

                    lista.add(edt);
                }while (c.moveToNext());
            }
            c.close();
        }
        finally {
            db.close();
        }
        return lista;
    }
/*
    public ArrayList<Edicao> naColecao(Colecao colecao){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Colecao> listaColecao = ListaColecao();
        ArrayList<Edicao> listaEdicao = new ArrayList<>();
        try{

            Cursor c = db.rawQuery("select * from edicao where tipo like 'Minha Colecao'",null);

            if(c.getCount()>0){
                c.moveToFirst();
                do{
                    Users u = new Users();
                    u.setId(c.getLong(0));
                    u.setNome(c.getString(1));
                    u.setEmail(c.getString(2));
                    u.setSenha(c.getString(3));
                    lista.add(u);
                }while (c.moveToNext());
            }
            c.close();
        }
        finally {
            db.close();
        }
        return lista;
    }
    public ArrayList<Edicao> naoGostei(){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Users> lista = new ArrayList<Users>();
        try{

            Cursor c = db.rawQuery("select * from edicao",null);

            if(c.getCount()>0){
                c.moveToFirst();
                do{
                    Users u = new Users();
                    u.setId(c.getLong(0));
                    u.setNome(c.getString(1));
                    u.setEmail(c.getString(2));
                    u.setSenha(c.getString(3));
                    lista.add(u);
                }while (c.moveToNext());
            }
            c.close();
        }
        finally {
            db.close();
        }
        return lista;
    }
    public ArrayList<Edicao> queroTer(){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Users> lista = new ArrayList<Users>();
        try{

            Cursor c = db.rawQuery("select * from edicao",null);

            if(c.getCount()>0){
                c.moveToFirst();
                do{
                    Users u = new Users();
                    u.setId(c.getLong(0));
                    u.setNome(c.getString(1));
                    u.setEmail(c.getString(2));
                    u.setSenha(c.getString(3));
                    lista.add(u);
                }while (c.moveToNext());
            }
            c.close();
        }
        finally {
            db.close();
        }
        return lista;
    }
    */
}