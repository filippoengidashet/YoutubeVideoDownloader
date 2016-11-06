/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubevideodownloader.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 *
 * @author Filippo
 */
public interface YoutubeApi {
    
    @Headers({
        "Accept-Language: en-us,en;q=0.5",
        "Connection: Keep-Alive",
        "User-Agent: qwe/123",
        "Accept-Encoding: gzip",
        "Host: www.youtube.com",
        "Content-Type: application/x-www-form-urlencoded"
    })
    @GET("/get_video_info?el=vevo&ps=default&gl=US&hl=en&sts=17105")
    Call<ResponseBody> getVideoInfo(@Query("video_id") String videoId);
}


//http://www.youtube.com/get_video?video_id=JcZ6xrpO66o&t=i5L1UlQhPWzXv1vF166W0vbK7fCQkwtAUa_FUHnGAVs=&fmt=18&asv=2