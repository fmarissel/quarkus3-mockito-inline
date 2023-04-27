package fr.marissel;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;

@QuarkusTest
class MockitoInlineTest {

  static EnvironmentVariables env;

  @BeforeAll
  static void setUp() throws Exception {
    env = new EnvironmentVariables("MOCKITO_ENV_VAR", "fake-mock-env");
    env.setup();
  }

  @AfterAll
  static void tearDown() throws Exception {
    env.teardown();
  }

  @Test
  void should_get_env_variable() {
    var aaa = System.getenv("MOCKITO_ENV_VAR");
    Assertions.assertEquals("fake-mock-env", aaa);
  }
}
