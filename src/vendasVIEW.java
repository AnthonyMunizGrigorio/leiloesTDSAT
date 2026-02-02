/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
.gitignore
/build/
/*.class

*/
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antho
 */

public class vendasVIEW extends JFrame {

    private final JTable listaVendas;
    private final JScrollPane scroll;
    private final JButton btnVoltar;
    private final JLabel lblTitulo;

    public vendasVIEW() {
        setTitle("Vendas");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblTitulo = new JLabel("Produtos Vendidos");
        lblTitulo.setBounds(20, 10, 200, 25);

        listaVendas = new JTable();
        listaVendas.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Nome", "Valor", "Status"}
        ));

        scroll = new JScrollPane(listaVendas);
        scroll.setBounds(20, 40, 450, 200);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 260, 80, 25);
        btnVoltar.addActionListener(e -> dispose());

        setLayout(null);
        add(lblTitulo);
        add(scroll);
        add(btnVoltar);

        listarVendas();
    }

    private void listarVendas() {
        try {
            ProdutosDAO produtosdao = new ProdutosDAO();
            DefaultTableModel model = (DefaultTableModel) listaVendas.getModel();
            model.setRowCount(0);

            ArrayList<ProdutosDTO> lista = produtosdao.listarProdutosVendidos();

            for (ProdutosDTO p : lista) {
                model.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getValor(),
                    p.getStatus()
                });
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar vendas");
        }
    }
}
