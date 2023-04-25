/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connecttoapı;

import java.net.*;import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class ConnectToAPI {

    static String host = "https://api.cognitive.microsoft.com";
    static String path = "/bing/v7.0/spellcheck";

    static String key = "<ENTER-KEY-HERE>";

    static String mkt = "en-US";
    static String mode = "proof";
    static String text = "Hollo, wrld!";
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    
    public static void main(String[] args) throws Exception {
    //String url = "https://dog.ceo/api/breeds/image/random ";
   // String json = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
    //JSONParser jsonParser = new JSONParser();
    //System.out.println(jsonParser.parse(json));
    String params = null;
    check();
    URL url = new URL(host + path + params);
    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    connection.setRequestProperty("Ocp-Apim-Subscription-Key", key);
    connection.setDoOutput(true);
       
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.writeBytes("text=" + text);
            wr.flush();
        }
    }
    public static void check () throws Exception {
    String params = "?mkt=" + mkt + "&mode=" + mode;
}
    }
