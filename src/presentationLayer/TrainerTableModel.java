package presentationLayer;

import businessObjects.ITrainer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TrainerTableModel extends AbstractTableModel {

    private List<ITrainer> trainer;
    private List<String> columnNames;
    private List<Function<ITrainer, Object>> columnMappings;

    public TrainerTableModel(List<ITrainer> trainer,
                             List<String> columnNames,
                             List<Function<ITrainer, Object>> columnMappings) {
        this.trainer = trainer;
        this.columnNames = columnNames;
        this.columnMappings = columnMappings;
    }

    @Override
    public int getRowCount() {
        return trainer.size();
    }

    @Override
    public int getColumnCount() {
        return columnMappings.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return columnMappings.get(columnIndex)
                .apply(trainer.get(rowIndex));
    }

}

