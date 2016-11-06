/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubevideodownloader.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Filippo
 */
public class VideoInfoTableModel extends AbstractTableModel {

    private List<VideoInfo> videoInfos = new ArrayList<>();

    public VideoInfoTableModel(List<VideoInfo> feeds) {
        this.videoInfos = feeds;
    }

    @Override
    public Class<? extends Object> getColumnClass(int c) {
        return getValueAt(0, 0).getClass();
//        if (object == null) {
//            return Object.class;
//
//        }
//        if (object instanceof VideoInfo) {
//            return VideoInfo.class;
//        } else {
//            return object.getClass();
//        }
    }
        //    
    //    public Class getColumnClass(int columnIndex) {
    //        return VideoInfo.class;
    //        
    //        
    //    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "Video List";
    }

    @Override
    public int getRowCount() {
        return this.videoInfos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.videoInfos.get(rowIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void addRow(VideoInfo videoInfo) {
        this.videoInfos.add(videoInfo);
    }
}
