package petshop.bd.Banco;

import petshop.bd.Classes.Atendimento.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AtendimentoBD {
    private final SQLiteDriver sqLiteDriver;
    private final Connection conexao;
    private Statement declaracao;
    private PreparedStatement declaracao_parametrizada;
    private ResultSet resultados;

    private void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS Atendimento (" +
                "	codigo integer PRIMARY KEY AUTOINCREMENT," +
                "	data text NOT NULL," +
                "       clienteCpf text NOT NULL" +
                "       FOREIGN KEY (clienteCpf) " +
                "           REFERENCES clientes (cpf)" +
                "               ON UPDATE RESTRICT" +
                "               ON DELETE RESTRICT" +
                "       animalId integer NOT NULL" +
                "       FOREIGN KEY (animalId) " +
                "           REFERENCES animais (id)" +
                "               ON UPDATE RESTRICT" +
                "               ON DELETE RESTRICT" +
                "       funcionarioNum integer NOT NULL" +
                "       FOREIGN KEY (funcionarioNum) " +
                "           REFERENCES funcionarios (numMatricula)" +
                "               ON UPDATE RESTRICT" +
                "               ON DELETE RESTRICT" +
                                                            ");";
        try {
            this.declaracao = this.conexao.createStatement();
            this.declaracao.execute(sql);
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public AtendimentoBD(){
        this.sqLiteDriver = new SQLiteDriver("atendimentos");      
        this.conexao = sqLiteDriver.iniciarConexao();
        this.criarTabela();
    }
    
    public void cadastrar(Atendimento atendimento) {                       
        String sql = "insert into Atendimento (data, clienteCpf, animalId, funcionarioNum) values (?,?,?,?)";
        
        
        try {
          this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
          
          this.declaracao_parametrizada.setString(1, atendimento.getData());
          this.declaracao_parametrizada.setString(2, atendimento.getCliente().getCpf());
          this.declaracao_parametrizada.setInt(3, atendimento.getAnimal().getId());
          this.declaracao_parametrizada.setInt(4, atendimento.getFuncionario().getNumMatricula());
          
          this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro na insercao dos dados. Mensagem: " + erro.getMessage());
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

}
