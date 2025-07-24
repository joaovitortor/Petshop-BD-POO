package petshop.bd.Banco;

import petshop.bd.Classes.Funcionario.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncionarioBD {
    private final SQLiteDriver sqLiteDriver;
    private final Connection conexao;
    private Statement declaracao;
    private PreparedStatement declaracao_parametrizada;
    private ResultSet resultados;

    private void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS Funcionario (" +
                "	numMatricula int PRIMARY KEY NOT NULL," +
                "	nome text NOT NULL," +
                "	qualificacao text NOT NULL," +
                "	descricaoFuncao text NOT NULL," +
                "	cargaHorariaSemanal int NOT NULL" +

                                                            ");";
        try {
            this.declaracao = this.conexao.createStatement();
            this.declaracao.execute(sql);
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public FuncionarioBD(){
        this.sqLiteDriver = new SQLiteDriver("funcionarios");      
        this.conexao = sqLiteDriver.iniciarConexao();
        this.criarTabela();
    }
    
    public boolean cadastrar(Funcionario funcionario) {                       
        String sql = "insert into Funcionario (numMatricula, nome, qualificacao, descricaoFuncao, cargaHorariaSemanal) values (?,?,?,?,?)";
        
        
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
        String sql = "delete from Funcionario where numMatricula = ?";        
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setInt(1, funcionario.getNumMatricula());          
          
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na exclusao dos dados. Mensagem: " + erro.getMessage());
        }        
    }

    public void consultar(Funcionario funcionario) {      
        String sql = "select * from Funcionario where cpf = ?";
                
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setInt(1, funcionario.getNumMatricula());
            
            this.resultados = declaracao_parametrizada.executeQuery();
            
            if (this.resultados != null) {
                System.out.println("\n\n\n ###########################################");                
                while(this.resultados.next()){
                    System.out.println("CargaHorariaSemanal: " + this.resultados.getString("cargaHorariaSemanal"));
                    System.out.println("Nome: " + this.resultados.getString("nome"));
                    System.out.println("NumMatricula: " + this.resultados.getString("numMatricula"));
                    System.out.println("Qualificacao: " + this.resultados.getString("qualificacao"));
                    System.out.println("DescricaoFuncao: " + this.resultados.getString("descricaoFuncao"));
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
                    System.out.println("CargaHorariaSemanal: " + this.resultados.getString("cargaHorariaSemanal"));
                    System.out.println("Nome: " + this.resultados.getString("nome"));
                    System.out.println("NumMatricula: " + this.resultados.getString("numMatricula"));
                    System.out.println("Qualificacao: " + this.resultados.getString("qualificacao"));
                    System.out.println("DescricaoFuncao: " + this.resultados.getString("descricaoFuncao"));
                    System.out.println("###########################################");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem de todos os dados. Erro: " + e.getMessage());
        }              
    }

}

