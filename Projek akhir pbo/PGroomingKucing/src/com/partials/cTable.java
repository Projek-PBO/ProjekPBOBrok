package com.partials;
import javax.swing.JTable;

public class cTable extends JTable {

  public cTable(javax.swing.table.TableModel dm)
  {
    super(dm);
    setFont(cFonts.FONT_RADIO);
    getTableHeader().setFont(cFonts.FONT_RADIO);
    getTableHeader().setBackground(cColor.ORANGE);
    getTableHeader().setForeground(cColor.WHITE);
    getTableHeader().setBorder(null);
    setBorder(null);
    setRowHeight(35);
    getTableHeader().setReorderingAllowed(false);
    setShowVerticalLines(true);
    setShowHorizontalLines(true);
    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    setDragEnabled(true);
    setSelectionBackground(cColor.ORANGE);
    setSelectionForeground(cColor.WHITE);
  }

  @Override
  public boolean isCellEditable(int row, int column){
    return false;
  }
  
}
