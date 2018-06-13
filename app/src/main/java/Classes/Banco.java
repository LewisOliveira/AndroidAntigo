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
                " autores text," +
                " numeroEdicao integer," +
                " capa integer," +
                " descricao text," +
                " isbn integer," +
                " anoPublicacaoBrasil integer," +
                " mesPublicacaoBrasil text," +
                " anoPublicacaoOriginal integer," +
                " mesPublicacaoOriginal text," +
                " titulo text," +
                " editora text," +
                " licenciantes text," +
                //" quadrinhoid integer," +
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

    public void inserirEdicao(Edicao edicao){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues valores = new ContentValues();
            valores.put("autores",edicao.getAutores());
            valores.put("numeroEdicao",edicao.getNumeroEdicao());
            valores.put("capa",edicao.getCapa());
            valores.put("descricao",edicao.getDescricao());
            valores.put("isbn",edicao.getISBN());
            valores.put("anoPublicacaoBrasil",edicao.getAnoPublicacaoBrasil());
            valores.put("mesPublicacaoBrasil",edicao.getMesPublicacaoBrasil());
            valores.put("anoPublicacaoOriginal",edicao.getAnoPublicacaoOriginal());
            valores.put("mesPublicacaoOriginal",edicao.getMesPublicacaoOriginal());
            valores.put("titulo",edicao.getTitulo());
            valores.put("editora",edicao.getEditora());
            valores.put("licenciante",edicao.getLicenciante());
            valores.put("rankingid",edicao.getRankingid());

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
/*
    public Users identificaColecao(Users usuario, String pTipo){
        ArrayList<Users> listaU = ListaUsuarios();
        ArrayList<Colecao> listaC = ListaColecao();

        for (int i = 0; i < listaU.size(); i++) {
            for (int j = 0; j < listaC.size(); j++) {
                if ((listaU.get(i).getColecaoid() == listaC.get(i).getId()));
                    return listaU.get(i);
            }
        }
        return null;
    }

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