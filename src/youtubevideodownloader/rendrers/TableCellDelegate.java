/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubevideodownloader.rendrers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.table.TableCellEditor;
import youtubevideodownloader.model.VideoInfo;
import youtubevideodownloader.ui.VideoItemDetailView;

/**
 *
 * @author Filippo
 */
public class TableCellDelegate {

    private final VideoItemDetailView panelView;
    private VideoInfo videoInfo;

    public TableCellDelegate() {
        this.panelView = new VideoItemDetailView();
        this.panelView.setOpaque(false);
    }

    public Component handleComponent(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
        panelView.setVideoViewCounter(videoInfo.getVideoTitle());
        return this.panelView;
    }

    public VideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public void setBackground(Color background) {
        this.panelView.setBackground(background);
    }
}
