package petshop.bd.Banco;

import petshop.bd.Classes.Funcionario.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncionarioBD {
    private Connection conexao;
    private Statement declaracao;
    private PreparedStatement declaracao_parametrizada;
    private ResultSet resultados;

    private void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS Funcionario (" +
                "	num_matricula int PRIMARY KEY NOT NULL," +
                "	nome text NOT NULL," +
                "	qualificacao text NOT NULL," +
                "	descricao_funcao text NOT NULL," +
                "	carga_horaria_semanal int NOT NULL" +

                                                            ");";
        try {
            this.declaracao = this.conexao.createStatement();
            this.declaracao.execute(sql);
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public FuncionarioBD(Connection conexao){
        this.conexao = conexao;
        this.criarTabela();
    }
    
    public boolean cadastrar(Funcionario funcionario) {                       
        String sql = "insert into Funcionario (num_matricula, nome, qualificacao, descricao_funcao, carga_horaria_semanal) values (?,?,?,?,?)";
        
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setInt(1, funcionario.getNumMatricula());
          this.declaracao_parametrizada.setString(2, funcionario.getNome());
          this.declaracao_parametrizada.setString(3, funcionario.getQualificacao());
          this.declaracao_parametrizada.setString(4, funcionario.getDescricaoFuncao());
          this.declaracao_parametrizada.setInt(5, funcionario.getCargaHorariaSemanal());
          
          this.declaracao_parametrizada.executeUpdate();
          return true;
        } catch (SQLException erro){
            System.out.println("Erro na insercao dos dados. Mensagem: " + erro.getMessage());
            return false;
        }
    }

    public void alterar(Funcionario funcionario) {                
        String sql = "update Funcionario set"
                + " nome = ?";
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setString(1, funcionario.getNome());
           
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na alteracao dos dados. Mensagem: " + erro.getMessage());
        }        
    }

    public void remover(Funcionario funcionario){
        String sql = "delete from Funcionario where num_matricula = ?";        
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setInt(1, funcionario.getNumMatricula());          
          
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na exclusao dos dados. Mensagem: " + erro.getMessage());
        }        
    }

    public void consultar(Funcionario funcionario) {      
        String sql = "select * from Funcionario where num_maricula = ?";
                
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setInt(1, funcionario.getNumMatricula());
            
            this.resultados = declaracao_parametrizada.executeQuery();
            
            if (this.resultados != null) {
                System.out.println("\n\n\n ###########################################");                
                while(this.resultados.next()){
                    System.out.println("CargaHorariaSemanal: " + this.resultados.getString("carga_horaria_semanal"));
                    System.out.println("Nome: " + this.resultados.getString("nome"));
                    System.out.println("NumMatricula: " + this.resultados.getString("num_matricula"));
                    System.out.println("Qualificacao: " + this.resultados.getString("qualificacao"));
                    System.out.println("DescricaoFuncao: " + this.resultados.getString("descricao_funcao"));
                    System.out.println("###########################################");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta de dados. Erro: " + e.getMessage());
        }    
    }
    
    public void consultarTodas() {
        String sql = "select * from Funcionario";        
                
        try {                   
            this.declaracao = this.conexao.createStatement();
            this.resultados = this.declaracao.executeQuery(sql);
            
            if (this.resultados != null) {
                System.out.println("\n\n\n ###########################################");                
                while(this.resultados.next()){
                    System.out.println("CargaHorariaSemanal: " + this.resultados.getString("carga_horaria_semanal"));
                    System.out.println("Nome: " + this.resultados.getString("nome"));
                    System.out.println("NumMatricula: " + this.resultados.getString("num_matricula"));
                    System.out.println("Qualificacao: " + this.resultados.getString("qualificacao"));
                    System.out.println("DescricaoFuncao: " + this.resultados.getString("descricao_funcao"));;
                    System.out.println("###########################################");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem de todos os dados. Erro: " + e.getMessage());
        }              
    }

}

