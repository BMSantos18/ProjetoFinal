package modelo;

public class Funcionario {
    private String Nome, Login, CPF, CEP, Senha, Endereco, Complemento, Bairro, Cargo, Telefone1, Telefone2;
    private int Numero,Id;
    private float Salario;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {return Nome;}
    public void setNome(String Nome) {this.Nome = Nome;}

    public String getLogin() {return Login;}
    public void setLogin(String Login) {this.Login = Login;}

    public String getCPF() {return CPF;}
    public void setCPF(String CPF) {this.CPF = CPF;}

    public String getCEP() {return CEP;}
    public void setCEP(String CEP) {this.CEP = CEP;}

    public String getSenha() {return Senha;}
    public void setSenha(String Senha) {this.Senha = Senha;}

    public String getEndereco() {return Endereco;}
    public void setEndereco(String Endereco) {this.Endereco = Endereco;}

    public String getComplemento() {return Complemento;}
    public void setComplemento(String Complemento) {this.Complemento = Complemento;}

    public String getBairro() {return Bairro;}
    public void setBairro(String Bairro) {this.Bairro = Bairro;}

    public String getCargo() {return Cargo;}
    public void setCargo(String Cargo) {this.Cargo = Cargo;}

    public String getTelefone1() {return Telefone1;}
    public void setTelefone1(String Telefone1) {this.Telefone1 = Telefone1;}

    public String getTelefone2() {return Telefone2;}
    public void setTelefone2(String Telefone2) {this.Telefone2 = Telefone2;}

    public int getNumero() {return Numero;}
    public void setNumero(int Numero) {this.Numero = Numero;}

    public float getSalario() {return Salario;}
    public void setSalario(float Salario) {this.Salario = Salario;}       
}
