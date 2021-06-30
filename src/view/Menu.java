/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import model.Karyawan;
/**
 *
 * @author MSI - PC
 */
public class Menu extends JFrame implements ActionListener{
    
    JLabel ljudul = new JLabel("Main Menu");
    
    JButton btambah = new JButton("Tambah Karyawan");
    
    JButton blihat = new JButton("Lihat Karyawan");
    
    
    public Menu(){
        setSize(155,120);
        setLayout(null);
        add(ljudul);
        add(blihat);
        add(btambah);
        
        ljudul.setBounds(35,5,200,20);
        
         
        btambah.setBounds(0,25,150,20);
        blihat.setBounds(0,45,150,20);
        
        
        btambah.addActionListener(this);
        blihat.addActionListener(this);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
    }

    public void actionPerformed (ActionEvent e){
        if(e.getSource() == btambah){
           Lihat lh = new Lihat();
           lh.dispose();
           dispose();
           InputKaryawan ik = new InputKaryawan();
           Edit ed = new Edit();
           ed.dispose();
           Karyawan md = new Karyawan();
           Control ct = new Control(lh, md,ik,ed);
           
        }
        if(e.getSource() == blihat){
           Lihat lh = new Lihat();
           InputKaryawan ik = new InputKaryawan();
           ik.dispose();
           Edit ed = new Edit();
           ed.dispose();
           Karyawan md = new Karyawan();
           Control ct = new Control(lh, md,ik,ed);
        }
    }
}  
