package auxiliar;

import javax.swing.table.DefaultTableModel;

	public class MiModelo extends DefaultTableModel{
		public boolean isCellEditable (int row, int column)
			
		   {
		       // Aquí devolvemos true o false según queramos que una celda
		       // identificada por fila,columna (row,column), sea o no editable
		       if (column >= 0) {
		          return false;}
		       return true;
		   }
}
