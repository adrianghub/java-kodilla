package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;

import java.util.ArrayList;
import java.util.List;

public class ForumStatisticsCalculator implements Statistics {

    private final List<ForumUser> forumUsers = new ArrayList<>();
    private final List<ForumPost> forumPosts = new ArrayList<>();
    private final List<String> forumUsersNames = new ArrayList<>();
    private final List<String> forumPostsBodies = new ArrayList<>();
    private Statistics statistics;

    public ForumStatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public void showStatics() {
        calculateAdvStatistics(statistics);
    }

    public void calculateAdvStatistics(Statistics statistics) {
        int quantityOfUserNames = statistics.usersNames().size();
        int quantityOfPostBodies = statistics.postBodies().size();
        int quantityOfPosts = statistics.postsCount();
        int quantityOfComments = statistics.commentsCount();
        int averagePostsCount = quantityOfPosts / quantityOfUserNames;
        int averageCommentsCountByUser = quantityOfComments / quantityOfUserNames;
        int averageCommentsCountByPost = quantityOfComments / quantityOfPostBodies;

        System.out.println(
                "Stats => Users: " + quantityOfUserNames +
                        "Posts:" + quantityOfPosts +
                        "Comments: " + quantityOfComments +
                        "Average posts quantity: " + averagePostsCount +
                        "Average posts by user quantity: " + averageCommentsCountByUser +
                        "Average posts by comments quantity: " + averageCommentsCountByPost);
    }

    public void addForumUser(ForumUser forumUser) {
        forumUsers.add(forumUser);
    }

    @Override
    public List<String> usersNames() {
        for (ForumUser user : forumUsers) {
            forumUsersNames.add(user.getName());
        }
        return forumUsersNames;
    }

    @Override
    public List<String> postBodies() {
        int quantityOfAllForumComments = commentsCount();
        for (ForumPost post : forumPosts) {
            forumPostsBodies.add(post.getPostBody());
        }
        return forumPostsBodies;
    }

    @Override
    public int postsCount() {
        int sum = 0;
        for (ForumUser user : forumUsers) {
            sum += user.getPostsQuantity();
        }
        return sum;
    }

    @Override
    public int commentsCount() {
        int sum = 0;
        for (ForumUser user : forumUsers) {
            sum += user.getCommentsQuantity();
        }
        return sum;
    }
}
