package petshop.bd.Banco;

import petshop.bd.Classes.Animal.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalBD {
    private Connection conexao;
    private Statement declaracao;
    private PreparedStatement declaracao_parametrizada;
    private ResultSet resultados;

    private void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS Animal (" +
                "	id integer PRIMARY KEY AUTOINCREMENT," +
                "	nome text NOT NULL," +
                "	especie text NOT NULL," +
                "	peso real NOT NULL," +
                "	altura real NOT NULL," +
                "       donoCpf text NOT NULL," +
                "       FOREIGN KEY (donoCpf) " +
                "           REFERENCES Cliente (cpf)" +

                                                            ");";
        try {
            this.declaracao = this.conexao.createStatement();
            this.declaracao.execute(sql);
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public AnimalBD(Connection conexao){
        this.conexao = conexao;
        this.criarTabela();
    }
    
    public boolean verificaDono(String cpfDono){
        String sql = "select * from Cliente where cpf = ?";
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          this.declaracao_parametrizada.setString(1, cpfDono);
          
          this.resultados = declaracao_parametrizada.executeQuery();
          
          return this.resultados.next();
          
        }
        catch (SQLException erro){
            System.out.println("Erro na busca dos dados. Mensagem: " + erro.getMessage());
            return false;
        }  
    }
    
    public boolean cadastrar(Animal animal) {                       
        String sql = "insert into Animal (nome, especie, peso, altura, donoCpf, id) values (?,?,?,?,?,?)";
        
        
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
            this.declaracao_parametrizada.setString(1, animal.getNome());
            this.declaracao_parametrizada.setString(2, animal.getEspecie());
            this.declaracao_parametrizada.setFloat(3, animal.getPeso());
            this.declaracao_parametrizada.setFloat(4, animal.getAltura());
            this.declaracao_parametrizada.setString(5, animal.getCpfDono());
            this.declaracao_parametrizada.setInt(6, animal.getId());

            this.declaracao_parametrizada.executeUpdate();
            return true;
            
        } catch (SQLException erro){
            System.out.println("Erro na insercao dos dados. Mensagem: " + erro.getMessage());
            return false;
        }
    }

    public void alterar(Animal animal) {                
        String sql = "update Animal set"
                + " nome = ?";
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setString(1, animal.getNome());
           
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na alteracao dos dados. Mensagem: " + erro.getMessage());
        }        
    }

    public void remover(Animal animal) {
        String sql = "delete from Animal where id = ?";        
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setInt(1, animal.getId());          
          
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na exclusao dos dados. Mensagem: " + erro.getMessage());
        }        
    }

    public void consultar(Animal animal) {      
        String sql = "select * from Animal where id = ?";
                
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setInt(1, animal.getId());
            
            this.resultados = declaracao_parametrizada.executeQuery();
            
            if (this.resultados != null) {
                System.out.println("\n\n\n ###########################################");                
                while(this.resultados.next()){
                    System.out.println("ID: " + this.resultados.getString("id"));
                    System.out.println("Nome: " + this.resultados.getString("nome"));
                    System.out.println("Especie: " + this.resultados.getString("especie"));
                    System.out.println("Peso: " + this.resultados.getString("peso"));
                    System.out.println("Altura: " + this.resultados.getString("altura"));
                    System.out.println("DonoCPF: " + this.resultados.getString("donoCpf"));
                    System.out.println("###########################################");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta de dados. Erro: " + e.getMessage());
        }    
    }
    
    public void consultarTodas() {
        String sql = "select * from Animal";        
                
        try {                   
            this.declaracao = this.conexao.createStatement();
            this.resultados = this.declaracao.executeQuery(sql);
            
            if (this.resultados != null) {
                System.out.println("\n\n\n ###########################################");                
                while(this.resultados.next()){
                    System.out.println("ID: " + this.resultados.getString("id"));
                    System.out.println("Nome: " + this.resultados.getString("nome"));
                    System.out.println("Especie: " + this.resultados.getString("especie"));
                    System.out.println("Peso: " + this.resultados.getString("peso"));
                    System.out.println("Altura: " + this.resultados.getString("altura"));
                    System.out.println("DonoCPF: " + this.resultados.getString("donoCpf"));
                    System.out.println("###########################################");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem de todos os dados. Erro: " + e.getMessage());
        }              
    }
    
    public void consultarTodasClientes() {
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
