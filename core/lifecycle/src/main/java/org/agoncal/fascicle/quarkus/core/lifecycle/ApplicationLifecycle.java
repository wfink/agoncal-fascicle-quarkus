package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

// tag::adocSnippet[]
@ApplicationScoped
public class ApplicationLifecycle {

  @Inject
  Logger LOGGER;

  void onStart(@Observes StartupEvent ev) {
    LOGGER.info("The application is starting...");
  }

  void onStop(@Observes ShutdownEvent ev) {
    LOGGER.info("The application is stopping...");
  }
}
// end::adocSnippet[]
