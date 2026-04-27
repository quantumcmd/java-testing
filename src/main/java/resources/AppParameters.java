package resources;

public class AppParameters {
    public static final String DOMAIN = "127.0.0.1";
    public static final String PORT = "80";

    public  static String deployedURL(){
        return "https://" + DOMAIN + ":" + PORT;
    }
}
