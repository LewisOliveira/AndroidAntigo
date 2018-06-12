package Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Banco extends SQLiteOpenHelper {
    //private static final String TAG = "SQL";
    private static final String NOME_BANCO = "banco";
    private static final int VERSAO = 1;

    public Banco (Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Log.d(TAG, "Criação de tabela");

        db.execSQL("create table if not exists usuario (idUsuario integer PRIMARY KEY autoincrement, nome text, email text," +
                " senha text," +
                "colecaoid integer," +
                "FOREIGN KEY(colecaoid) REFERENCES Colecao(idColecao));");

        db.execSQL("create table if not exists colecao (idColecao integer PRIMARY KEY autoincrement," +
                " tipo text," +
                " edicaoid text," +
                "foreign key(edicaoid) references edicao(idEdicao));");

        db.execSQL("create table if not exists edicao (idEdicao integer PRIMARY KEY autoincrement," +
                " autores text," +
                " numeroEdicao integer," +
                " comentario text," +
                " capa integer," +
                " descricao text," +
                " isbn integer," +
                " anoPublicacaoBrasil integer," +
                " mesPublicacaoBrasil text," +
                " anoPublicacaoOriginal integer," +
                " mesPublicacaoOriginal text," +
                " titulo text," +
                " editora text," +
                " licenciantes," +
                " quadrinhoid integer," +
                " rankingid integer," +
                "foreign key (rankingid) references ranking(idRanking));");

        db.execSQL("create table if not exists ranking (idRanking integer primary key autoincrement, usuarioid integer," +
                "nota integer," +
                "foreign key (usuarioid) references usuario(idUsuario));");

        //Log.d(TAG, "Tabela criada com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

    public void inserir(Users usuario){
        SQLiteDatabase db = getWritableDatabase();
        try {
        ContentValues valores = new ContentValues();
        valores.put("nome",usuario.getNome());
        valores.put("email",usuario.getEmail());
        valores.put("senha",usuario.getSenha());

        db.insert("usuario",null,valores);
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
}