package org.example;

import okhttp3.*;
import java.io.IOException;

public class HttpDelete {
    public static void sendDeleteRequest(String tagId){
        OkHttpClient client = new OkHttpClient();

        String url = "http://api.example.com/resource/" + tagId;
        System.out.println(url);


        Request request = new Request.Builder().url(url).delete().build();

        try(Response response = client.newCall(request).execute()){
            System.out.println("Sending Request");
            if(response.isSuccessful()){
                System.out.println("DELETE request successful");
                System.out.println("Response: " + response.body().string());
            }else{
                System.out.println("DELETE request failed");
                System.out.println("Response: " + response.body().string());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
