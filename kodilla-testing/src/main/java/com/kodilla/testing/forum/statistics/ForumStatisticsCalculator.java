package com.kodilla.testing.forum.statistics;

public class ForumStatisticsCalculator {

    private int quantityOfUserNames;
    private int quantityOfPostBodies;
    private int quantityOfPosts;
    private int quantityOfComments;
    private double averagePostsCount;
    private double averageCommentsCountByUser;
    private double averageCommentsCountByPost;

    private Statistics statistics;

    public ForumStatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics() {
        quantityOfUserNames = statistics.usersNames().size();
        quantityOfPostBodies = statistics.postBodies().size();
        quantityOfPosts = statistics.postsCount();
        quantityOfComments = statistics.commentsCount();

        if (quantityOfUserNames > 0) {
            averagePostsCount = quantityOfPosts / quantityOfUserNames;
            averageCommentsCountByUser = quantityOfComments / quantityOfUserNames;
        }

        if (quantityOfPosts > 0) {
            averageCommentsCountByPost = quantityOfComments / quantityOfPosts;
        }
    }

    public void showStatistics() {
        System.out.println(
                "Stats => Users: " + quantityOfUserNames +
                        "Posts:" + quantityOfPosts +
                        "Comments: " + quantityOfComments +
                        "Average posts quantity: " + averagePostsCount +
                        "Average posts by us    er quantity: " + averageCommentsCountByUser +
                        "Average posts by comments quantity: " + averageCommentsCountByPost);
    }

    public int getQuantityOfUserNames() {
        return quantityOfUserNames;
    }

    public int getQuantityOfPosts() {
        return quantityOfPosts;
    }

    public int getQuantityOfComments() {
        return quantityOfComments;
    }

    public double getAveragePostsCount() {
        return averagePostsCount;
    }

    public double getAverageCommentsCountByUser() {
        return averageCommentsCountByUser;
    }

    public double getAverageCommentsCountByPost() {
        return averageCommentsCountByPost;
    }
}
