package dao;
import modelo.Funcionario;
import modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Acesso;
import modelo.Login;
import modelo.RegistroCompra;
import modelo.HistoricoVendas;
import modelo.Inativos;
import modelo.TabelaTempo;
import modelo.Temp;
import modelo.ValidacaoLogin;
import visao.JfrmValidacaoLogin;


public class Banco {
    private Connection conexao;
    
    public Banco()throws Exception{
        this.conexao = Conexao.getConexao();
    }
    public void novoFuncionario (Funcionario f) throws Exception{
        String sql = "insert into Funcionarios (Nome, Login, CPF, CEP, Senha, Endereco, Numero, Complemento, Bairro, Cargo, Salario, Telefone1, Telefone2)" + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1,f.getNome());
        stmt.setString(2,f.getLogin());
        stmt.setString(3,f.getCPF());
        stmt.setString(4,f.getCEP());
        stmt.setString(5,f.getSenha());
        stmt.setString(6,f.getEndereco());
        stmt.setInt(7,f.getNumero());
        stmt.setString(8,f.getComplemento());
        stmt.setString(9,f.getBairro());
        stmt.setString(10,f.getCargo());
        stmt.setFloat(11,f.getSalario());
        stmt.setString(12,f.getTelefone1());
        stmt.setString(13,f.getTelefone2());
        stmt.execute();
        stmt.close();
    }   
    
    public Funcionario pesquisarFuncionarioNome (String Nome) throws Exception{
        Funcionario f = new Funcionario();
        String pesquisar =("select * from Funcionarios where nome = ?");
        PreparedStatement stmt = this.conexao.prepareStatement(pesquisar);
        stmt.setString(1, Nome);
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            f.setId(Integer.parseInt(rs.getString("Id")));
            f.setNome(rs.getString("Nome"));
            f.setLogin(rs.getString("Login"));
            f.setCPF(rs.getString("CPF"));
            f.setCEP(rs.getString("CEP"));
            f.setSenha(rs.getString("Senha"));
            f.setEndereco(rs.getString("Endereco"));
            f.setNumero(Integer.parseInt(rs.getString("Numero")));
            f.setComplemento(rs.getString("Complemento"));
            f.setBairro(rs.getString("Bairro"));
            f.setCargo(rs.getString("Cargo"));
            f.setSalario(Float.parseFloat(rs.getString("Salario")));
            f.setTelefone1(rs.getString("Telefone1"));
            f.setTelefone2(rs.getString("Telefone2"));
            rs.close();
            stmt.close();
        }
        return f;
    }
    
    public void editarFuncionario(Funcionario f) throws Exception{
        String sql = "update Funcionarios set Nome=?, Login=?, CPF=?, CEP=?, Senha=?, Endereco=?, Numero=?, Complemento=?, Bairro=?, Cargo=?, Salario=?, Telefone1=?, Telefone2=?, Id = ? WHERE Id = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1,f.getNome());
        stmt.setString(2,f.getLogin());
        stmt.setString(3,f.getCPF());
        stmt.setString(4,f.getCEP());
        stmt.setString(5,f.getSenha());
        stmt.setString(6,f.getEndereco());
        stmt.setInt(7,f.getNumero());
        stmt.setString(8,f.getComplemento());
        stmt.setString(9,f.getBairro());
        stmt.setString(10,f.getCargo());
        stmt.setFloat(11,f.getSalario());
        stmt.setString(12,f.getTelefone1());
        stmt.setString(13,f.getTelefone2());
        stmt.setInt(14, f.getId());
        stmt.setInt(15, f.getId());
        
        stmt.execute();
        stmt.close();
    }
    
    public void excluirFuncionario(String Nome) throws Exception{
        String sql = ("delete from Funcionarios where Nome = '" + Nome + "'");
        PreparedStatement stmt =this.conexao.prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }
    
    public void inativos (Inativos f) throws Exception{
        String sql = "insert into Inativos (Nome, Login, CPF, CEP, Senha, Endereco, Numero, Complemento, Bairro, Cargo, Salario, Telefone1, Telefone2)" + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1,f.getNome());
        stmt.setString(2,f.getLogin());
        stmt.setString(3,f.getCPF());
        stmt.setString(4,f.getCEP());
        stmt.setString(5,f.getSenha());
        stmt.setString(6,f.getEndereco());
        stmt.setInt(7,f.getNumero());
        stmt.setString(8,f.getComplemento());
        stmt.setString(9,f.getBairro());
        stmt.setString(10,f.getCargo());
        stmt.setFloat(11,f.getSalario());
        stmt.setString(12,f.getTelefone1());
        stmt.setString(13,f.getTelefone2());
        stmt.execute();
        stmt.close();
    }   
    
    public List<Funcionario> getLista(String Nome) throws SQLException{
        String sql = "select * from Funcionarios where Nome ilike ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, Nome);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Funcionario> minhaLista = new ArrayList<Funcionario>();
        
        while(rs.next()){
            Funcionario f = new Funcionario();
            f.setNome(rs.getString("Nome"));
            f.setLogin(rs.getString("Login"));
            f.setCPF(rs.getString("CPF"));
            f.setCEP(rs.getString("CEP"));
            f.setSenha(rs.getString("Senha"));
            f.setEndereco(rs.getString("Endereco"));
            f.setNumero(rs.getInt("Numero"));
            f.setComplemento(rs.getString("Complemento"));
            f.setBairro(rs.getString("Bairro"));
            f.setCargo(rs.getString("Cargo"));
            f.setSalario(rs.getFloat("Salario"));
            f.setTelefone1(rs.getString("Telefone1"));
            f.setTelefone2(rs.getString("Telefone2"));
            minhaLista.add(f);
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }
    
    
 // CONEXÃO COM O BD PARTE ESTOQUE
    
    public void novoProduto (Produto e) throws Exception{
        String sql = "insert into Produto (Nome, Marca, Quantidade, Preco, FuncionarioSoli)" + "values (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        Acesso a = new Acesso();
        
        stmt.setString(1,e.getNome());
        stmt.setString(2,e.getMarca());
        stmt.setInt(3,e.getQuantidade());
        stmt.setFloat(4,e.getPreco());
        stmt.setString(5,a.getLogin() );
        stmt.execute();
        stmt.close();
    }   
    
    public Produto verificarEstoque (String Nome) throws Exception{
        Produto e = new Produto();
        String pesquisar =("select * from Produto where nome = ?");
        PreparedStatement stmt = this.conexao.prepareStatement(pesquisar);
        stmt.setString(1, Nome);
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            e.setId(Integer.parseInt(rs.getString("Id")));
            e.setNome(rs.getString("Nome"));
            e.setMarca(rs.getString("Marca"));
            e.setQuantidade(Integer.parseInt(rs.getString("Quantidade")));
            e.setPreco(Float.parseFloat(rs.getString("Preco")));
            rs.close();
            stmt.close();
        }
        return e;
    }
    
    public void excluirProduto(String Nome) throws Exception{
        String sql = ("delete from Produto where Nome = '" + Nome + "'");
        PreparedStatement stmt =this.conexao.prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }
    
    
    public void editarProduto(Produto e) throws Exception{
       
        String sql = "update Produto set Id=?, Nome=?, Marca=?, Quantidade=?, Preco=? WHERE Id = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1,e.getId());
        stmt.setString(2,e.getNome());
        stmt.setString(3,e.getMarca());
        stmt.setInt(4,e.getQuantidade());
        stmt.setFloat(5,e.getPreco());
        stmt.setInt(6,e.getId());
        
        stmt.execute();
        stmt.close();
    }
    
    public void RegistrarCompra (RegistroCompra rc) throws Exception{
        String sql = "insert into RegistroCompra (NomeProduto, ValorTotal, ValorUnitario, Solicitante, Aprovacao)" + "values (?, ?, ?, ?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1,rc.getNomeProduto());
        stmt.setFloat(2,rc.getValorTotal());
        stmt.setFloat(3,rc.getValorUnitario());
        stmt.setString(4,rc.getSolicitante());
        stmt.setString(5,rc.getAprovacao());
        stmt.execute();
        stmt.close();
    } 

    public boolean ValidarLogin(String Login, String Senha)throws SQLException{
        boolean autenticado = false;
        String sql;
        sql = "select Login, Senha from Funcionarios where Login = ? and Senha = ?";
        PreparedStatement stmt;
        
        stmt = conexao.prepareStatement(sql);
        stmt.setString(1, Login);
        stmt.setString(2, Senha);
        
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            Login login = new Login();
            login.setLogin(rs.getString("Login"));
            login.setSenha(rs.getString("Senha"));
            autenticado = true;
            EntradaAcesso(Login);
        }
        if(rs.next()){
            rs.getString("Senha").equals("321");
        }

        rs.close();
        stmt.close();
        return autenticado;
    }
    
    public void EntradaAcesso(String Login)throws SQLException{
        String sql = "insert into Acesso (Login, dataAcesso, horaAcesso)" + "values (?,?,?)";
        Acesso acesso = new Acesso();
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, Login);
        stmt.setString(2, acesso.getDataAcesso());
        stmt.setString(3, acesso.gethoraAcesso());
        stmt.execute();
        stmt.close();
    }
    
    public List<HistoricoVendas> getVendas (String Data_venda) throws SQLException{
        String sql = "select * from HistoricoDeVendas where Data_venda ilike ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, Data_venda);

        ResultSet rs = stmt.executeQuery();
        
        List<HistoricoVendas> minhaLista = new ArrayList<HistoricoVendas>();
        
        while(rs.next()){
            HistoricoVendas hv = new HistoricoVendas();
            hv.setId(Integer.valueOf(rs.getInt("id")));
            hv.setNomeFuncionario(rs.getString("NomeFuncionario"));
            hv.setPrecoTotal(Float.valueOf(rs.getFloat("PrecoTotal")));
            hv.setProduto(rs.getString("Produto"));
            hv.setQuantidadeDeProduto(Integer.valueOf(rs.getInt("QuantidadeDeProduto")));
            hv.setData_venda(rs.getString("Data_venda"));
            
            minhaLista.add(hv);   
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }
    
    public List<RegistroCompra> getCompras (String Data_compra) throws SQLException{
        String sql = "select * from RegistroCompra where (Data_compra BETWEEN ilike ? and Data_venda ilike ?)";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, Data_compra);

        ResultSet rs = stmt.executeQuery();
        
        List<RegistroCompra> minhaLista = new ArrayList<RegistroCompra>();
        
        while(rs.next()){
            RegistroCompra rc = new RegistroCompra();
            rc.setId(Integer.valueOf(rs.getInt("id")));
            rc.setSolicitante(rs.getString("Solicitante"));
            rc.setValorTotal(Float.valueOf(rs.getFloat("ValorTotal")));
            rc.setNomeProduto(rs.getString("NomeProduto"));
            rc.setQuantidade(Integer.valueOf(rs.getInt("Quantidade")));
            rc.setData_compra(rs.getString("Data_compra"));
            
            minhaLista.add(rc);   
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }
    
    public List<Produto> getEst (String Nome) throws SQLException{
        String sql = "select * from Produto where Nome ilike ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, Nome);

        ResultSet rs = stmt.executeQuery();
        
        List<Produto> minhaLista = new ArrayList<Produto>();
        
        while(rs.next()){
            Produto es = new Produto();
            Acesso a = new Acesso();
            es.setId(Integer.valueOf(rs.getInt("id")));
            es.setNome(rs.getString("Nome"));
            es.setPreco(Float.valueOf(rs.getFloat("Preco")));
            es.setMarca(rs.getString("Marca"));
            es.setQuantidade(Integer.valueOf(rs.getInt("Quantidade")));
            a.setLogin(rs.getString("FuncionarioSoli"));
            
            minhaLista.add(es);   
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }
        
    public void ValidarSenha(ValidacaoLogin vl) throws Exception{
        String sql = "update Funcionarios set Id=?, Senha=? WHERE Id =?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
      
        stmt.setInt(1, vl.getId());
        stmt.setString(2, vl.getConfirmacao());
        stmt.setInt(3, vl.getId());

        stmt.execute();
        stmt.close();
    }   
    
    public List<Produto> getEsto (String Nome) throws SQLException{
        String sql = "select * from Produto where Nome ilike ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, Nome);

        ResultSet rs = stmt.executeQuery();
        
        List<Produto> minhaLista = new ArrayList<Produto>();
        
        while(rs.next()){
            Produto es = new Produto();
            Acesso a = new Acesso();
            es.setId(Integer.valueOf(rs.getInt("id")));
            es.setNome(rs.getString("Nome"));
            es.setPreco(Float.valueOf(rs.getFloat("Preco")));
            es.setMarca(rs.getString("Marca"));
            es.setQuantidade(Integer.valueOf(rs.getInt("Quantidade")));
            a.setLogin(rs.getString("FuncionarioSoli"));
            
            minhaLista.add(es);   
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }
    
//    public void imprimirRelatorio(){
//        HashMap map = new HashMap();
//        
//        try{
  //          JasperPrint impressao = JasperFillManager.fillReport(".\\report1.jasper",map,conexao);
  //          JasperViewer.viewReport(impressao, false);
  //          
  //      }catch(Exception e){
  //          JOptionPane.showMessageDialog(null, "Relatorio nao pode ser exibido","Aviso",JOptionPane.WARNING_MESSAGE);
  //          e.printStackTrace();
  //      }
  //  }
    

    
  
    
    public void registarTempo (TabelaTempo tt) throws Exception{
        String sql = "insert into tempo (Nome, Preco, Quantidade)" + "values (?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        
        stmt.setString(1,tt.getNome());
        stmt.setFloat(2,tt.getPreco());
        stmt.setInt(3, tt.getQuantidade());
        
        stmt.execute();
        stmt.close();
    }
    
    public List<TabelaTempo> getTemp (String Nome) throws SQLException{
        String sql = "select * from tempo where Nome ilike ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, Nome);

        ResultSet rs = stmt.executeQuery();
        
        List<TabelaTempo> minhaLista = new ArrayList<TabelaTempo>();
        
        while(rs.next()){
            TabelaTempo tt = new TabelaTempo();
            tt.setNome(rs.getString("Nome"));
            tt.setPreco(Float.valueOf(rs.getFloat("Preco")));
            tt.setQuantidade(Integer.valueOf(rs.getInt("Quantidade")));
            
            minhaLista.add(tt);   
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }
    
    
    public Acesso pegarNome(String Nome) throws Exception{
        Acesso a = new Acesso();
        String sql = "select * from Acesso where Login ilike ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, Nome);
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            a.setLogin(rs.getString("Login"));
            rs.close();
            stmt.close();
        } 
        return a;
    }
    
    public void excluirTemp() throws Exception{
        String sql = ("delete from tempo");
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }

// Testando Codigo ---------------------------------------------------------------
    public void insereTemp (TabelaTempo t) throws  Exception{
        String sql = "insert into HistoricoDeVendas (PrecoTotal,Produto,QuantidadeDeProduto) values (select Preco, Nome, Quantidade from tempo)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setFloat(1,t.getPreco());
        stmt.setString(2,t.getNome());
        stmt.setInt(3,t.getQuantidade());
        
        stmt.execute();
        stmt.close();
        
    }
    
    
    
    public void novoGerente (Funcionario f) throws Exception{
        String sql = "insert into Gerente (Nome, Login, CPF, CEP, Senha, Endereco, Numero, Complemento, Bairro, Cargo, Salario, Telefone1, Telefone2)" + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1,f.getNome());
        stmt.setString(2,f.getLogin());
        stmt.setString(3,f.getCPF());
        stmt.setString(4,f.getCEP());
        stmt.setString(5,f.getSenha());
        stmt.setString(6,f.getEndereco());
        stmt.setInt(7,f.getNumero());
        stmt.setString(8,f.getComplemento());
        stmt.setString(9,f.getBairro());
        stmt.setString(10,f.getCargo());
        stmt.setFloat(11,f.getSalario());
        stmt.setString(12,f.getTelefone1());
        stmt.setString(13,f.getTelefone2());
        stmt.execute();
        stmt.close();
    } 
    
  
    
}

