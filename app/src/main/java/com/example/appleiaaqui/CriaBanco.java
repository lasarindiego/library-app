package com.example.appleiaaqui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NomeBanco = "bdLeiaAqui.db";

    // Tabela de Clientes
    private static final String cTabela = "Clientes";
    private static final String cID = "ID";
    private static final String cNome = "Nome";
    private static final String cEndereco = "Endereco";
    private static final String cCelular = "Celular";
    private static final String cEmail = "Email";
    private static final String cCPF = "CPF";
    private static final String cDataNasc = "DataNasc";
    private static final String cCatgLeitor = "CatLeitor";

    // Tabela de Leitores
    private static final String leiTabela = "CatLeitores";
    private static final String leiCod = "Codigo";
    private static final String LeiDesc = "Descricao";
    private static final String LeiNum = "MaxDias";

    // Tabela de Categoria de livros
    private static final String cLivTabela = "CatLivros";
    private static final String cLivCod = "Codigo";
    private static final String cLivDesc = "Descricao";
    private static final String cLivEmp = "DataEmprestimo";
    private static final String cLivTaxa = "TaxaMulta";

    // Tabela de livros
    private static final String LivTabela = "Livros";
    private static final String LivCod = "Codigo";
    private static final String LivISBN = "ISBN";
    private static final String LivTit = "Titulo";
    private static final String LivCat = "Categoria";
    private static final String LivAut = "Autor";
    private static final String LivChav = "PalavraChave";
    private static final String LivPub = "Publicacao";
    private static final String LivEdc = "Edicao";
    private static final String LivEdt = "Editora";
    private static final String LivPag = "Pagina";


    public CriaBanco(Context context) {
        super(context, name, factory, version);
    }

    public static String getNomeBanco() {
        return NomeBanco;
    }
    public static String getcTabela() {
        return cTabela;
    }
    public static String getcID() {
        return cID;
    }
    public static String getcNome() {
        return cNome;
    }
    public static String getcEndereco() {
        return cEndereco;
    }
    public static String getcCelular() {
        return cCelular;
    }
    public static String getcEmail() {
        return cEmail;
    }
    public static String getcCPF() {
        return cCPF;
    }
    public static String getcDataNasc() {
        return cDataNasc;
    }
    public static String getcCatgLeitor() {
        return cCatgLeitor;
    }
    public static String getLeiTabela() {
        return leiTabela;
    }
    public static String getLeiCod() {
        return leiCod;
    }
    public static String getLeiDesc() {
        return LeiDesc;
    }
    public static String getLeiNum() {
        return LeiNum;
    }
    public static String getcLivTabela() {
        return cLivTabela;
    }
    public static String getcLivCod() {
        return cLivCod;
    }
    public static String getcLivDesc() {
        return cLivDesc;
    }
    public static String getcLivEmp() {
        return cLivEmp;
    }
    public static String getcLivTaxa() {
        return cLivTaxa;
    }
    public static String getLivTabela() {
        return LivTabela;
    }
    public static String getLivCod() {
        return LivCod;
    }
    public static String getLivISBN() {
        return LivISBN;
    }
    public static String getLivTit() {
        return LivTit;
    }
    public static String getLivCat() {
        return LivCat;
    }
    public static String getLivAut() {
        return LivAut;
    }
    public static String getLivChav() {
        return LivChav;
    }
    public static String getLivPub() {
        return LivPub;
    }
    public static String getLivEdc() {
        return LivEdc;
    }
    public static String getLivEdt() {
        return LivEdt;
    }
    public static String getLivPag() {
        return LivPag;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlC = "CREATE TABLE " + cTabela + "("
                + cID + " integer primary key autoincrement, "
                + cNome + " text not null, "
                + cEndereco + " text not null, "
                + cCelular + " text, "
                + cEmail + " text not null, "
                + cCPF + " text unique not null, "
                + cDataNasc + "datetime, "
                + cCatgLeitor + "integer not null," +
                "FOREIGN KEY ("+cCatgLeitor+") REFERENCES " +  leiTabela +"("+leiCod+")"
                + ")";

         String sqlCat = "CREATE TABLE " + leiTabela + " ("
                + leiCod + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LeiDesc + " TEXT, "
                + LeiNum + " INTEGER"
                   +" )";


        String sqlCLivros = "CREATE TABLE "+ cLivTabela +" ("+
                cLivCod +" integer primary key autoincrement,"+
                cLivDesc +" TEXT,"+
                cLivEmp +" TEXT,"+
                cLivTaxa +" REAL"+
       " )";

        String sqlLivros = "CREATE TABLE "+ LivTabela +" ("
                + LivCod + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LivISBN +" TEXT,"
                + LivTit +" TEXT,"
                + LivCat + "integer not null,"
                + LivAut +" TEXT,"
                + LivChav +" TEXT,"
                + LivPub +" TEXT,"
                + LivEdc +" TEXT,"
                + LivEdt +" TEXT,"
                + LivPag +" TEXT,"
                +"FOREIGN KEY ("+LivCat+") REFERENCES " +  cLivTabela +"("+cLivCod+")"
                + " )";

        sqLiteDatabase.execSQL(sqlC);
        sqLiteDatabase.execSQL(sqlCat);
        sqLiteDatabase.execSQL(sqlCLivros);
        sqLiteDatabase.execSQL(sqlLivros);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + cTabela);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + leiTabela);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + cLivTabela);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LivTabela);
        onCreate(sqLiteDatabase);
    }
}
