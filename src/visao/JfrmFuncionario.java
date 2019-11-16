package visao;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;
import dao.Banco;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Funcionario;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Inativos;


public class JfrmFuncionario extends javax.swing.JFrame {
    
    DefaultTableModel tmFuncionario = new DefaultTableModel(null, new String[]{"Nome","CPF","Cargo","Telefone"});
    List<Funcionario> funcionarios;
    ListSelectionModel lsmFuncionario;
    
    
    private void mostraPesquisa(List<Funcionario> funcionarios){
        while (tmFuncionario.getRowCount() > 0){
            tmFuncionario.removeRow(0);
        }
        if(funcionarios.size() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum Funcionario Cadastrado");
        }else{
            String[] linha = new String[]{null, null, null, null};
            for(int i = 0; i < funcionarios.size(); i++){
                tmFuncionario.addRow(linha);
                tmFuncionario.setValueAt(funcionarios.get(i).getNome(),i,0);
                tmFuncionario.setValueAt(funcionarios.get(i).getCargo(),i,1);
                tmFuncionario.setValueAt(funcionarios.get(i).getEndereco(),i,2);
                tmFuncionario.setValueAt(funcionarios.get(i).getTelefone1(),i,3);
            }
        }
    }
    
    public void ListarFuncionario() throws Exception {
        Banco dao = new Banco();
        funcionarios = dao.getLista("%" + txtNome.getText() + "%");
        mostraPesquisa(funcionarios);
    }
    
    private void tblFuncionariosLinhaSelecionada(JTable tabela){
        if(tblNomes.getSelectedRow() != -1){
            //habilitaDados();
            txtNome.setText(funcionarios.get(tabela.getSelectedRow()).getNome());
            txtLogin.setText(funcionarios.get(tabela.getSelectedRow()).getLogin());
            txtCPF.setText(funcionarios.get(tabela.getSelectedRow()).getCPF());
            txtSenha.setText(funcionarios.get(tabela.getSelectedRow()).getSenha());
            txtCEP.setText(funcionarios.get(tabela.getSelectedRow()).getCEP());
            txtEndereco.setText(funcionarios.get(tabela.getSelectedRow()).getEndereco());
            txtNumero.setText(String.valueOf(funcionarios.get(tabela.getSelectedRow()).getNumero()));
            txtComplemento.setText(funcionarios.get(tabela.getSelectedRow()).getComplemento());
            txtBairro.setText(funcionarios.get(tabela.getSelectedRow()).getBairro());
            txtCargo.setText(funcionarios.get(tabela.getSelectedRow()).getCargo());
            txtSalario.setText(String.valueOf(funcionarios.get(tabela.getSelectedRow()).getSalario()));
            txtTelefone1.setText(funcionarios.get(tabela.getSelectedRow()).getTelefone1());
            txtTelefone2.setText(funcionarios.get(tabela.getSelectedRow()).getTelefone2());
        }else{
            //LimparDados();
        }
    }
    
    public JfrmFuncionario() {
        initComponents();
        txtId.setVisible(false);
        btnConsultarCep.setVisible(false);
        btnPesquisar.setVisible(false);
        btnConfirmar.setVisible(false);
        lblNome.setVisible(false);
        txtNome.setVisible(false);
        lblCPF.setVisible(false);
        txtCPF.setVisible(false);
        lblCEP.setVisible(false);
        txtCEP.setVisible(false);
        lblEndereco.setVisible(false);
        txtEndereco.setVisible(false);
        lblCargo.setVisible(false);
        txtCargo.setVisible(false);
        lblSalario.setVisible(false);
        txtSalario.setVisible(false);
        lblBairro.setVisible(false);
        txtBairro.setVisible(false);
        lblComplemento.setVisible(false);
        txtComplemento.setVisible(false);
        lblLogin.setVisible(false);
        txtLogin.setVisible(false);
        lblNumero.setVisible(false);
        txtNumero.setVisible(false);
        lblTelefone.setVisible(false);
        txtTelefone1.setVisible(false);
        txtTelefone2.setVisible(false);
        tblNomes.setVisible(false);
        jScrollPane1.setVisible(false);
        txtSenha.setVisible(false);
        lblSenha.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        lblTelefone = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNomes = new javax.swing.JTable();
        lblSenha = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnConsultarCep = new javax.swing.JButton();
        txtCPF = new javax.swing.JFormattedTextField();
        txtCEP = new javax.swing.JFormattedTextField();
        txtTelefone1 = new javax.swing.JFormattedTextField();
        txtTelefone2 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciar Funcionários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jComboBox1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Novo Funcionário", "Editar Funcionário", "Excluir Funcionário" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Escolha a opção desejada:");

        lblNome.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblNome.setText("Nome:*");

        txtNome.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtNome.setForeground(new java.awt.Color(153, 153, 153));

        lblCPF.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblCPF.setText("CPF:*");

        lblEndereco.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblEndereco.setText("Endereço:*");

        lblCEP.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblCEP.setText("CEP:*");

        lblCargo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblCargo.setText("Cargo:*");

        lblSalario.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblSalario.setText("Salario:*");

        txtEndereco.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtEndereco.setForeground(new java.awt.Color(153, 153, 153));

        txtCargo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtCargo.setForeground(new java.awt.Color(153, 153, 153));

        txtSalario.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtSalario.setForeground(new java.awt.Color(153, 153, 153));
        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(0, 102, 51));
        btnConfirmar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseExited(evt);
            }
        });
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(255, 0, 0));
        btnVoltar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnPesquisar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar Funcionário");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblTelefone.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblTelefone.setText("Telefone:*");

        lblLogin.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblLogin.setText("Login:*");

        txtLogin.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(153, 153, 153));

        lblNumero.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblNumero.setText("Número:*");

        lblComplemento.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblComplemento.setText("Complemento:*");

        lblBairro.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblBairro.setText("Bairro:*");

        txtNumero.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(153, 153, 153));

        txtComplemento.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtComplemento.setForeground(new java.awt.Color(153, 153, 153));

        txtBairro.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtBairro.setForeground(new java.awt.Color(153, 153, 153));

        tblNomes.setModel(tmFuncionario);
        tblNomes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmFuncionario = tblNomes.getSelectionModel();
        lsmFuncionario.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    tblFuncionariosLinhaSelecionada(tblNomes);
                }
            }
        });
        jScrollPane1.setViewportView(tblNomes);

        lblSenha.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblSenha.setText("Senha:*");

        txtId.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(153, 153, 153));

        txtSenha.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        btnConsultarCep.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnConsultarCep.setText("Consultar CEP");
        btnConsultarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCepActionPerformed(evt);
            }
        });

        txtCPF.setForeground(new java.awt.Color(153, 153, 153));
        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        txtCEP.setForeground(new java.awt.Color(153, 153, 153));
        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCEP.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        txtTelefone1.setForeground(new java.awt.Color(153, 153, 153));
        try {
            txtTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        txtTelefone2.setForeground(new java.awt.Color(153, 153, 153));
        try {
            txtTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCPF)
                            .addComponent(lblCEP))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEndereco))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblBairro)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumero)
                            .addComponent(lblCargo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsultarCep))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(lblComplemento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSalario)
                                        .addGap(21, 21, 21)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(txtSalario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTelefone))
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTelefone2)
                                .addComponent(txtTelefone1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblLogin)
                                    .addComponent(lblSenha))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnPesquisar)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCPF)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSenha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCEP)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEndereco))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConsultarCep)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero)
                    .addComponent(lblBairro)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargo)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedIndex()==0){
            jScrollPane1.setVisible(false);
            tblNomes.setVisible(false);
            btnPesquisar.setVisible(false);
            btnVoltar.setVisible(true);
            btnConfirmar.setVisible(false);
            lblNome.setVisible(false);
            txtNome.setVisible(false);
            lblBairro.setVisible(false);
            txtBairro.setVisible(false);
            lblCEP.setVisible(false);
            txtCEP.setVisible(false);
            lblCPF.setVisible(false);
            txtCPF.setVisible(false);
            lblCargo.setVisible(false);
            txtCargo.setVisible(false);
            lblComplemento.setVisible(false);
            txtComplemento.setVisible(false);
            lblEndereco.setVisible(false);
            txtEndereco.setVisible(false);
            lblLogin.setVisible(false);
            txtLogin.setVisible(false);
            lblNumero.setVisible(false);
            txtNumero.setVisible(false);
            lblSalario.setVisible(false);
            txtSalario.setVisible(false);
            lblSenha.setVisible(false);
            txtSenha.setVisible(false);
            lblTelefone.setVisible(false);
            txtTelefone1.setVisible(false);
            txtTelefone2.setVisible(false);
            btnConsultarCep.setVisible(false);
            txtNome.setText("");
            txtLogin.setText("");
            txtCPF.setText("");
            txtCEP.setText("");
            txtSenha.setText("");
            txtEndereco.setText("");
            txtNumero.setText("");
            txtComplemento.setText("");
            txtBairro.setText("");
            txtCargo.setText("");
            txtSalario.setText("");
            txtTelefone1.setText("");
            txtTelefone2.setText("");
        }else{
            if(jComboBox1.getSelectedIndex()==1){
                btnPesquisar.setVisible(false);
                btnVoltar.setVisible(true);
                btnConfirmar.setVisible(true);
                lblNome.setVisible(true);
                txtNome.setVisible(true);
                lblBairro.setVisible(true);
                txtBairro.setVisible(true);
                lblCEP.setVisible(true);
                txtCEP.setVisible(true);
                lblCPF.setVisible(true);
                txtCPF.setVisible(true);
                lblCargo.setVisible(true);
                txtCargo.setVisible(true);
                lblComplemento.setVisible(true);
                txtComplemento.setVisible(true);
                lblEndereco.setVisible(true);
                txtEndereco.setVisible(true);
                lblLogin.setVisible(true);
                txtLogin.setVisible(true);
                lblNumero.setVisible(true);
                txtNumero.setVisible(true);
                lblSalario.setVisible(true);
                txtSalario.setVisible(true);
                lblSenha.setVisible(true);
                txtSenha.setVisible(true);
                lblTelefone.setVisible(true);
                txtTelefone1.setVisible(true);
                txtTelefone2.setVisible(true);
                jScrollPane1.setVisible(true);
                tblNomes.setVisible(false);
                btnConsultarCep.setVisible(true);
                txtEndereco.disable();
                txtBairro.disable();    
                txtCEP.enable();
                txtCPF.enable();
                txtCargo.enable();
                txtComplemento.enable();
                txtLogin.enable();
                txtNome.enable();
                txtNumero.enable();
                txtSalario.enable();
                txtSenha.enable();
                txtTelefone1.enable();
                txtTelefone2.enable();
                txtNome.setText("");
                txtLogin.setText("");
                txtCPF.setText("");
                txtCEP.setText("");
                txtSenha.setText("");
                txtEndereco.setText("");
                txtNumero.setText("");
                txtComplemento.setText("");
                txtBairro.setText("");
                txtCargo.setText("");
                txtSalario.setText("");
                txtTelefone1.setText("");
                txtTelefone2.setText("");
            }else{
                if(jComboBox1.getSelectedIndex()==2){
                    btnPesquisar.setVisible(true);
                    btnVoltar.setVisible(true);
                    btnConfirmar.setVisible(true);
                    lblNome.setVisible(true);
                    txtNome.setVisible(true);
                    lblBairro.setVisible(true);
                    txtBairro.setVisible(true);
                    lblCEP.setVisible(true);
                    txtCEP.setVisible(true);
                    lblCPF.setVisible(true);
                    txtCPF.setVisible(true);
                    lblCargo.setVisible(true);
                    txtCargo.setVisible(true);
                    lblComplemento.setVisible(true);
                    txtComplemento.setVisible(true);
                    lblEndereco.setVisible(true);
                    txtEndereco.setVisible(true);
                    lblLogin.setVisible(true);
                    txtLogin.setVisible(true);
                    lblNumero.setVisible(true);
                    txtNumero.setVisible(true);
                    lblSalario.setVisible(true);
                    txtSalario.setVisible(true);
                    lblSenha.setVisible(true);
                    txtSenha.setVisible(true);
                    lblTelefone.setVisible(true);
                    txtTelefone1.setVisible(true);
                    txtTelefone2.setVisible(true);
                    jScrollPane1.setVisible(true);
                    tblNomes.setVisible(true);
                    btnConsultarCep.setVisible(false);
                    txtBairro.enable();
                    txtCEP.enable();
                    txtCPF.enable();
                    txtCargo.enable();
                    txtEndereco.enable();
                    txtComplemento.enable();
                    txtLogin.enable();
                    txtNome.enable();
                    txtNumero.enable();
                    txtSalario.enable();
                    txtSenha.enable();
                    txtTelefone1.enable();
                    txtTelefone2.enable();
                    txtNome.setText("");
                    txtLogin.setText("");
                    txtCPF.setText("");
                    txtCEP.setText("");
                    txtSenha.setText("");
                    txtEndereco.setText("");
                    txtNumero.setText("");
                    txtComplemento.setText("");
                    txtBairro.setText("");
                    txtCargo.setText("");
                    txtSalario.setText("");
                    txtTelefone1.setText("");
                    txtTelefone2.setText("");
                }else{
                    if(jComboBox1.getSelectedIndex()==3){
                         btnPesquisar.setVisible(true);
                        btnVoltar.setVisible(true);
                        btnConfirmar.setVisible(true);
                        lblNome.setVisible(true);
                        txtNome.setVisible(true);
                        lblBairro.setVisible(true);
                        txtBairro.setVisible(true);
                        lblCEP.setVisible(true);
                        txtCEP.setVisible(true);
                        lblCPF.setVisible(true);
                        txtCPF.setVisible(true);
                        lblCargo.setVisible(true);
                        txtCargo.setVisible(true);
                        lblComplemento.setVisible(true);
                        txtComplemento.setVisible(true);
                        lblEndereco.setVisible(true);
                        txtEndereco.setVisible(true);
                        lblLogin.setVisible(true);
                        txtLogin.setVisible(true);
                        lblNumero.setVisible(true);
                        txtNumero.setVisible(true);
                        lblSalario.setVisible(true);
                        txtSalario.setVisible(true);
                        lblSenha.setVisible(true);
                        txtSenha.setVisible(true);
                        lblTelefone.setVisible(true);
                        txtTelefone1.setVisible(true);
                        txtTelefone2.setVisible(true);
                        jScrollPane1.setVisible(true);
                        tblNomes.setVisible(true);
                        btnConsultarCep.setVisible(false);
                        txtBairro.disable();
                        txtCEP.disable();
                        txtCPF.disable();
                        txtCargo.disable();
                        txtEndereco.disable();
                        txtComplemento.disable();
                        txtLogin.disable();
                        txtNome.disable();
                        txtNumero.disable();
                        txtSalario.disable();
                        txtSenha.disable();
                        txtTelefone1.disable();
                        txtTelefone2.disable();
                        txtNome.setText("");
                        txtLogin.setText("");
                        txtCPF.setText("");
                        txtCEP.setText("");
                        txtSenha.setText("");
                        txtEndereco.setText("");
                        txtNumero.setText("");
                        txtComplemento.setText("");
                        txtBairro.setText("");
                        txtCargo.setText("");
                        txtSalario.setText("");
                        txtTelefone1.setText("");
                        txtTelefone2.setText("");
                    }
                }
            }
        }
 
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
       if(jComboBox1.getSelectedIndex()==1){
            try{
                Funcionario f = new Funcionario();
                f.setNome(txtNome.getText());
                f.setLogin(txtLogin.getText());
                f.setCPF(txtCPF.getText());
                f.setCEP(txtCEP.getText());
                f.setSenha(txtSenha.getText());
                f.setEndereco(txtEndereco.getText());
                f.setNumero(Integer.parseInt(txtNumero.getText()));
                f.setComplemento(txtComplemento.getText());
                f.setBairro(txtBairro.getText());
                f.setCargo(txtCargo.getText());
                f.setSalario(Float.parseFloat(txtSalario.getText()));
                f.setTelefone1(txtTelefone1.getText());
                f.setTelefone2(txtTelefone2.getText());
                Banco dao = new Banco(); 
                if(txtCargo.getText().equals("Supervisor")){;
                   dao.novoGerente(f);
                }else{
                   dao.novoFuncionario(f);
                }
                txtNome.setText("");
                txtLogin.setText("");
                txtCPF.setText("");
                txtCEP.setText("");
                txtSenha.setText("");
                txtEndereco.setText("");
                txtNumero.setText("");
                txtComplemento.setText("");
                txtBairro.setText("");
                txtCargo.setText("");
                txtSalario.setText("");
                txtTelefone1.setText("");
                txtTelefone2.setText("");
                JOptionPane.showMessageDialog(null,"Funcionário registrado com sucesso");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
       
        if(jComboBox1.getSelectedIndex()==2){
           try{
               int opcao = JOptionPane.showConfirmDialog(null,"Deseja Realizar alteração no registro ?","Atenção",JOptionPane.YES_NO_OPTION);
               if(opcao == JOptionPane.YES_OPTION){
                   Funcionario f = new Funcionario(); 
                   f.setId(Integer.valueOf(txtId.getText()));
                   f.setNome(txtNome.getText());
                   f.setLogin(txtLogin.getText());
                   f.setCPF(txtCPF.getText());
                   f.setCEP(txtCEP.getText());
                   f.setSenha(txtSenha.getText());
                   f.setEndereco(txtEndereco.getText());
                   f.setNumero(Integer.valueOf(txtNumero.getText()));
                   f.setComplemento(txtComplemento.getText());
                   f.setBairro(txtBairro.getText());
                   f.setCargo(txtCargo.getText());
                   f.setSalario(Float.valueOf(txtSalario.getText()));
                   f.setTelefone1(txtTelefone1.getText());
                   f.setTelefone2(txtTelefone2.getText());
                   Banco banco = new Banco();
                   banco.editarFuncionario(f);txtNome.setText("");
                    txtLogin.setText("");
                    txtCPF.setText("");
                    txtCEP.setText("");
                    txtSenha.setText("");
                    txtEndereco.setText("");
                    txtNumero.setText("");
                    txtComplemento.setText("");
                    txtBairro.setText("");
                    txtCargo.setText("");
                    txtSalario.setText("");
                    txtTelefone1.setText("");
                    txtTelefone2.setText("");  
                   JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso.");
                }else{
                   JOptionPane.showMessageDialog(null, "Alteração não realizada.");
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
       if(jComboBox1.getSelectedIndex()==3){
           try{
               Inativos f = new Inativos();
               f.setNome(txtNome.getText());
               f.setLogin(txtLogin.getText());
               f.setCPF(txtCPF.getText());
               f.setCEP(txtCEP.getText());
               f.setSenha(txtSenha.getText());
               f.setEndereco(txtEndereco.getText());
               f.setNumero(Integer.valueOf(txtNumero.getText()));
               f.setComplemento(txtComplemento.getText());
               f.setBairro(txtBairro.getText());
               f.setCargo(txtCargo.getText());
               f.setSalario(Float.valueOf(txtSalario.getText()));
               f.setTelefone1(txtTelefone1.getText());
               f.setTelefone2(txtTelefone2.getText());
               Banco banco = new Banco();
               banco.inativos(f);
               banco.excluirFuncionario(JOptionPane.showInputDialog("Informe o nome do funcioário a ser excluido do registro"));
               JOptionPane.showMessageDialog(null, "Registro excluido com sucesso.");
               
               
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
       }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnConfirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseEntered

    }//GEN-LAST:event_btnConfirmarMouseEntered

    private void btnConfirmarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseExited
      
    }//GEN-LAST:event_btnConfirmarMouseExited

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            ListarFuncionario();
        } catch (Exception ex) {
            Logger.getLogger(JfrmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*try{
            Banco banco = new Banco();
            Funcionario f = new Funcionario();
            f = banco.pesquisarFuncionarioNome(JOptionPane.showInputDialog("Informe o nome a ser Consultado"));
            
            txtId.setText(String.valueOf(f.getId()));
            txtNome.setText(f.getNome());
            txtLogin.setText(f.getLogin());
            txtCPF.setText(f.getCPF());
            txtCEP.setText(f.getCEP());
            txtSenha.setText(f.getSenha());
            txtEndereco.setText(f.getEndereco());
            txtNumero.setText(String.valueOf(f.getNumero()));
            txtComplemento.setText(f.getComplemento());
            txtBairro.setText(f.getBairro());
            txtCargo.setText(f.getCargo());
            txtSalario.setText(String.valueOf(f.getSalario()));
            txtTelefone1.setText(f.getTelefone1());
            txtTelefone2.setText(f.getTelefone2());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "erro");
        } */
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnConsultarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCepActionPerformed
        br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService service = new br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService();
        br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente port = service.getAtendeClientePort();
        
        try{
            String cep = txtCEP.getText();
            br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP result = port.consultaCEP(cep);
            
            
            txtEndereco.setText(result.getEnd() + ", "+ result.getUf() + "- " + result.getCidade());
            txtBairro.setText(result.getBairro());  
        }catch (SQLException_Exception | SigepClienteException e){
            JOptionPane.showMessageDialog(null, "Erro ao consultar CEP!","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarCepActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JfrmFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnConsultarCep;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTable tblNomes;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone1;
    private javax.swing.JFormattedTextField txtTelefone2;
    // End of variables declaration//GEN-END:variables

}
