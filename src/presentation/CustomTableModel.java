package presentation;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cristian
 */
public class CustomTableModel extends AbstractTableModel
{

    private String[] columnNames = null;
    private Object[][] data = null;

    public CustomTableModel(Object[][] data, String[] columnNames)
    {
        this.data = data;
        this.columnNames = columnNames;
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return data.length;
    }

    @Override
    public String getColumnName(int col)
    {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        return data[row][col];
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}
