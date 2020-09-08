package com.example.appleiaaqui;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class ControlaBanco {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public ControlaBanco(Context context) {banco = new CriaBanco(context);}

    // --------------------------------------------------------------------  CRUD - Tabela Clientes

    public String insereClientes(String Nome, String Endereco, String Celular, String Email,
                                     String CPF, String DataNasc, String CatLeitor){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getcNome(), Nome);
        valores.put(CriaBanco.getcEndereco(), Endereco);
        valores.put(CriaBanco.getcCelular(), Celular);
        valores.put(CriaBanco.getcEmail(), Email);
        valores.put(CriaBanco.getcCPF(), CPF);
        valores.put(CriaBanco.getcDataNasc(), DataNasc);
        valores.put(CriaBanco.getcCatgLeitor(), CatLeitor);
        resultado = db.insert(CriaBanco.getcTabela(), null, valores);
        db.close();

        if (resultado == 1)
            return "Erro ao inserir cliente.";
        else
            return "Cliente inserido com sucesso.";
    }

    public Cursor carregaClientes(){
        Cursor cursor;
        String[] campos = {CriaBanco.getcID(), CriaBanco.getcNome()};
        db = banco.getReadableDatabase();
        cursor = db.rawQuery(CriaBanco.getcCPF(), campos);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraClientes(int ID, String Nome, String Endereco, String Celular, String Email,
                                       String CPF, String DataNasc, String CatLeitor)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getcID() + "=" + ID;
        valores = new ContentValues();
        valores.put(CriaBanco.getcNome(), Nome);
        valores.put(CriaBanco.getcEndereco(), Endereco);
        valores.put(CriaBanco.getcCelular(), Celular);
        valores.put(CriaBanco.getcEmail(), Email);
        valores.put(CriaBanco.getcCPF(), CPF);
        valores.put(CriaBanco.getcDataNasc(), DataNasc);
        valores.put(CriaBanco.getcCatgLeitor(), CatLeitor);
        db.update(CriaBanco.getcTabela(),valores,where,null);
        db.close();
    }

    public void deletaClientes(int ID){
        String where = CriaBanco.getcID() + "=" + ID;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getcTabela(),where,null);
        db.close();
    }

    // --------------------------------------------------------------------  CRUD - Tabela Leitores

    public String insereLeitores(String Descricao, String MaxDias){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getLeiDesc(), Descricao);
        valores.put(CriaBanco.getLeiNum(), MaxDias);
        resultado = db.insert(CriaBanco.getLeiTabela(), null, valores);
        db.close();

        if (resultado == 1)
            return "Erro ao inserir leitor.";
        else
            return "Leitor inserido com sucesso.";
    }

    public Cursor carregaLeitores(){
        Cursor cursor;
        String[] campos = {CriaBanco.getLeiCod(), CriaBanco.getLeiDesc()};
        db = banco.getReadableDatabase();
        cursor = db.rawQuery(CriaBanco.getLeiDesc(), campos);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraLeitores(int Cod, String Descricao, String MaxDias)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getLeiCod() + "=" + Cod;
        valores = new ContentValues();
        valores.put(CriaBanco.getLeiDesc(), Descricao);
        valores.put(CriaBanco.getLeiNum(), MaxDias);
        db.update(CriaBanco.getLeiTabela(),valores,where,null);
        db.close();
    }

    public void deletaLeitores(int Cod){
        String where = CriaBanco.getLeiCod() + "=" + Cod;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getLeiTabela(),where,null);
        db.close();
    }

    // -----------------------------------------------------------------  CRUD - Tabela Cat. Livros

    public String insereCatLivros(String Descricao, String DataEmprestimo, String TaxaMulta){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getcLivDesc(), Descricao);
        valores.put(CriaBanco.getcLivEmp(), DataEmprestimo);
        valores.put(CriaBanco.getcLivTaxa(), TaxaMulta);
        resultado = db.insert(CriaBanco.getcLivTabela(), null, valores);
        db.close();

        if (resultado == 1)
            return "Erro ao inserir categoria de leitor.";
        else
            return "Categoria de leitor inserida com sucesso.";
    }

    public Cursor carregaCatLivros(){
        Cursor cursor;
        String[] campos = {CriaBanco.getcLivCod(), CriaBanco.getcLivDesc()};
        db = banco.getReadableDatabase();
        cursor = db.rawQuery(CriaBanco.getcLivDesc(), campos);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraCatLivros(int Cod, String Descricao, String DataEmprestimo, String TaxaMulta)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getcLivCod() + "=" + Cod;
        valores = new ContentValues();
        valores.put(CriaBanco.getcLivDesc(), Descricao);
        valores.put(CriaBanco.getcLivEmp(), DataEmprestimo);
        valores.put(CriaBanco.getcLivTaxa(), TaxaMulta);
        db.update(CriaBanco.getcLivTabela(),valores,where,null);
        db.close();
    }

    public void deletaCatLivros(int Cod){
        String where = CriaBanco.getcLivCod() + "=" + Cod;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getcLivTabela(),where,null);
        db.close();
    }

    // ---------------------------------------------------------------------  CRUD - Tabela Livros

    public String insereLivros(String ISBN, String Titulo, String Categoria, String Autor,
                               String PalavraChave, String Publicacao, String Edicao,
                               String Editora, String Pagina){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getLivISBN(), ISBN);
        valores.put(CriaBanco.getLivTit(), Titulo);
        valores.put(CriaBanco.getLivCat(), Categoria);
        valores.put(CriaBanco.getLivAut(), Autor);
        valores.put(CriaBanco.getLivChav(), PalavraChave);
        valores.put(CriaBanco.getLivPub(), Publicacao);
        valores.put(CriaBanco.getLivEdc(), Edicao);
        valores.put(CriaBanco.getLivEdt(), Editora);
        valores.put(CriaBanco.getLivPag(), Pagina);
        resultado = db.insert(CriaBanco.getLivTabela(), null, valores);
        db.close();

        if (resultado == 1)
            return "Erro ao inserir livro.";
        else
            return "Livro inserido com sucesso.";
    }

    public Cursor carregaLivros(){
        Cursor cursor;
        String[] campos = {CriaBanco.getLivCod(), CriaBanco.getLivTit()};
        db = banco.getReadableDatabase();
        cursor = db.rawQuery(CriaBanco.getLivTit(), campos);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraLivros(int Cod, String ISBN, String Titulo, String Categoria, String Autor,
                             String PalavraChave, String Publicacao, String Edicao,
                             String Editora, String Pagina)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getLivCod() + "=" + Cod;
        valores = new ContentValues();
        valores.put(CriaBanco.getLivISBN(), ISBN);
        valores.put(CriaBanco.getLivTit(), Titulo);
        valores.put(CriaBanco.getLivCat(), Categoria);
        valores.put(CriaBanco.getLivAut(), Autor);
        valores.put(CriaBanco.getLivChav(), PalavraChave);
        valores.put(CriaBanco.getLivPub(), Publicacao);
        valores.put(CriaBanco.getLivEdc(), Edicao);
        valores.put(CriaBanco.getLivEdt(), Editora);
        valores.put(CriaBanco.getLivPag(), Pagina);
        db.update(CriaBanco.getLivTabela(),valores,where,null);
        db.close();
    }

    public void deletaLivros(int Cod){
        String where = CriaBanco.getLivCod() + "=" + Cod;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getLivTabela(),where,null);
        db.close();
    }

}
