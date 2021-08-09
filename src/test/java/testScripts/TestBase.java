package testScripts;

import controllers.PetController;
import domain.PetstoreClient;

import java.io.IOException;
import java.util.Properties;

class TestBase {
    PetstoreClient petstoreClient;
    private Properties properties;

     TestBase() {
         String env = System.getenv("app.env");
         loadProperties(env);
         this.petstoreClient = new PetstoreClient()
                .withPetController(new PetController(properties.getProperty("urls.getPetById")));
    }

    private void loadProperties(String propPath) {
         this.properties = new Properties();
         try {
            properties.load(TestBase.class.getClassLoader().getResource(propPath + ".properties").openStream());
         }
         catch (IOException ex) {
             ex.printStackTrace();
         }
    }
}
