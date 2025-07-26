package petshop.bd.Banco;

import petshop.bd.Classes.Animal.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AnimalBD {

    private Connection conexao;
    private Statement declaracao;
    private PreparedStatement declaracao_parametrizada;
    private ResultSet resultados;

    private void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS Animal ("
                + "	id integer PRIMARY KEY AUTOINCREMENT,"
                + "	nome text NOT NULL,"
                + "	especie text NOT NULL,"
                + "	peso real NOT NULL,"
                + "	altura real NOT NULL,"
                + "       dono_cpf text NOT NULL,"
                + "       FOREIGN KEY (dono_cpf) "
                + "           REFERENCES Cliente (cpf)"
                + ");";
        try {
            this.declaracao = this.conexao.createStatement();
            this.declaracao.execute(sql);

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public AnimalBD(Connection conexao) {
        this.conexao = conexao;
        this.criarTabela();
    }

    public boolean verificaDono(String cpfDono) {
        String sql = "select * from Cliente where cpf = ?";
        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setString(1, cpfDono);

            this.resultados = declaracao_parametrizada.executeQuery();

            return this.resultados.next();

        } catch (SQLException erro) {
            System.out.println("Erro na busca dos dados. Mensagem: " + erro.getMessage());
            return false;
        }
    }

    public boolean cadastrar(Animal animal) {
        String sql = "insert into Animal (nome, especie, peso, altura, dono_cpf) values (?,?,?,?,?)";

        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);

            this.declaracao_parametrizada.setString(1, animal.getNome());
            this.declaracao_parametrizada.setString(2, animal.getEspecie());
            this.declaracao_parametrizada.setFloat(3, animal.getPeso());
            this.declaracao_parametrizada.setFloat(4, animal.getAltura());
            this.declaracao_parametrizada.setString(5, animal.getCpfDono());

            this.declaracao_parametrizada.executeUpdate();
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro na insercao dos dados. Mensagem: " + erro.getMessage());
            return false;
        }
    }

    public void alterar(Animal animal) {
        String sql = "update Animal set"
                + " nome = ?," + "especie = ?," + "peso = ?," + "altura = ?" + "WHERE id = ?";

        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);

            this.declaracao_parametrizada.setString(1, animal.getNome());
            this.declaracao_parametrizada.setString(2, animal.getEspecie());
            this.declaracao_parametrizada.setFloat(3, animal.getPeso());
            this.declaracao_parametrizada.setFloat(4, animal.getAltura());
            this.declaracao_parametrizada.setInt(5, animal.getId());
            
            this.declaracao_parametrizada.executeUpdate();
        } catch (SQLException erro) {
            System.out.println("Erro na alteracao dos dados. Mensagem: " + erro.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "delete from Animal where id = ?";

        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);

            this.declaracao_parametrizada.setInt(1, id);

            this.declaracao_parametrizada.executeUpdate();
            
        } catch (SQLException erro) {  
            if (erro.getMessage().contains("FOREIGN KEY constraint failed")) {
                System.err.println("");
                JOptionPane.showMessageDialog(null, "Este animal está associado a atendimentos e não pode ser excluído diretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            else{
                System.out.println("Erro na exclusao dos dados. Mensagem: " + erro.getMessage());
            }
        }
    }

    public Animal consultar(int id) {
        Animal animal = new Animal();
        String sql = "select * from Animal where id = ?";

        try {
            this.declaracao_parametrizada = this.conexao.prepareStatement(sql);
            this.declaracao_parametrizada.setInt(1, id);

            this.resultados = declaracao_parametrizada.executeQuery();

            if (this.resultados.next()) {
                animal.setId(this.resultados.getInt("id"));
                animal.setEspecie(this.resultados.getString("especie"));
                animal.setNome(this.resultados.getString("nome"));
                animal.setAltura(this.resultados.getFloat("altura"));
                animal.setPeso(this.resultados.getFloat("peso"));
                animal.setCpfDono(this.resultados.getString("dono_cpf"));
                return animal;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta de dados. Erro: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Animal> consultarTodas() {
        ArrayList<Animal> animais = new ArrayList<>();
        String sql = "select * from Animal";

        try {
            this.declaracao = this.conexao.createStatement();
            this.resultados = this.declaracao.executeQuery(sql);

            if (this.resultados != null) {
                while (this.resultados.next()) {
                    Animal animal = new Animal();
                    animal.setId(this.resultados.getInt("id"));
                    animal.setEspecie(this.resultados.getString("especie"));
                    animal.setNome(this.resultados.getString("nome"));
                    animal.setAltura(this.resultados.getFloat("altura"));
                    animal.setPeso(this.resultados.getFloat("peso"));
                    animal.setCpfDono(this.resultados.getString("dono_cpf"));
                    animais.add(animal);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem de todos os dados. Erro: " + e.getMessage());
        }
        return animais;
    }

}
