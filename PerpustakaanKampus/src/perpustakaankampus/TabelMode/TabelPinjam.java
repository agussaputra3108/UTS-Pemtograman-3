/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaankampus.TabelMode;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import perpustakaankampus.Entitas.DataBuku;

public class TabelPinjam extends AbstractTableModel{
     List<DataBuku> list = new ArrayList<DataBuku>();
     
     public TabelPinjam(List list){
         this.list = list;
     }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex){
             case 0 : return list.get(rowIndex).getNim();
        case 1 : return list.get(rowIndex).getKodepinjam();
        case 2 : return list.get(rowIndex).getTanggalPinjam();
        case 3 : return list.get(rowIndex).getTanggalKembali();
        
        case 4 : return list.get(rowIndex).getKode();
        case 5 : return list.get(rowIndex).getJudul();
        
            
            default:
                return null;
    }
    }
    public DataBuku select(int index){
            return list.get(index);
        }
    
}
