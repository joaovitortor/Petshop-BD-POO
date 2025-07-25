package petshop.bd.Banco;

import petshop.bd.Classes.Atendimento.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AtendimentoBD {
    private Connection conexao;
    private Statement declaracao;
    private PreparedStatement declaracao_parametrizada;
    private ResultSet resultados;

    private void criarTabela(){
        String sql ="CREATE TABLE IF NOT EXISTS Atendimento (" +
                     "codigo integer PRIMARY KEY AUTOINCREMENT," +
                     "data text NOT NULL," +
                     "clienteCpf text NOT NULL," +
                     "FOREIGN KEY (clienteCpf) REFERENCES Cliente (cpf)," +
                     "animalId integer NOT NULL," +                        
                     "FOREIGN KEY (animalId) REFERENCES Animal (id)," +
                     "funcionarioNum integer NOT NULL," +
                     "FOREIGN KEY (funcionarioNum) REFERENCES Funcionario (numMatricula)" +
                     ");";
        try {
            this.declaracao = this.conexao.createStatement();
            System.out.println("SQL a ser executado: " + sql);
            this.declaracao.execute(sql);
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public AtendimentoBD(Connection conexao){
        this.conexao = conexao;
        this.criarTabela();
    }
    
    public boolean cadastrar(Atendimento atendimento) {                       
        String sql = "insert into Atendimento (data, clienteCpf, animalId, funcionarioNum) values (?,?,?,?)";
        
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setString(1, atendimento.getData());
          this.declaracao_parametrizada.setString(2, atendimento.getCpfCliente());
          this.declaracao_parametrizada.setInt(3, atendimento.getIdAnimal());
          this.declaracao_parametrizada.setInt(4, atendimento.getNumMatricula());
          
          this.declaracao_parametrizada.executeUpdate();
          return true;
        } catch (SQLException erro){
            System.out.println("Erro na insercao dos dados. Mensagem: " + erro.getMessage());
                return false;
        }
    }

    public boolean verificaCliente(String clienteCpf){
        String sql = "select * from Cliente where cpf = ?";
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          this.declaracao_parametrizada.setString(1, clienteCpf);
          
          this.resultados = declaracao_parametrizada.executeQuery();
          
          return this.resultados.next();
        }
        catch (SQLException erro){
            System.out.println("Erro na busca dos dados. Mensagem: " + erro.getMessage());
            return false;
        }  
    }

    public boolean verificaAnimal(int animalId){
        String sql = "select * from Animal where id = ?";
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          this.declaracao_parametrizada.setInt(1, animalId);
          
          this.resultados = declaracao_parametrizada.executeQuery();
          
          return this.resultados.next();
        }
        catch (SQLException erro){
            System.out.println("Erro na busca dos dados. Mensagem: " + erro.getMessage());
            return false;
        }  
    }
    
    public boolean verificaFuncionario(int numMatricula){
        String sql = "select * from Funcionario where numMatricula = ?";
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          this.declaracao_parametrizada.setInt(1, numMatricula);
          
          this.resultados = declaracao_parametrizada.executeQuery();
          
          return this.resultados.next();
        }
        catch (SQLException erro){
            System.out.println("Erro na busca dos dados. Mensagem: " + erro.getMessage());
            return false;
        }  
    }
    
    
    public void alterar(Atendimento atendimento) {                
        String sql = "update Atendimento set"
                + " data = ?";
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setString(1, atendimento.getData());
           
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na alteracao dos dados. Mensagem: " + erro.getMessage());
        }        
    }

    public void remover(Atendimento atendimento) {
        String sql = "delete from Atendimento where codigo = ?";        
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setInt(1, atendimento.getCodigo());          
          
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na exclusao dos dados. Mensagem: " + erro.getMessage());
        }        
    }

    public void consultar(Atendimento atendimento) {      
        String sql = "select * from Atendimento where codigo = ?";
                
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setInt(1, atendimento.getCodigo());
            
            this.resultados = declaracao_parametrizada.executeQuery();
            
            if (this.resultados != null) {
                System.out.println("\n\n\n ###########################################");                
                while(this.resultados.next()){
                    System.out.println("Codigo: " + this.resultados.getInt("codigo"));
                    System.out.println("Data: " + this.resultados.getString("data"));
                    System.out.println("Cliente: " + this.resultados.getString("clienteCpf"));
                    System.out.println("Animal: " + this.resultados.getInt("animalId"));
                    System.out.println("Funcionario: " + this.resultados.getInt("funcionarioNum"));

                    System.out.println("###########################################");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta de dados. Erro: " + e.getMessage());
        }    
    }
    
    public void consultarTodas() {
        String sql = "select * from Atendimento";        
                
        try {                   
            this.declaracao = this.conexao.createStatement();
            this.resultados = this.declaracao.executeQuery(sql);
            
            if (this.resultados != null) {
                System.out.println("\n\n\n ###########################################");                
                while(this.resultados.next()){
                    System.out.println("Codigo: " + this.resultados.getInt("codigo"));
                    System.out.println("Data: " + this.resultados.getString("data"));
                    System.out.println("Cliente: " + this.resultados.getString("clienteCpf"));
                    System.out.println("Animal: " + this.resultados.getInt("animalId"));
                    System.out.println("Funcionario: " + this.resultados.getInt("funcionarioNum"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem de todos os dados. Erro: " + e.getMessage());
        }              
    }
    
        public void consultarTodasAnimal() {
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
    
}
