package org.agoncal.fascicle.quarkus.http.json;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;

// @formatter:off
// tag::adocSnippet[]
@Disabled
@QuarkusTest
public class CustomerResourceTest {

  @Test
  public void shouldGetJSonB() {
    given().
    when()
      .get("/customers/jsonb").
    then()
      .assertThat()
        .statusCode(is(200))
      .and()
        .body(containsString("2019.11"));
  }

  @Test
  public void shouldGetJSonP() {
    given().
    when()
      .get("/customers/jsonp").
    then()
      .assertThat()
        .statusCode(is(200))
      .and()
        .body(containsString("21 Ritherdon Rd"));
  }
}
// end::adocSnippet[]
