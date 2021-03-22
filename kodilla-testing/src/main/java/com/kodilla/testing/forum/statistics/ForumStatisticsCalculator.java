package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;

import java.util.ArrayList;
import java.util.List;

public class ForumStatisticsCalculator implements Statistics {

    private int quantityOfUserNames;
    private int quantityOfPostBodies;
    private int quantityOfPosts;
    private int quantityOfComments;
    private int averagePostsCount;
    private int averageCommentsCountByUser;
    private int averageCommentsCountByPost;

    private final List<ForumUser> forumUsers = new ArrayList<>();
    private final List<ForumPost> forumPosts = new ArrayList<>();
    private final List<String> forumUsersNames = new ArrayList<>();
    private final List<String> forumPostsBodies = new ArrayList<>();
    private Statistics statistics;

    public ForumStatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        this.quantityOfUserNames = statistics.usersNames().size();
        this.quantityOfPostBodies = statistics.postBodies().size();
        this.quantityOfPosts = statistics.postsCount();
        this.quantityOfComments = statistics.commentsCount();

        this.averagePostsCount = quantityOfPosts / quantityOfUserNames;
        this.averageCommentsCountByUser = quantityOfComments / quantityOfUserNames;
        this.averageCommentsCountByPost = quantityOfComments / quantityOfPostBodies;
    }

    public void showStatistics() {
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

    public int getQuantityOfUserNames() {
        return quantityOfUserNames;
    }

    public int getQuantityOfPostBodies() {
        return quantityOfPostBodies;
    }

    public int getQuantityOfPosts() {
        return quantityOfPosts;
    }

    public int getQuantityOfComments() {
        return quantityOfComments;
    }

    public int getAveragePostsCount() {
        return averagePostsCount;
    }

    public int getAverageCommentsCountByUser() {
        return averageCommentsCountByUser;
    }

    public int getAverageCommentsCountByPost() {
        return averageCommentsCountByPost;
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
