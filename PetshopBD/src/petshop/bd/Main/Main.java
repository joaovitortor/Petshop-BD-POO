package petshop.bd.Main;

import java.sql.Connection;
import petshop.bd.Banco.SQLiteDriver;
import petshop.bd.Banco.AnimalBD;
import petshop.bd.Banco.AtendimentoBD;
import petshop.bd.Banco.ClienteBD;
import petshop.bd.Banco.FuncionarioBD;


public class Main {
    public static void main(String[] args){
        
        SQLiteDriver driver = new SQLiteDriver("petshop.db");
        Connection conexao = driver.iniciarConexao();
        
        ClienteBD clienteBd = new ClienteBD(conexao);
        AnimalBD animalBd = new AnimalBD(conexao);
        FuncionarioBD funcionarioBd = new FuncionarioBD(conexao);
        AtendimentoBD atendimentoBd = new AtendimentoBD(conexao);
        
        MenuInicial telaInicial = new MenuInicial(conexao);
        telaInicial.setVisible(true);
        
    }
}

