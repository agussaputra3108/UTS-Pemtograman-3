
package perpustakaankampus.TabelMode;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import perpustakaankampus.Entitas.DataBuku;

public class BukuTabel extends AbstractTableModel{
     List<DataBuku> list = new ArrayList<DataBuku>();
     
     public BukuTabel(List list){
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
        case 0 : return list.get(rowIndex).getKode();
        case 1 : return list.get(rowIndex).getJudul();
        case 2 : return list.get(rowIndex).getPengarang();
        case 3 : return list.get(rowIndex).getPenerbit();
        case 4 : return list.get(rowIndex).getTempat();
        case 5 : return list.get(rowIndex).getTahun();
            
            default:
                return null;
    }
    
}
    public String getColumnname( int column){
        switch(column){
            case 0 : return "kode";
            case 1 : return "judul";
            case 2 : return "pengarang";
            case 3 : return "penerbit";
            case 4 : return "tempat";
            case 5 : return "tahun";
                default:
                    return null;
            
        }
        }
        public DataBuku select(int index){
            return list.get(index);
        }
}
