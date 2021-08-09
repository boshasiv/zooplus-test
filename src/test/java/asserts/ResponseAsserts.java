package asserts;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class ResponseAsserts {

    public static <T> void verifyResponseContains(Response response, int code, T expectedObject)
            throws IOException {
        assertThat(response.code()).isEqualTo(code);

        String responseBody = response.peekBody(Long.MAX_VALUE).string();
        T actualObject = new ObjectMapper()
                .readerFor(expectedObject.getClass())
                .readValue(responseBody);

        assertThat(expectedObject).isEqualTo(actualObject);

    }
}
