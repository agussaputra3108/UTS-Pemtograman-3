
package perpustakaankampus.Interface;

import java.sql.SQLException;
import java.util.List;
import perpustakaankampus.Entitas.DataBuku;

public interface  BukuInterface {
     public void connec()throws SQLException;
    public void disconnec()throws SQLException;
     public List read()throws SQLException;
     public List read2(String kode)throws SQLException;
      public List read3()throws SQLException;
       public List read4(String nim)throws SQLException;
       public List read5(String judul,String penerbit)throws SQLException;
     
    public void insert(DataBuku db) throws SQLException;
    public void insert2(DataBuku db) throws SQLException;
    public void delete(String kdoe)throws SQLException;
    public void delete2(String kdoe)throws SQLException;
}
