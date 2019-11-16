
package modelo;

public class ValidacaoLogin extends Funcionario {
    
    private String NovaSenha, Confirmacao, SenhaAntiga;
    private int Id;
    
    public String getNovaSenha() {
        return NovaSenha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNovaSenha(String NovaSenha) {
        this.NovaSenha = NovaSenha;
    }

    public String getConfirmacao() {
        return Confirmacao;
    }

    public void setConfirmacao(String Confirmacao) {
        this.Confirmacao = Confirmacao;
    }

    public String getSenhaAntiga() {
        return SenhaAntiga;
    }

    public void setSenhaAntiga(String SenhaAntiga) {
        this.SenhaAntiga = SenhaAntiga;
    }
    
    
    
}
