/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubevideodownloader.rendrers;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import youtubevideodownloader.model.VideoInfo;

/**
 *
 * @author Filippo
 */
public class VideoListCellRenderer extends DefaultListCellRenderer {

    private TableCellDelegate delegate = new TableCellDelegate();

    @Override
    public Component getListCellRendererComponent(JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean hasFocus) {
        return delegate.handleComponent((VideoInfo) value);
    }
}
