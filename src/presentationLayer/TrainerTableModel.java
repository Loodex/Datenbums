package presentationLayer;

import businessObjects.ITrainer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TrainerTableModel extends AbstractTableModel {

    private List<ITrainer> trainer;
    private List<Function<ITrainer, Object>> columnMappings;

    public TrainerTableModel(List<ITrainer> trainer,
                             List<Function<ITrainer, Object>> columnMappings) {
        this.trainer = trainer;
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        return columnMappings.get(columnIndex)
                .apply(trainer.get(rowIndex));
    }

}

