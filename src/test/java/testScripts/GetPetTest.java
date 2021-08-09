package testScripts;

import domain.PetstoreClient;
import domain.models.Pet;
import okhttp3.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static asserts.ResponseAsserts.verifyResponseContains;

public class GetPetTest extends TestBase {

    @DataProvider(name="pets")
    public static Object[][] getPets() {
        return new Object[][]{{new Pet()
                .withId(124)
                .withName("lion")
                .withStatus("available")
                .withPhotoUrls(new ArrayList<>())
                .withTags(new ArrayList<>())}, {

                new Pet()
                .withId(125)
                .withName("bull")
                .withStatus("available")
                .withPhotoUrls(new ArrayList<>())
                .withTags(new ArrayList<>())}};
    }


    @Test (dataProvider = "pets")
    public void testGetPet(Pet pet) throws IOException {
        Response response = petstoreClient.getPetById(String.valueOf(pet.getId()));
        verifyResponseContains(response, 200, pet);
    }
}
