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

    public String[] getColumnNames()
    {
        return columnNames;
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

    public void removeRow(int row)
    {
        Object[][] newData = new Object[data.length - 1][columnNames.length];
        int j = 0;
        for (int i = 0; i < data.length; i++)
        {
            if (i == row)
            {
                i++;
            }
            if (i < data.length)
            {
                newData[j] = data[i];
                j++;
            }
        }
        data = newData;
    }

    public Object[] getRow(int rowIndex)
    {
        return data[rowIndex];
    }
    
    public void addRow(Object[] row)
    {
        Object[][] newData = new Object[data.length + 1][columnNames.length];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[newData.length - 1] = row;
        data = newData;
    }
    
    public Object[][] getData()
    {
        return data;
    }
}
