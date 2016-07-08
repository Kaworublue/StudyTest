package com.ding.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpPostUtil2 {
     @SuppressWarnings("unused")
    private static final String APPLICATION_JSON = "application/json";
    @SuppressWarnings("unused")
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
    // http�������Ӳ���Ĭ��ֵ
    private static int connectionTimeOut = 15000;//���ӳ�ʱʱ��
    private static int readTimeOut = 25000;//��ȡ��ʱʱ��
    @SuppressWarnings("unused")
    private static int retryTimes = 3;//���Դ���

 


    public static JsonObject postJsonData(String url, String jsonStrData) {
      
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpPost post = new HttpPost(url);
        JsonObject jsonObject = null;
        try {

            CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
            // HttpEntity entity = new StringEntity(jsonStrData);
            // �޸� POST json ������������
            HttpEntity entity = new StringEntity(jsonStrData, "UTF-8");
            post.setEntity(entity);
            post.setHeader("Content-type", "application/json");
            HttpResponse resp = closeableHttpClient.execute(post);
            jsonObject = convertResponseBytes2JsonObj(resp);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    static JsonParser jsonParser = new JsonParser();

    /**
     * ���� get ����
     *
     * @param
     * @return {@link JsonObject}
     */
    public static void main(String[] args) {

        String url = "https://www.juxinli.com/orgApi/rest/v2/house_fund/yirendai";
        System.out.println(url);
         //�����ǲ�����
        String resultInfo = "";
         BufferedReader br = null;
        try {
        	
        	  br=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\test.txt"),"UTF-8"));  
    
            StringBuffer sb = new StringBuffer();
            String data = null;
            while ((data = br.readLine()) != null) {
                sb.append(data);
            }
            resultInfo = sb.toString();
         } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(url);
       // resultInfo.replaceAll("?","");
        System.out.println(resultInfo);
        System.out.println(postJsonData(url,resultInfo));


    }

    public static String postJsonData1(String url, String content ) {
        String result = "";
     
        try {
            URL postUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST"); // ��������ʽ
            connection.setConnectTimeout(connectionTimeOut);
            connection.setReadTimeout(readTimeOut);
            connection.setRequestProperty("Accept", "application/json"); // ���ý������ݵĸ�ʽ
            connection.setRequestProperty("Content-Type", "application/json"); // ���÷������ݵĸ�ʽ
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);

            connection.connect();


            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(content);
            out.flush();
            out.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while (true) {
                result = reader.readLine();
                if (null == result) break;

            }
        }   catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * Header Ϊ application/json POST ��������
     *
     * @param resp
     * @return {@link JsonObject}
     */
    private static JsonObject convertResponseBytes2JsonObj(HttpResponse resp) {

        JsonObject jsonObject = null;
        try {
            InputStream respIs = resp.getEntity().getContent();
            byte[] respBytes = IOUtils.toByteArray(respIs);
            String result = new String(respBytes, Charset.forName("UTF-8"));
            if (null == result || result.length() == 0) {
                // TODO
                System.err.println("����Ӧ");
            } else {
                System.out.println(result);
                if (result.startsWith("{") && result.endsWith("}")) {
                    jsonObject = (JsonObject) jsonParser.parse(result);
                } else {
                    // TODO
                    System.err.println("����ת��JSON����");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
