/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package petshop.bd.Classes.Atendimento;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.bd.Banco.AtendimentoBD;

/**
 *
 * @author user
 */
public class MenuAtendimento extends javax.swing.JFrame {

    private final Connection conexao;
    private final AtendimentoBD atendimentoBD;
    private final DefaultTableModel modeloTabelaAtendimento;

    /**
     * Creates new form MenuAnimal
     *
     * @param conexao
     */
    public MenuAtendimento(Connection conexao) {
        this.conexao = conexao;
        initComponents();
        setLocationRelativeTo(null);
        modeloTabelaAtendimento = (DefaultTableModel) jTable2.getModel();
        atendimentoBD = new AtendimentoBD(this.conexao);
        carregarDadosNaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        botaoCadastrar = new javax.swing.JButton();
        botaoAjuda = new javax.swing.JButton();
        botaoBusca = new javax.swing.JButton();
        campoBusca = new javax.swing.JTextField();
        botaoVoltar = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("jLabel3");

        jMenuItem2.setLabel("Editar");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Eliminar");
        jPopupMenu1.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTÃO DE ATENDIMENTOS");
        jPanel4.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel5.setBackground(new java.awt.Color(0, 80, 80));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(346, 346, 346))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(210, 209, 209));
        jPanel3.setForeground(new java.awt.Color(0, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 2));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Lista de Atendimentos Cadastrados");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "ID do Animal", "CPF do Cliente", "Matrícula do Funcionário", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(102, 102, 102));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        botaoCadastrar.setBackground(new java.awt.Color(0, 51, 51));
        botaoCadastrar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        botaoCadastrar.setForeground(new java.awt.Color(242, 242, 242));
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.setIconTextGap(3);
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });
        botaoCadastrar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                botaoCadastrarPropertyChange(evt);
            }
        });

        botaoAjuda.setBackground(new java.awt.Color(229, 169, 97));
        botaoAjuda.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        botaoAjuda.setForeground(new java.awt.Color(51, 51, 0));
        botaoAjuda.setText("?");
        botaoAjuda.setIconTextGap(3);
        botaoAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAjudaActionPerformed(evt);
            }
        });

        botaoBusca.setBackground(new java.awt.Color(0, 102, 102));
        botaoBusca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoBusca.setForeground(new java.awt.Color(255, 255, 255));
        botaoBusca.setText("Busca");
        botaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscaActionPerformed(evt);
            }
        });

        campoBusca.setFont(new java.awt.Font("Agency FB", 0, 12)); // NOI18N
        campoBusca.setForeground(new java.awt.Color(102, 102, 102));
        campoBusca.setText("Digite o código");
        campoBusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoBuscaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoBuscaFocusLost(evt);
            }
        });
        campoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscaActionPerformed(evt);
            }
        });

        botaoVoltar.setBackground(new java.awt.Color(102, 102, 102));
        botaoVoltar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        botaoVoltar.setForeground(new java.awt.Color(255, 255, 255));
        botaoVoltar.setText("Voltar");
        botaoVoltar.setIconTextGap(3);
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        BotaoEditar.setBackground(new java.awt.Color(128, 80, 25));
        BotaoEditar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        BotaoEditar.setForeground(new java.awt.Color(242, 242, 242));
        BotaoEditar.setText("Editar");
        BotaoEditar.setIconTextGap(3);
        BotaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarActionPerformed(evt);
            }
        });
        BotaoEditar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                BotaoEditarPropertyChange(evt);
            }
        });

        botaoExcluir.setBackground(new java.awt.Color(153, 0, 0));
        botaoExcluir.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        botaoExcluir.setForeground(new java.awt.Color(242, 242, 242));
        botaoExcluir.setText("Excluir");
        botaoExcluir.setIconTextGap(3);
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });
        botaoExcluir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                botaoExcluirPropertyChange(evt);
            }
        });

        botaoAtualizar.setBackground(new java.awt.Color(39, 147, 147));
        botaoAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(botaoAjuda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoVoltar)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoBusca)
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoAtualizar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoAjuda))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        FormularioCadastroAtendimento formularioAtendimento = new FormularioCadastroAtendimento(conexao);
        formularioAtendimento.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoCadastrarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_botaoCadastrarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCadastrarPropertyChange

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased

    }//GEN-LAST:event_jTable2MouseReleased

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        int linhaSelecionada = jTable2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela", "Ërro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (model.getValueAt(linhaSelecionada, 0) == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha válida", "Ërro", JOptionPane.ERROR_MESSAGE);
        } else {
            Atendimento atendimento = new Atendimento();
            
            atendimento.setCodigo(Integer.parseInt(String.valueOf(model.getValueAt(linhaSelecionada, 0))));
            atendimento.setNome(String.valueOf(model.getValueAt(linhaSelecionada, 1)));
            atendimento.setEspecie(String.valueOf(model.getValueAt(linhaSelecionada, 2)));
            atendimento.setAltura(Float.parseFloat(String.valueOf(model.getValueAt(linhaSelecionada, 3))));
            atendimento.setPeso(Float.parseFloat(String.valueOf(model.getValueAt(linhaSelecionada, 4))));
            
            
            
            
            FormularioEdicaoAtendimento formularioEdicaoAtendimento = new FormularioEdicaoAtendimento(conexao, atendimento);
            formularioEdicaoAtendimento.setVisible(true);
        }
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void BotaoEditarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_BotaoEditarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoEditarPropertyChange

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoExcluirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_botaoExcluirPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoExcluirPropertyChange

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        carregarDadosNaTabela();
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscaActionPerformed
        try {
            Atendimento atendimento = atendimentoBD.consultar(Integer.parseInt(campoBusca.getText()));
            modeloTabelaAtendimento.setRowCount(0);
            if (atendimento != null) {
                Object[] novaLinha = {
                    atendimento.getCodigo(),
                    atendimento.getIdAnimal(),
                    atendimento.getCpfCliente(),
                    atendimento.getNumMatricula(),
                    atendimento.getData()
                };
                modeloTabelaAtendimento.addRow(novaLinha);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um código numérico válido para o atendimento.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
        campoBusca.setText("Digite o Código");
        campoBusca.setForeground(java.awt.Color.GRAY);

    }//GEN-LAST:event_botaoBuscaActionPerformed

    private void campoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscaActionPerformed

    private void campoBuscaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBuscaFocusGained
        if (campoBusca.getText().equals("Digite o Código")) {
            campoBusca.setText("");
            campoBusca.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_campoBuscaFocusGained

    private void campoBuscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBuscaFocusLost
        if (campoBusca.getText().equals("")) {
            campoBusca.setText("Digite o Código");
            campoBusca.setForeground(java.awt.Color.GRAY);
        }
    }//GEN-LAST:event_campoBuscaFocusLost

    private void botaoAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAjudaActionPerformed
        JOptionPane.showMessageDialog(null, "Para editar um atendimento, selecione a linha do atendimento na tabela e clique no botão editar", "Dica", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botaoAjudaActionPerformed

    private void carregarDadosNaTabela() {
        modeloTabelaAtendimento.setRowCount(0);

        try {
            ArrayList<Atendimento> atendimentos = atendimentoBD.consultarTodas();
            for (Atendimento atendimento : atendimentos) {
                Object[] novaLinha = {
                    atendimento.getCodigo(),
                    atendimento.getIdAnimal(),
                    atendimento.getCpfCliente(),
                    atendimento.getNumMatricula(),
                    atendimento.getData()
                };
                modeloTabelaAtendimento.addRow(novaLinha);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados dos atendimentos: " + e.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton botaoAjuda;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoBusca;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
