package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import com.kodilla.testing.forum.statistics.ForumStatisticsCalculator;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Forum Test Suite")
class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestPosts {
        @Test
        void testAddPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrswhite", "Walter White");
            ForumPost forumPost = new ForumPost("mrswhite", "Hello everyone, this is my first contribution here!");

            //When
            forumUser.addPost(forumPost);

            //Then
            assertEquals(1, forumUser.getPostsQuantity());
        }

        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrswhite", "Walter White");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost);
            //When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);
            //Then
            assertEquals(thePost, retrievedPost);
        }

        @Test
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            assertFalse(result);
        }

        @Test
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost);
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            assertTrue(result);
            assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @Nested
    @DisplayName("Test for comments")
    class TestComments {
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrswhite", "Wallter White");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrswhite");

            //When
            forumUser.addComment(thePost, "mrswhite", "Thank you for all good words!");

            //Then
            assertEquals(1, forumUser.getCommentsQuantity());
        }


        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());
            //When
            ForumComment retrievedComment = forumUser.getComment(0);
            //Then
            assertEquals(theComment, retrievedComment);
        }


        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            assertFalse(result);
        }

        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            assertTrue(result);
            assertEquals(0, forumUser.getCommentsQuantity());
        }
    }

    @Nested
    @DisplayName("Test forum statistics")
    @ExtendWith(MockitoExtension.class)
    class TestForumStatistics {

        @Mock
        private Statistics statisticsMock;

        private List<ForumPost> generateListOfNPosts(int postsQuantity) {
            List<ForumPost> posts = new ArrayList<>();
            for (int n = 1; n <= postsQuantity; n++) {
                ForumPost post = new ForumPost("Post Body" + n , "Author " + n);
                posts.add(post);
            }

            return posts;
        }

        private List<ForumUser> generateListOfNUsersNames(int usersQuantity) {
            List<ForumUser> users = new ArrayList<>();
            for (int n = 1; n <= usersQuantity; n++) {
                ForumUser user = new ForumUser("noname" + n, "Kacper" + n);
                users.add(user);
            }

            return users;
        }

        @Test
        void testCalculateAverageWithoutPosts() {
            //Given
            ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);                  // [1]
            ForumUser forumUser = new ForumUser("adam123", "Adam");
            forumStats.addForumUser(forumUser);
            //When
            int displayPostsQuantity = forumStats.getQuantityOfPosts();
            //Then
            assertEquals(0, displayPostsQuantity);
        }

        @Test
        void testCalculateAverageFor1000Posts() {
            //Given
            ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);                  // [1]
            ForumUser forumUser = new ForumUser("adam123", "Adam");
            List<ForumPost> result1000Users = generateListOfNPosts(1000);
            for (ForumPost post: result1000Users) {
                forumUser.addPost(post);
            }
            forumStats.addForumUser(forumUser);

            //When
            int displayPostsQuantity = forumStats.postsCount();

            //Then
            assertEquals(1000, displayPostsQuantity);
        }

        @Test
        void testCalculateAverageWithoutComments() {
            //Given
            ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
            ForumUser forumUser = new ForumUser("adam123", "Adam");
            List<ForumPost> result50Users = generateListOfNPosts(50);
            for (ForumPost post: result50Users) {
                forumUser.addPost(post);
            }
            forumStats.addForumUser(forumUser);

            //When
            int displayCommentsQuantity = forumStats.commentsCount();

            //Then
            assertEquals(0, displayCommentsQuantity);

        }

        @Test
        void testCalculateAverageCommentsQuantitySmallerThenPostsQuantity() {
            //Given
            //When
            //Then
            assertTrue(false);
        }

        @Test
        void testCalculateAverageCommentsQuantityGreaterThenPostsQuantity() {
            //Given
            //When
            //Then
            assertTrue(false);
        }

        @Test
        void testCalculateAverageWithoutUsers() {
            //Given
            ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
            ForumUser forumUser = new ForumUser("adam123", "Adam");
            List<ForumPost> result50Users = generateListOfNPosts(50);
            for (ForumPost post: result50Users) {
                forumUser.addPost(post);
            }

            //When
            int displayUsersNamesQuantity = forumStats.usersNames().size();

            //Then
            assertEquals(0, displayUsersNamesQuantity);
        }

        @Test
        void testCalculateAverageFor100Users() {
            //Given
            ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
            List<ForumUser> result100Users = generateListOfNUsersNames(100);

            for(ForumUser user: result100Users) {
                forumStats.addForumUser(user);
            }

            //When
            int displayUsersQuantity = forumStats.usersNames().size();

            //Then
            assertEquals(100, displayUsersQuantity);
        }
    }

}
