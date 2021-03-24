package com.kodilla.testing.forum;

import com.kodilla.testing.forum.statistics.ForumStatisticsCalculator;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("Test forum statistics")
@ExtendWith(MockitoExtension.class)
class ForumStatisticsTestSuite {

    private List<String> generateListOfNUsersNames(int usersQuantity) {
        List<String> users = new ArrayList<>();
        for (int n = 1; n <= usersQuantity; n++) {
            String userName = "noname" + n;
            users.add(userName);
        }

        return users;
    }

    @Mock
    private Statistics statisticsMock;

    @Test
    void testCalculateAverageWithoutPosts() {
        //Given
        ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
        List<String> userNames = generateListOfNUsersNames(100);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(250);
        when(statisticsMock.usersNames()).thenReturn(userNames);

        //When
        forumStats.calculateAdvStatistics();

        //Then
        assertEquals(0, forumStats.getQuantityOfPosts());
        assertEquals(250, forumStats.getQuantityOfComments());
        assertEquals(100, forumStats.getQuantityOfUserNames());
        assertEquals(0, forumStats.getAveragePostsCount(), 0.1);
        assertEquals(0, forumStats.getAverageCommentsCountByPost(), 0.1);
        assertEquals(2, forumStats.getAverageCommentsCountByUser(), 0.1);

    }

    @Test
    void testCalculateAverageFor1000Posts() {
        //Given
        ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
        List<String> userNames = generateListOfNUsersNames(100);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.usersNames()).thenReturn(userNames);

        //When
        forumStats.calculateAdvStatistics();

        //Then
        assertEquals(1000, forumStats.getQuantityOfPosts());
        assertEquals(100, forumStats.getQuantityOfUserNames());
        assertEquals(10, forumStats.getAveragePostsCount(), 0.1);
        assertEquals(0, forumStats.getAverageCommentsCountByPost(), 0.1);
        assertEquals(0, forumStats.getAverageCommentsCountByUser(), 0.1);
    }

    @Test
    void testCalculateAverageWithoutComments() {
        //Given
        ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
        List<String> userNames = generateListOfNUsersNames(100);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(userNames);

        //When
        forumStats.calculateAdvStatistics();

        //Then
        assertEquals(1000, forumStats.getQuantityOfPosts());
        assertEquals(0, forumStats.getQuantityOfComments());
        assertEquals(10, forumStats.getAveragePostsCount(), 0.1);
        assertEquals(0, forumStats.getAverageCommentsCountByPost(), 0.1);
        assertEquals(0, forumStats.getAverageCommentsCountByUser(), 0.1);
    }

    @Test
    void testCalculateAverageCommentsQuantitySmallerThenPostsQuantity() {
        //Given
        ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
        List<String> userNames = generateListOfNUsersNames(100);
        when(statisticsMock.postsCount()).thenReturn(150);
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.usersNames()).thenReturn(userNames);

        //When
        forumStats.calculateAdvStatistics();

        //Then
        assertEquals(150, forumStats.getQuantityOfPosts());
        assertEquals(50, forumStats.getQuantityOfComments());
        assertEquals(1, forumStats.getAveragePostsCount(), 0.1);
        assertEquals(0, forumStats.getAverageCommentsCountByPost(), 0.1);
        assertEquals(0, forumStats.getAverageCommentsCountByUser(), 0.1);
    }

    @Test
    void testCalculateAverageCommentsQuantityGreaterThenPostsQuantity() {
        //Given
        ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
        List<String> userNames = generateListOfNUsersNames(100);
        when(statisticsMock.postsCount()).thenReturn(250);
        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.usersNames()).thenReturn(userNames);

        //When
        forumStats.calculateAdvStatistics();

        //Then
        assertEquals(250, forumStats.getQuantityOfPosts());
        assertEquals(500, forumStats.getQuantityOfComments());
        assertEquals(2, forumStats.getAveragePostsCount(), 0.1);
        assertEquals(2, forumStats.getAverageCommentsCountByPost(), 0.1);
        assertEquals(5, forumStats.getAverageCommentsCountByUser(), 0.1);
    }

    @Test
    void testCalculateAverageWithoutUsers() {
        //Given
        ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
        List<String> userNames = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(250);
        when(statisticsMock.commentsCount()).thenReturn(500);

        //When
        forumStats.calculateAdvStatistics();

        //Then
        assertEquals(0, forumStats.getQuantityOfUserNames());
        assertEquals(0, forumStats.getAveragePostsCount(), 0.1);
        assertEquals(2, forumStats.getAverageCommentsCountByPost(), 0.1);
        assertEquals(0, forumStats.getAverageCommentsCountByUser(), 0.1);
    }

    @Test
    void testCalculateAverageFor100Users() {
        //Given
        ForumStatisticsCalculator forumStats = new ForumStatisticsCalculator(statisticsMock);
        List<String> userNames = generateListOfNUsersNames(100);
        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(250);
        when(statisticsMock.commentsCount()).thenReturn(500);

        //When
        forumStats.calculateAdvStatistics();

        //Then
        assertEquals(100, forumStats.getQuantityOfUserNames());
        assertEquals(2.0, forumStats.getAveragePostsCount(), 0.1);
        assertEquals(2.0, forumStats.getAverageCommentsCountByPost(), 0.1);
        assertEquals(5.0, forumStats.getAverageCommentsCountByUser(), 0.1);
    }
}
