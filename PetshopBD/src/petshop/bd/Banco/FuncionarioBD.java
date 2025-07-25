package petshop.bd.Banco;

import java.awt.List;
import petshop.bd.Classes.Funcionario.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public Funcionario consultar(int numMatricula) {  
        Funcionario funcionario = new Funcionario();
        String sql = "select * from Funcionario where num_maricula = ?";
                
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setInt(1, numMatricula);
            
            this.resultados = declaracao_parametrizada.executeQuery();
            
            if (this.resultados != null) {
                while(this.resultados.next()){
                    funcionario.setNome(resultados.getString("nome"));
                    funcionario.setQualificacao(resultados.getString("qualificacao"));
                    funcionario.setDescricaoFuncao(resultados.getString("descricao_funcao"));
                    funcionario.setNumMatricula(resultados.getInt("num_matricula"));
                    funcionario.setCargaHorariaSemanal(resultados.getInt("descricao_funcao"));
                }
                return funcionario;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta de dados. Erro: " + e.getMessage());
        }  
        return null;
    }
    
    public ArrayList<Funcionario> consultarTodas() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "select * from Funcionario";        
                
        try {                   
            this.declaracao = this.conexao.createStatement();
            this.resultados = this.declaracao.executeQuery(sql);
            
            if (this.resultados != null) {
                while(this.resultados.next()){
                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(resultados.getString("nome"));
                    funcionario.setQualificacao(resultados.getString("qualificacao"));
                    funcionario.setDescricaoFuncao(resultados.getString("descricao_funcao"));
                    funcionario.setNumMatricula(resultados.getInt("num_matricula"));
                    funcionario.setCargaHorariaSemanal(resultados.getInt("descricao_funcao"));
                    funcionarios.add(funcionario);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem de todos os dados. Erro: " + e.getMessage());
        }
        return funcionarios;
    }
}

