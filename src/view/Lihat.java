/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import main.Main;
/**
 *
 * @author MSI - PC
 */
public class Lihat extends JFrame {
    
    
    JFrame frame = new JFrame("JDBC");
    public JTable tabel;
    DefaultTableModel model;
    JScrollPane scrollPanel;
    String data[][] = new String[500][4];
    public Object namaKolom[] = {"ID", "Nama", "Usia", "Gaji"};
    
    public JButton bkembali = new JButton("KEMBALI");
    
    
    public Lihat(){
        setTitle("Data Karyawan");
        setSize(750, 300);
        setLayout(null);
        add(bkembali);
        model = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(model);
        scrollPanel = new JScrollPane(tabel);
        
        scrollPanel = new JScrollPane(tabel);
        add(scrollPanel);
        
        scrollPanel.setBounds(15, 15, 700, 100);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        bkembali.setBounds(20, 200,700, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
