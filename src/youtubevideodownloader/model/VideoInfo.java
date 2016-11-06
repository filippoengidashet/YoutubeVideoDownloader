/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubevideodownloader.model;

import java.util.Random;

/**
 *
 * @author Filippo
 */
public class VideoInfo {
    
    private String videoTitle;

    public VideoInfo(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoTitle() {
        return videoTitle;
    }
    
    @Override
    public String toString() {
        return "My video info";
    }
    
    
}
