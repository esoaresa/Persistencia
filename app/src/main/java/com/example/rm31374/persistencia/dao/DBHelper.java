package com.example.rm31374.persistencia.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.rm31374.persistencia.MinhaAplicacao;
import com.example.rm31374.persistencia.model.Livro;

/**
 * Created by rm31374 on 12/12/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static String NOME_BANCO = "livros.db";
    public static int VERSAO_BANCO = 1;

    public DBHelper() {
        super(MinhaAplicacao.getContext(), NOME_BANCO, null, VERSAO_BANCO);
        seed();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LivroDAO.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void seed() {
        LivroDAO dao = new LivroDAO();

        Livro android = new Livro();
        android.setAutor("Ricardo Lechetta");
        android.setEditora("Novatec");
        android.setTitulo("Google Android");

        dao.insereDado(android);

        Livro torreNegra = new Livro();
        torreNegra.setTitulo("A Torre Negra");
        torreNegra.setEditora("AchoSuma");
        torreNegra.setAutor("Stephen King");

        dao.insereDado(torreNegra);
    }
}
