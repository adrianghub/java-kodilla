package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName(
            "When create SimpleUser with name, " +
                    "then getUsername should return correct name"
    )
    @Test
    void testCaseUsername() {
        // Given
        SimpleUser simpleUser = new SimpleUser("jacek123", "John Snow");

        // When
        String result = simpleUser.getUsername();

        String expectedResult = "jacek123";
        System.out.println("Testing " + expectedResult );

        // Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName(
            "When create SimpleUser with real name, " +
                    "then getRealNameUser should return correct name"
    )
    @Test
    void testCaseRealName() {
        // Given
        SimpleUser simpleRealNameUser = new SimpleUser("jacek123", "John Snow");

        // When
        String result = simpleRealNameUser.getRealName();

        String expectedResult = "John Snow";
        System.out.println("Testing " + expectedResult );

        // Then
        Assertions.assertEquals("John Snow", result);
    }
}
