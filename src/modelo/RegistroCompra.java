package modelo;


public class RegistroCompra{
    private String NomeProduto, Solicitante, Aprovacao,Data_compra;
    private float ValorTotal, ValorUnitario;
    private int Quantidade, Id;

    public String getData_compra() {
        return Data_compra;
    }

    public void setData_compra(String Data_compra) {
        this.Data_compra = Data_compra;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }

    public String getSolicitante() {
        return Solicitante;
    }

    public void setSolicitante(String Solicitante) {
        this.Solicitante = Solicitante;
    }

    public String getAprovacao() {
        return Aprovacao;
    }

    public void setAprovacao(String Aprovacao) {
        this.Aprovacao = Aprovacao;
    }

    public float getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(float ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public float getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(float ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }
    
    public double calculo(){
        return ValorUnitario*Quantidade;
    }
    
}
