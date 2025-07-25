package petshop.bd.Banco;

import petshop.bd.Classes.Cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteBD {
    private Connection conexao;
    private Statement declaracao;
    private PreparedStatement declaracao_parametrizada;
    private ResultSet resultados;

    private void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS Cliente (" +
                "	cpf text PRIMARY KEY NOT NULL," +
                "	nome text NOT NULL," +
                "	rg text NOT NULL," +
                "	telefone text NOT NULL," +
                "	email text NOT NULL" +

                                                            ");";
        try {
            this.declaracao = this.conexao.createStatement();
            this.declaracao.execute(sql);
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public ClienteBD(Connection conexao){   
        this.conexao = conexao;
        this.criarTabela();
    }
    
    public boolean cadastrar(Cliente cliente) {                       
        String sql = "insert into Cliente (cpf, nome, rg, telefone, email) values (?,?,?,?,?)";
        
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setString(1, cliente.getCpf());
          this.declaracao_parametrizada.setString(2, cliente.getNome());
          this.declaracao_parametrizada.setString(3, cliente.getRg());
          this.declaracao_parametrizada.setString(4, cliente.getTelefone());
          this.declaracao_parametrizada.setString(5, cliente.getEmail());
          
          this.declaracao_parametrizada.executeUpdate();
          return true;
        } catch (SQLException erro){
            System.out.println("Erro na insercao dos dados. Mensagem: " + erro.getMessage());
            return false;
        }
    }

    public void alterar(Cliente cliente) {                
        String sql = "update Cliente set"
                + " nome = ?";
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setString(1, cliente.getNome());
           
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na alteracao dos dados. Mensagem: " + erro.getMessage());
        }        
    }

    public void remover(Cliente cliente) {
        String sql = "delete from Cliente where cpf = ?";        
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setString(1, cliente.getCpf());          
          
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na exclusao dos dados. Mensagem: " + erro.getMessage());
        }        
    }

    public void consultar(Cliente cliente) {      
        String sql = "select * from Cliente where cpf = ?";
                
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setString(1, cliente.getCpf());
            
            this.resultados = declaracao_parametrizada.executeQuery();
            
            if (this.resultados != null) {
                System.out.println("\n\n\n ###########################################");                
                while(this.resultados.next()){
                    System.out.println("CPF: " + this.resultados.getString("cpf"));
                    System.out.println("Nome: " + this.resultados.getString("nome"));
                    System.out.println("RG: " + this.resultados.getString("rg"));
                    System.out.println("###########################################");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta de dados. Erro: " + e.getMessage());
        }    
    }
    
    public void consultarTodas() {
        String sql = "select * from Cliente";        
                
        try {                   
            this.declaracao = this.conexao.createStatement();
            this.resultados = this.declaracao.executeQuery(sql);
            
            if (this.resultados != null) {
                System.out.println("\n\n\n ###########################################");                
                while(this.resultados.next()){
                    System.out.println("CPF: " + this.resultados.getString("cpf"));
                    System.out.println("Nome: " + this.resultados.getString("nome"));
                    System.out.println("RG: " + this.resultados.getString("rg"));
                    System.out.println("###########################################");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem de todos os dados. Erro: " + e.getMessage());
        }              
    }

}
