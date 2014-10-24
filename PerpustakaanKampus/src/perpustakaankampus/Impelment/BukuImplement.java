
package perpustakaankampus.Impelment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import perpustakaankampus.Entitas.DataBuku;
import perpustakaankampus.Interface.BukuInterface;

public class BukuImplement implements BukuInterface{
    private String dbHost="jdbc:mysql://localhost:3306/perpus";
    private String dbUser="root";
    private String dbPass="";
    private Connection conn;
    
   public BukuImplement(){
            try {
                try {
                    
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception e) {
            }
                
                } catch (Exception e) {
                }
}
   public BukuImplement(Connection conn){
         this.conn = conn;
   }

    @Override
    public void connec() throws SQLException {
         this.conn = (Connection) DriverManager.getConnection(dbHost,dbUser,dbPass);
    }

    @Override
    public void disconnec() throws SQLException {
        this.conn.close();
    }

    @Override
    public List read() throws SQLException {
        java.sql.Statement st = conn.createStatement();
        String sql = "select *from databuku";
        ResultSet rs = st.executeQuery(sql);
        List list = new ArrayList();
        while (rs.next()) {
            DataBuku buku = new DataBuku();
            buku.setKode(rs.getString("kode"));
            buku.setJudul(rs.getString("judul"));
            buku.setPengarang(rs.getString("pengarang"));
            buku.setPenerbit(rs.getString("penerbit"));         
            buku.setTempat(rs.getString("tempat"));
            buku.setTahun(rs.getString("tahun"));
            list.add(buku);
        }
        return list;
    }

    @Override
    public void insert(DataBuku db) throws SQLException {
        String sql = "insert into databuku (kode,judul,pengarang,penerbit,tempat,tahun) values(?,?,?,?,?,?);";
        java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, db.getKode());
        ps.setString(2, db.getJudul());
        ps.setString(3, db.getPengarang());
        ps.setString(4, db.getPenerbit());
        ps.setString(5, db.getTempat());
        ps.setString(6, db.getTahun());
        ps.executeUpdate();
    }

    @Override
    public void delete(String kode) throws SQLException {
        String sql = "delete from databuku where kode=?";
        java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,kode);
        ps.executeUpdate();
    }

    public void delete3(String nim) throws SQLException {
        String sql = "delete from anggota where nim=?";
        java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,nim);
        ps.executeUpdate();
    }
    
    @Override
    public List read2(String kode) throws SQLException {
        java.sql.Statement st = conn.createStatement();
        String sql = "select *from databuku where kode='"+kode+"'";
        ResultSet rs = st.executeQuery(sql);
        List list = new ArrayList();
        while (rs.next()) {
            DataBuku pinjam = new DataBuku(); 
            pinjam.setKode(rs.getString("kode"));
            pinjam.setJudul(rs.getString("judul"));
            pinjam.setPengarang(rs.getString("pengarang"));
            pinjam.setPenerbit(rs.getString("penerbit"));
            pinjam.setTempat(rs.getString("tempat"));
            pinjam.setTahun(rs.getString("tahun"));
            list.add(pinjam);
            
        }
     return  list;   
    }

   

    
    @Override
    public void insert2(DataBuku db) throws SQLException {
        String sql = "insert into peminjaman (nim,kode,tanggalpinjam,tanggalkembali) values(?,?,?,?);";
        java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, db.getNim());
        ps.setString(2, db.getKodepinjam());
        ps.setDate(3,new java.sql.Date(db.getTanggalPinjam().getTime()));
        ps.setDate(4, new java.sql.Date(db.getTanggalKembali().getTime()));
        int executeUpdate = ps.executeUpdate();
        if(0 != executeUpdate){
           JOptionPane.showMessageDialog(null, "Anda Belum Mendaftar Sebagai Anggota"); 
        }
    }

    @Override
    public List read3() throws SQLException {
        java.sql.Statement st = conn.createStatement();
        String sql = "select *from peminjaman,databuku  where peminjaman.kode=databuku.kode";
        ResultSet rs = st.executeQuery(sql);
        List list = new ArrayList();
        while (rs.next()) {
            DataBuku buku = new DataBuku();
            buku.setNim(rs.getString("nim"));
            buku.setKodepinjam(rs.getString("kode"));
            buku.setTanggalPinjam(rs.getDate("tanggalpinjam"));
            buku.setTanggalkembali(rs.getDate("tanggalkembali"));
            buku.setKode(rs.getString("kode"));
            buku.setJudul(rs.getString("judul"));
            list.add(buku);
        }
        return list;
    }

    @Override
    public List read4(String nim) throws SQLException {
        java.sql.Statement st = conn.createStatement();
        String sql = "select *from peminjaman,databuku  where peminjaman.nim='"+nim+"' and peminjaman.kode=databuku.kode";
        ResultSet rs = st.executeQuery(sql);
        List list = new ArrayList();
        while (rs.next()) {
            DataBuku buku = new DataBuku();
            buku.setNim(rs.getString("nim"));
            buku.setKodepinjam(rs.getString("kode"));
            buku.setTanggalPinjam(rs.getDate("tanggalpinjam"));
            buku.setTanggalkembali(rs.getDate("tanggalkembali"));
            buku.setKode(rs.getString("kode"));
            buku.setJudul(rs.getString("judul"));
            list.add(buku);
        }
        return list;
    
    }

    @Override
    public List read5(String judul, String penerbit) throws SQLException {
        java.sql.Statement st = conn.createStatement();
        String sql = "select *from databuku where judul like '%"+judul+"%' and penerbit='"+penerbit+"'" ;
        ResultSet rs = st.executeQuery(sql);
        List list = new ArrayList();
        while (rs.next()) {
            DataBuku pinjam = new DataBuku(); 
            pinjam.setKode(rs.getString("kode"));
            pinjam.setJudul(rs.getString("judul"));
            pinjam.setPengarang(rs.getString("pengarang"));
            pinjam.setPenerbit(rs.getString("penerbit"));
            pinjam.setTempat(rs.getString("tempat"));
            pinjam.setTahun(rs.getString("tahun"));
            list.add(pinjam);
            
        }
     return  list;  
    }

    @Override
    public void delete2(String kdoe) throws SQLException {
        String sql = "delete from peminjaman where kode=?";
        java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,kdoe);
        ps.executeUpdate();
    }
    
}
