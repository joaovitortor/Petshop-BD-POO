package petshop.bd.Main;

import petshop.bd.Classes.Atendimento.SistemaAtendimento;
import petshop.bd.Classes.Funcionario.SistemaFuncionario;
import petshop.bd.Classes.Animal.SistemaAnimal;
import petshop.bd.Classes.Cliente.SistemaCliente;
import java.util.Scanner;
import petshop.bd.Main.MenuInicial;

public class GerenciarSistema {

    private Scanner input;
    protected SistemaCliente sistemaCliente;
    protected SistemaFuncionario sistemaFuncionario;
    protected SistemaAnimal sistemaAnimal;
    protected SistemaAtendimento sistemaAtendimento;

    /**
     * Inicializa o sistema de gerenciamento do petshop.
     */
    public void iniciar() {
        MenuInicial telaInicial = new MenuInicial();
        telaInicial.setVisible(true);

    }
}
