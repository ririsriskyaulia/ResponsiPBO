/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import main.Main;
import model.Karyawan;
import view.*;
/**
 *
 * @author MSI - PC
 */
public class Control {
     Karyawan model;
    Lihat tampilView;
    InputKaryawan input;
    Edit edit;
    
    public Control(Lihat tampilview, Karyawan modell,InputKaryawan inputk, Edit editt){
        this.model = modell;
        this.tampilView = tampilview;
        this.input = inputk;
        this.edit = editt;
        
        if(model.getBanyakData()!=0){
            String dataKaryawan[][] = model.readContact();
            tampilView.tabel.setModel((new JTable(dataKaryawan, tampilView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        input.bsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nama = input.getNama();
                String usia = input.getUsia();
                String gaji =input.getGaji();
                model.insert(nama, usia, gaji);
         
                String dataKaryawan[][] = model.readContact();
                tampilView.tabel.setModel((new JTable(dataKaryawan, tampilView.namaKolom)).getModel());
            }
        });
         input.bkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.dispose();
                Menu m = new Menu();
                   
            }
        });
         
        input.breset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.fnama.setText(null);
                input.fusia.setText(null);  
                input.fgaji.setText(null);
            }
        });
        edit.bkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.dispose();
                

            }
        });
        tampilView.bkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilView.dispose();

            }
        });
        edit.bupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = edit.getNama();
                String cek = edit.getCek();
                String usia = edit.getUsia();
                String gaji =edit.getGaji();
                model.update(nama,cek, usia, gaji);
                edit.dispose();
            }
        });
        edit.bhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String cek = edit.getCek();
                model.delete(cek);
                edit.dispose();
            }
        });
              tampilView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = tampilView.tabel.getSelectedRow();
                
                String id = tampilView.tabel.getValueAt(baris, 0).toString();
                String nama = tampilView.tabel.getValueAt(baris, 1).toString();
                String usia = tampilView.tabel.getValueAt(baris, 2).toString();
                String gaji = tampilView.tabel.getValueAt(baris, 3).toString();
                
                tampilView.dispose();
                Edit ed = new Edit();
                ed.fnama.setText(nama);
                ed.fcek.setText(id);
                ed.fusia.setText(usia);
                ed.fgaji.setText(gaji);
                Lihat lh = new Lihat();
                lh.dispose();
                InputKaryawan ik = new InputKaryawan();
                ik.dispose();
                Karyawan md = new Karyawan();
                Control ct = new Control(lh,md,ik,ed);
                System.out.println("");
                        
            }
        }
        );
    }
}
