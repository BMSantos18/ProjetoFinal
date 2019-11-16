
package modelo;

public class HistoricoVendas {
    
    int Id,QuantidadeDeProduto;
    String NomeFuncionario, Produto, Data_venda;
    float PrecoTotal;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getQuantidadeDeProduto() {
        return QuantidadeDeProduto;
    }

    public void setQuantidadeDeProduto(int QuantidadeDeProduto) {
        this.QuantidadeDeProduto = QuantidadeDeProduto;
    }

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    public String getData_venda() {
        return Data_venda;
    }

    public void setData_venda(String Data_venda) {
        this.Data_venda = Data_venda;
    }

    public float getPrecoTotal() {
        return PrecoTotal;
    }

    public void setPrecoTotal(float PrecoTotal) {
        this.PrecoTotal = PrecoTotal;
    }
        
}
