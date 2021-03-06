/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;
import BancoDeDados.Aluno;
import BancoDeDados.Conexao;
import carometro.Carometro;
import com.jcraft.jsch.SftpException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.Document;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Element;
/**
 *
 * @author Aluno
 */
public class TelaPrincipal extends JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PainelDiscussoes = new javax.swing.JPanel();
        PainelDiscussoesOrganizadas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PainelDiscussoesExpandidas = new javax.swing.JPanel();
        MostrarDiscussoesExpandidas = new javax.swing.JLabel();
        BotaoVoltarDiscussoesOrganizadas = new javax.swing.JButton();
        PainelOrganizacao = new javax.swing.JScrollPane();
        OrganizarDiscussoes = new javax.swing.JTree();
        PagAnterior1 = new javax.swing.JButton();
        ProxPagina1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PainelDiscussoes.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray), "Discussões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        PainelDiscussoes.setLayout(new java.awt.CardLayout());

        PainelDiscussoesOrganizadas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "Avaliação", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }
        jTable1.setColumnSelectionAllowed(false);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        TableRowSorter sorter = new TableRowSorter(jTable1.getModel());
        sorter.setComparator(3, new Ordena());
        jTable1.setRowSorter(sorter);

        mostraTopico = new MostraTopico();

        javax.swing.GroupLayout PainelDiscussoesOrganizadasLayout = new javax.swing.GroupLayout(PainelDiscussoesOrganizadas);
        PainelDiscussoesOrganizadas.setLayout(PainelDiscussoesOrganizadasLayout);
        PainelDiscussoesOrganizadasLayout.setHorizontalGroup(
            PainelDiscussoesOrganizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
        );
        PainelDiscussoesOrganizadasLayout.setVerticalGroup(
            PainelDiscussoesOrganizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );

        PainelDiscussoes.add(PainelDiscussoesOrganizadas, "listathreads");

        PainelDiscussoesExpandidas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));

        BotaoVoltarDiscussoesOrganizadas.setText("Voltar");

        javax.swing.GroupLayout PainelDiscussoesExpandidasLayout = new javax.swing.GroupLayout(PainelDiscussoesExpandidas);
        PainelDiscussoesExpandidas.setLayout(PainelDiscussoesExpandidasLayout);
        PainelDiscussoesExpandidasLayout.setHorizontalGroup(
            PainelDiscussoesExpandidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDiscussoesExpandidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelDiscussoesExpandidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MostrarDiscussoesExpandidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PainelDiscussoesExpandidasLayout.createSequentialGroup()
                        .addComponent(BotaoVoltarDiscussoesOrganizadas)
                        .addGap(0, 938, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PainelDiscussoesExpandidasLayout.setVerticalGroup(
            PainelDiscussoesExpandidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDiscussoesExpandidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MostrarDiscussoesExpandidas, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoVoltarDiscussoesOrganizadas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PainelDiscussoes.add(PainelDiscussoesExpandidas, "exibicao");

        OrganizarDiscussoes.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray), "Organizar por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Topicos");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Materias Ensino Medio");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Matemática");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Português");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Biologia");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Filosofia");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Geografia");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Historia");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Inglês");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Química");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Redação");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sociologia");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Educação Física");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Cursos Tecnicos");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Edificações");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Eletrônica");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Eletrotécnica");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Equipamentos Biomédicos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Estradas");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Informática");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Meio Ambiente");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Mecânica");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Mecatrônica");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Química");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Redes de Computadores");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Transportes e Trânsito");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Hospedagem");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Entretenimento");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Filmes");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Teatro");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Livros");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Jogos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Moda");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Duvidas Gerais");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Duvidas Gerais");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Assuntos Genericos");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Assuntos Genericos");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        OrganizarDiscussoes.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        OrganizarDiscussoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrganizarDiscussoes.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                OrganizarDiscussoesValueChanged(evt);
            }
        });
        PainelOrganizacao.setViewportView(OrganizarDiscussoes);

        PagAnterior1.setText("<< Página anterior");
        PagAnterior1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PagAnterior1MouseClicked(evt);
            }
        });

        ProxPagina1.setText("Próxima página >>");
        ProxPagina1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProxPagina1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainelOrganizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PagAnterior1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(366, 366, 366)
                        .addComponent(ProxPagina1))
                    .addComponent(PainelDiscussoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PainelDiscussoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelOrganizacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PagAnterior1)
                    .addComponent(ProxPagina1)
                    .addComponent(jLabel1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OrganizarDiscussoesValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_OrganizarDiscussoesValueChanged
        String texto = String.valueOf(evt.getPath());
        texto = texto.replace("[", "");
        texto = texto.replace("]", "");
        String[] path = texto.split(", ");
        if(path.length>2) {
            PainelDiscussoes.removeAll();
            PainelDiscussoes.add(PainelDiscussoesOrganizadas);
            PainelDiscussoes.revalidate();
            PainelDiscussoes.repaint();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for(int i = model.getRowCount() - 1; i > -1; i--) model.removeRow(i);
            
            
            try {
                Topicos topicos = new Topicos(String.valueOf(path[(path.length-1)]));
                for(int i=0; i<topicos.getQuantidade(); i++) {
                    model.addRow(new Object[]{topicos.getTitulo()[i], 
                    topicos.getAutor()[i], topicos.getAvaliacao()[i], 
                    topicos.getData()[i]});
                }
                mostraTopico.setCategoria(String.valueOf(path[(path.length-1)]));
                jLabel1.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_OrganizarDiscussoesValueChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRowIndex = jTable1.getSelectedRow();
        int selectedColumnIndex = jTable1.getSelectedColumn();
        String texto = (String) jTable1.getModel().getValueAt(
        selectedRowIndex, 0);
        mostraTopico.setTitulo(texto);
        try {
            mostraTopico.CarregaTopico();
            PainelDiscussoes.removeAll();
            PainelDiscussoes.add(mostraTopico);
            PainelDiscussoes.revalidate();
            PainelDiscussoes.repaint();
            jLabel1.setText("Página "+String.valueOf(mostraTopico.getPagAtual()));
            System.out.println(jTable1.getSelectedRow());
            System.out.println(jTable1.getRowSorter());
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void ProxPagina1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProxPagina1MouseClicked
        try {
            System.out.println("Hy");
            mostraTopico.CarregaPagina();
            PainelDiscussoes.removeAll();
            PainelDiscussoes.add(mostraTopico);
            PainelDiscussoes.revalidate();
            PainelDiscussoes.repaint();
            jLabel1.setText("Página "+String.valueOf(mostraTopico.getPagAtual()));
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SftpException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ProxPagina1MouseClicked

    private void PagAnterior1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PagAnterior1MouseClicked
        try {
            System.out.println("Hy7");
            mostraTopico.VoltaPagina();
            PainelDiscussoes.removeAll();
            PainelDiscussoes.add(mostraTopico);
            PainelDiscussoes.revalidate();
            PainelDiscussoes.repaint();
            jLabel1.setText("Página "+String.valueOf(mostraTopico.getPagAtual()));
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PagAnterior1MouseClicked
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
                //---------------------------------//
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoVoltarDiscussoesOrganizadas;
    private javax.swing.JLabel MostrarDiscussoesExpandidas;
    private javax.swing.JTree OrganizarDiscussoes;
    private javax.swing.JButton PagAnterior1;
    protected javax.swing.JPanel PainelDiscussoes;
    private javax.swing.JPanel PainelDiscussoesExpandidas;
    private javax.swing.JPanel PainelDiscussoesOrganizadas;
    private javax.swing.JScrollPane PainelOrganizacao;
    private javax.swing.JButton ProxPagina1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private MostraTopico mostraTopico;
    // End of variables declaration//GEN-END:variables
}
