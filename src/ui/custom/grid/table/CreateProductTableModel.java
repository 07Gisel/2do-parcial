package ui.custom.grid.table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import data.models.CreateProduct;
import data.models.User;

public class CreateProductTableModel extends AbstractTableModel{
    private ArrayList<CreateProduct> createProduct;
    private String[] columns = {"Name", "Descripcion", "Tipo", "Precio"};
    public CreateProductTableModel(ArrayList<CreateProduct> createProduct) {
        this.createProduct = createProduct;
    }
    public void addRow(CreateProduct createProduct) {
        this.createProduct.add(createProduct);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.createProduct.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CreateProduct createProduct = this.createProduct.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return createProduct.getName();
            case 1:
                return createProduct.getDescripcion();
            case 2:
                return createProduct.getTipo();
            case 3:
                return createProduct.getPrecio();
            default:
                return null;
        }
    }
    
}
