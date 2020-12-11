/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamhs;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Array {
        ArrayList<String> Nama = new ArrayList<>();
        ArrayList<String> NIM = new ArrayList<>();
        ArrayList<Date> Tgl = new ArrayList<>();
        ArrayList<Integer> Gender = new ArrayList<>();
        Scanner in = new Scanner(System.in);
    
    void Menu()throws ParseException {
        System.out.println("------------------");
        System.out.println("Menu :");
        System.out.println("------------------");
        System.out.println("1. Tambah Data");
        System.out.println("2. Hapus Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Tampil Data");
        System.out.println("5. Keluar");
        System.out.print("Pilihan Menu : ");
        String Menu = in.nextLine();
        switch (Menu){
            case "1":
                TambahData();
                break;
            case "2":
                HapusData();
                break;
            case "3":
                CariData();
                break;
            case "4":
                TampilData();
                break;
            case "5":
                System.exit(0);
            default:
                Menu();
        }
}   
    void TambahData()throws ParseException{
        System.out.println("----------------");
        System.out.println("Tambah Data   : ");
        System.out.println("----------------");
        System.out.print  ("Masukkan Nama : ");
        String nama = in.nextLine();
        System.out.print  ("Masukkan NIM  : ");
        String nim = in.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat( "dd-mm-yyyy" );
        System.out.print  ("Masukkan Tgl Lahir (dd-mm-yyyy): ");
        String tgl = in.nextLine();
        Date date = sdf.parse(tgl);
        Tgl.add(date);
        System.out.print  ("Masukkan Gender (0 untuk Pria dan 1 untuk Wanita) : ");
        int gender = in.nextInt();
        Nama.add(nama);
        NIM.add(nim);
        Gender.add(gender);
        System.out.println(Nama);
        System.out.println(NIM);
        System.out.println(Tgl);
        System.out.println(Gender);
        System.out.println("Ulangi ? ");
            String ulangi = in.nextLine();
            if (ulangi.equals("y")){
                TambahData();
            }else{
                Menu();
    }
    }
    void HapusData()throws ParseException{
        System.out.println("----------------");
        System.out.println("Hapus Data   :  ");
        System.out.println("----------------");
        System.out.print  ("Masukkan NIM  : ");
        String cari_NIM = in.next();
        int index_pencarian = NIM.indexOf (cari_NIM);
        if (index_pencarian == -1){
            System.out.println("NIM Tidak ditemukan");
    }
        else{
            System.out.println("Data Telah dihapus");
            Nama.remove(index_pencarian);
            NIM.remove(index_pencarian);
            Tgl.remove(index_pencarian);
            Gender.remove(index_pencarian);                 
    }
            System.out.println(Nama);
            System.out.println(NIM);
            System.out.println(Tgl);
            System.out.println(Gender);
            System.out.println("Ulangi ? ");
                    String ulangi = in.nextLine();
                if (ulangi.equals("y")){
                    HapusData();
                }else{
                    Menu();
        }
    }
    void CariData()throws ParseException{
        System.out.println("----------------");
        System.out.println("Cari Data   :   ");
        System.out.println("----------------");
        System.out.println("a. Gender");
        System.out.println("b. NIM");
        System.out.print  ("Pilih Cari Dengan : ");
        String cari1 = in.nextLine();
        ArrayList<Integer> Cariin = new ArrayList<>();
        if (cari1.equals("a")){
           System.out.println("Masukan jenis gender (0 untuk Pria dan 1 untuk Wanita)");
           String cari2 = in.nextLine();
           int cari3 = Integer.parseInt(cari2);
           int i;
           ArrayList<Integer> cari4  = new ArrayList<>();
            for (i = 0; i < Gender.size(); i++) {
                int index_cari = Gender.get(i);
                if (cari3 == (index_cari)) {
                    System.out.println("Nama : " + Nama.get(i));
                    System.out.println("NIM  : " + NIM.get(i));
                    System.out.println("Tgl Lahir : " + Tgl.get(i));
                        Cariin.add(1);
                    }
                    else if (cari3 != (index_cari)){
                    }
                    else if (!Cariin.contains(1)){
                        System.out.println("Tidak ditemukan");
                        CariData();
                    }
           
            }        
        }
                else if (cari1.equals ("b")){
            System.out.println("Masukan NIM : ");
            String cari_NIM = in.nextLine();
            int Cariin2 = NIM.indexOf(cari_NIM);
                if(Cariin2 == -1){
                System.out.println(cari_NIM + " Tidak Ditemukan");
                CariData();
        }else{
            System.out.println("Nama : " + Nama.get(Cariin2));
            System.out.println("NIM  : " + NIM.get(Cariin2));
            System.out.println("Tgl Lahir : " + Tgl.get(Cariin2));
        }
            }
        Menu();
}
    void TampilData() throws ParseException {
        System.out.println("--------------");
        System.out.println("Tampilkan Data");
        System.out.println("--------------");
        System.out.println("Jumlah Mhs  : "+ Nama.size());
        int i;
        for (i = 0; i < Nama.size(); i++){
            System.out.println("Nama : " + Nama.get(i));
            System.out.println("NIM  : " + NIM.get(i));
            System.out.println("Tgl Lahir : " + Tgl.get(i));
            System.out.println("Gender : " + Gender.get(i));
        }
        Menu();
    }
}   

