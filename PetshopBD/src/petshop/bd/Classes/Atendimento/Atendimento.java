package petshop.bd.Classes.Atendimento;

public class Atendimento {

    private int codigo, idAnimal, numMatricula;
    private String data, cpfCliente;
    

    public Atendimento(String data, String cpfCliente, int idAnimal, int numMatricula) {
        super();
        this.data = data;
        this.cpfCliente = cpfCliente;
        this.idAnimal = idAnimal;
        this.numMatricula = numMatricula;
    }
    
    public Atendimento(){
        super();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    

    public void exibirInformacoes() {
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Data: " + getData());
        System.out.println("Cliente: " + getCpfCliente());
        System.out.println("Animal: " + getIdAnimal());
        System.out.println("Funcionario: " + getNumMatricula());
    }
}
