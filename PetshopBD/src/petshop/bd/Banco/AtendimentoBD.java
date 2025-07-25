package petshop.bd.Banco;

import petshop.bd.Classes.Atendimento.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AtendimentoBD {

    private Connection conexao;
    private Statement declaracao;
    private PreparedStatement declaracao_parametrizada;
    private ResultSet resultados;

    private void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS Atendimento ("
                + "   codigo integer PRIMARY KEY AUTOINCREMENT,"
                + "   data_atendimento text NOT NULL,"
                + "   cliente_cpf text NOT NULL,"
                + "   funcionario_num integer NOT NULL,"
                + "   animal_id integer NOT NULL,"
                + "   FOREIGN KEY (cliente_cpf) REFERENCES Cliente (cpf),"
                + "   FOREIGN KEY (funcionario_num) REFERENCES Funcionario (num_matricula),"
                + "   FOREIGN KEY (animal_id) REFERENCES Animal (id)"
                + ");";

        try {
            this.declaracao = this.conexao.createStatement();
            this.declaracao.execute(sql);

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public AtendimentoBD(Connection conexao) {
        this.conexao = conexao;
        this.criarTabela();
    }

    public boolean cadastrar(Atendimento atendimento) {
        String sql = "insert into Atendimento (data_atendimento, cliente_cpf, animal_id, funcionario_num) values (?,?,?,?)";

        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);

            this.declaracao_parametrizada.setString(1, atendimento.getData());
            this.declaracao_parametrizada.setString(2, atendimento.getCpfCliente());
            this.declaracao_parametrizada.setInt(3, atendimento.getIdAnimal());
            this.declaracao_parametrizada.setInt(4, atendimento.getNumMatricula());

            this.declaracao_parametrizada.executeUpdate();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro na insercao dos dados. Mensagem: " + erro.getMessage());
            return false;
        }
    }

    public boolean verificaCliente(String clienteCpf) {
        String sql = "select * from Cliente where cpf = ?";
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setString(1, clienteCpf);

            this.resultados = declaracao_parametrizada.executeQuery();

            return this.resultados.next();
        } catch (SQLException erro) {
            System.out.println("Erro na busca dos dados. Mensagem: " + erro.getMessage());
            return false;
        }
    }

    public boolean verificaAnimal(int animalId) {
        String sql = "select * from Animal where id = ?";
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setInt(1, animalId);

            this.resultados = declaracao_parametrizada.executeQuery();

            return this.resultados.next();
        } catch (SQLException erro) {
            System.out.println("Erro na busca dos dados. Mensagem: " + erro.getMessage());
            return false;
        }
    }

    public boolean verificaFuncionario(int numMatricula) {
        String sql = "select * from Funcionario where num_matricula = ?";
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setInt(1, numMatricula);

            this.resultados = declaracao_parametrizada.executeQuery();

            return this.resultados.next();
        } catch (SQLException erro) {
            System.out.println("Erro na busca dos dados. Mensagem: " + erro.getMessage());
            return false;
        }
    }

    public void alterar(Atendimento atendimento) {
        String sql = "update Atendimento set"
                + " data_atendimento = ?";

        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);

            this.declaracao_parametrizada.setString(1, atendimento.getData());

            this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro) {
            System.out.println("Erro na alteracao dos dados. Mensagem: " + erro.getMessage());
        }
    }

    public void remover(Atendimento atendimento) {
        String sql = "delete from Atendimento where codigo = ?";

        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);

            this.declaracao_parametrizada.setInt(1, atendimento.getCodigo());

            this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro) {
            System.out.println("Erro na exclusao dos dados. Mensagem: " + erro.getMessage());
        }
    }

    public Atendimento consultar(int codigo) {
        String sql = "select * from Atendimento where codigo = ?";
        Atendimento atendimento = new Atendimento();
        
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setInt(1, atendimento.getCodigo());

            this.resultados = declaracao_parametrizada.executeQuery();

            if (this.resultados != null) {
                while (this.resultados.next()) {
                    atendimento.setCodigo(this.resultados.getInt("codigo"));
                    atendimento.setData(this.resultados.getString("data_atendimento"));
                    atendimento.setCpfCliente(this.resultados.getString("cliente_cpf"));
                    atendimento.setIdAnimal(this.resultados.getInt("animal_id"));
                    atendimento.setNumMatricula(this.resultados.getInt("funcionario_num"));
                }
                return atendimento;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta de dados. Erro: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Atendimento> consultarTodas() {
        ArrayList<Atendimento> atendimentos = new ArrayList<>();
        String sql = "select * from Animal";

        try {
            this.declaracao = this.conexao.createStatement();
            this.resultados = this.declaracao.executeQuery(sql);

            if (this.resultados != null) {
                while (this.resultados.next()) {
                    Atendimento atendimento = new Atendimento();
                    atendimento.setCodigo(this.resultados.getInt("codigo"));
                    atendimento.setData(this.resultados.getString("data_atendimento"));
                    atendimento.setCpfCliente(this.resultados.getString("cliente_cpf"));
                    atendimento.setIdAnimal(this.resultados.getInt("animal_id"));
                    atendimento.setNumMatricula(this.resultados.getInt("funcionario_num"));
                    atendimentos.add(atendimento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem de todos os dados. Erro: " + e.getMessage());
        }
        return atendimentos;
    }

}
