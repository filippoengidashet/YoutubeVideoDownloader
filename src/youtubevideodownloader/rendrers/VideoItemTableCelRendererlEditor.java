/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubevideodownloader.rendrers;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import youtubevideodownloader.model.VideoInfo;

/**
 *
 * @author Filippo
 */
public class VideoItemTableCelRendererlEditor extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

    private final TableCellDelegate delegate = new TableCellDelegate();

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.delegate.setBackground(table.getSelectionBackground());
        return this.delegate.handleComponent((VideoInfo) value);
    }

    @Override
    public Object getCellEditorValue() {
        return this.delegate.getVideoInfo();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            this.delegate.setBackground(table.getSelectionBackground());
        } else {
            this.delegate.setBackground(table.getBackground());
        }
        return this.delegate.handleComponent((VideoInfo) value);
    }
}
