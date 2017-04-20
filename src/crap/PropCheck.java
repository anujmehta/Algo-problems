package crap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by an039me on 4/4/2016.
 */
public class PropCheck {
    public void loadProperty(){
        Properties properties = new Properties();
        String propertyFileName = "MyProperty.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
        try {
            properties.load(inputStream);
            String junk = System.getProperty("junk");
            if(junk != null){
                System.out.println("'system property found");
                properties.setProperty("junk", junk);
            }
            System.out.println(properties.get("junk"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        PropCheck propCheck = new PropCheck();
        propCheck.loadProperty();
    }
}
