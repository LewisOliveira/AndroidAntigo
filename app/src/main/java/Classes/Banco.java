package Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLInput;
import java.util.ArrayList;

public class Banco extends SQLiteOpenHelper {
    private static final String TAG = "sql";
    public static final String NOME_BANCO = "banco.db";
    private static final int VERSAO_BANCO = 1;

    public Banco(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Criação de tabela");

        db.execSQL("create table if not exists usuario (idUsuario integer PRIMARY KEY autoincrement, nome text, email text," +
                " senha text," +
                "colecaoid integer ," +
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

        Log.d(TAG, "Tabela criada com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public String LoginUsuario(String email, String senha){
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("select * from usuario where email=? and senha=?", new String[]{email, senha});

        try {
                String emailB= c.getString(c.getColumnIndex("email"));

                return emailB;
        } finally {
            db.close();
        }
    }

    public boolean EmailCadastrado(String email){
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("select email from usuario where email=?", new String[]{email});
        String emailBanco = c.getString(c.getColumnIndex("email"));

        try {
            if((emailBanco.equals(email)))
                return true;
            else
                return false;

        } finally {
            db.close();
        }
    }

    public boolean SenhaDiferente(String senha){
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("select senha from usuario where email=?", new String[]{senha});
        String senhaBanco = c.getString(c.getColumnIndex("senha"));

        try {
            if((senhaBanco == senha))
                return true;
            else
                return false;

        } finally {
            db.close();
        }
    }

    public void CadastroUsuario(Users users) {
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();

            values.put("nome", users.getNome());
            values.put("email", users.getEmail());
            values.put("senha", users.getSenha());

            db.insert("usuario", null, values);
        } finally {
            db.close();
        }
    }

    public boolean JaCadastrado(String email, String senha) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("select email,senha from usuario where email=? and senha=?", new String[]{email, senha});
        String emailBanco = c.getString(c.getColumnIndex("email"));
        String senhaBanco = c.getString(c.getColumnIndex("senha"));

        try {
            if((emailBanco.equals(email)) && (senhaBanco==senha))
                return true;
            else
                return false;

        } finally {
            db.close();
        }
    }

    public void CarregaColecao(Users user) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("select * from usuario " +
                "join colecao on idcolecao = colecaoid where email=? and senha=?", new String[]{user.getEmail(), user.getSenha()});

        try {
            //Depois eu continuo...
        } finally {
            db.close();
        }
    }
}