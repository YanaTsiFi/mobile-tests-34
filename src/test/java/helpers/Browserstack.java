package helpers;

import static io.restassured.RestAssured.given;


public class Browserstack {

    // curl -u "yana_jg9Am6:qsiHqHsxXWkFjkpnnp4v" -X GET "https://api.browserstack.com/app-automate/sessions/eff075b44f77fdfadc319c26dbeaabb41c1c35a6.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("yana_jg9Am6", "qsiHqHsxXWkFjkpnnp4v")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}