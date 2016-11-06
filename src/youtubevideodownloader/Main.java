/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubevideodownloader;

import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import youtubevideodownloader.api.YoutubeApi;
import youtubevideodownloader.helper.GzipRequestInterceptor;
import youtubevideodownloader.helper.LoggingInterceptor;

/**
 *
 * @author Filippo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .addNetworkInterceptor(new GzipRequestInterceptor())
                .build();

        GsonBuilder gb = new GsonBuilder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.youtube.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        YoutubeApi api = retrofit.create(YoutubeApi.class);
        //video_id=u8KoR8GfV6U&
        Call<ResponseBody> videoInfo = api.getVideoInfo("CpM33xnx2TI");
        videoInfo.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> rspns) {

                ResponseBody body = rspns.body();

                if (body != null) {
                    try {
                        GZIPInputStream gzipInputStream = new GZIPInputStream(body.byteStream());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(gzipInputStream, "UTF-8"));
                        String line;
                        StringBuilder builder = new StringBuilder();
                        while ((line = reader.readLine()) != null) {
                            builder.append(line);
                        }
                        String rawText = builder.toString();

                        //System.out.println(rawText);
                        StringTokenizer tokenizer = new StringTokenizer(rawText, "&");
                        while (tokenizer.hasMoreTokens()) {
                            String keyVal = tokenizer.nextToken();

                            if (keyVal.contains("url_encoded_fmt_stream_map")) {
                                //String decode = URLDecoder.decode(keyVal, "UTF-8").replace("+", "");

                                String output1 = URLDecoder.decode(keyVal, "UTF-8");
                                String output2 = URLDecoder.decode(output1, "UTF-8");
                                String output3 = URLDecoder.decode(output2, "UTF-8");

                                //System.out.println(output3);
                                
//                                StringTokenizer videoInfoTokens = new StringTokenizer(output3, "&url=");
//                                int logic = 0;
//                                while (videoInfoTokens.hasMoreTokens()) {
//                                    String nextToken = videoInfoTokens.nextToken();
//                                    if(logic == 0) {
//                                        System.out.print("Key: " + nextToken);
//                                        logic = 1;
//                                    } else {
//                                        System.out.println("\tValue: " + nextToken);
//                                        logic = 0;
//                                    }
//                                }
                                
                                String[] urls = output2.split("&url=");
                                for(String url: urls) {
                                    System.out.println("\n"+url.replace("\"", ""));
                                }
                            }

//                            StringTokenizer keyValTokenizer = new StringTokenizer(keyVal, "=");
//                            int count = 0;
//                            while (keyValTokenizer.hasMoreTokens()) {
//                                String nextToken = keyValTokenizer.nextToken();
//                                if ("url_encoded_fmt_stream_map".equalsIgnoreCase(nextToken)) {
//                                    //System.out.println(nextToken);
//                                }
////                                if(count == 0) System.out.print("Key: " + nextToken);
////                                else System.out.print("\tValue: " + nextToken);
////                                count++;
//                            }
                            //System.out.println();
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable thrwbl) {
                System.err.println("Error " + thrwbl.getMessage());
            }
        });

    }
}
