package org.agoncal.fascicle.quarkus.book;

import com.github.javafaker.Faker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

// tag::adocSnippet[]
@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @Inject
  Logger LOGGER;

  // tag::adocRestClient[]
  @Inject
  @RestClient
  NumberResourceProxy numberResourceProxy;

  // end::adocRestClient[]
  @GET
  // tag::adocFaultTolerance[]
  @Fallback(fallbackMethod = "fallbackGetRandomBook")
  // end::adocFaultTolerance[]
  // tag::adocMetrics[]
  @Counted(name = "getRandomBook",
    description = "Counts how many times the getRandomBook method has been invoked")
  // end::adocMetrics[]
  public Response getRandomBook() {

    IsbnNumbers isbnNumbers = numberResourceProxy.generateIsbnNumbers();

    Faker faker = new Faker();
    JsonObject book = Json.createObjectBuilder()
      .add("isbn_13", isbnNumbers.getIsbn13())
      .add("isbn_10", isbnNumbers.getIsbn10())
      .add("title", faker.book().title())
      .add("author", faker.book().author())
      .add("genre", faker.book().genre())
      .add("publisher", faker.book().publisher())
      .add("timestamp", String.valueOf(LocalDateTime.now()))
      .build();

    LOGGER.info("Random book " + book);
    return Response.ok(book).build();
  }
  // tag::adocFaultTolerance[]

  private Response fallbackGetRandomBook() {
    LOGGER.warn("Falling back on creating a book");
    JsonObject dummyBook = Json.createObjectBuilder()
      .add("title", "Dummy book")
      .add("timestamp", String.valueOf(LocalDateTime.now()))
      .build();
    return Response.ok(dummyBook).build();
  }
  // end::adocFaultTolerance[]
}
// end::adocSnippet[]
