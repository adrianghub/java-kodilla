package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {

    private String name;
    private String realName;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public ForumPost getPost(int postNumber) {
        return null;
    }

    public ForumComment getComment(int commentNumber) {
        return null;
    }

    public void addPost(String author, String postBody) {
        // silence is golden
    }

    public void addComment(ForumPost thePost, String author, String commentBody) {
        // silence is golden
    }

    public int getPostsQuantity() {
        // temporarily return 100
        return 100;
    }

    public int getCommentsQuantity() {
        // temporarily return 100
        return 100;
    }

    public boolean removePost(ForumPost thePost) {
        // temporarily return true
        return true;
    }

    public boolean removeComment(ForumComment theComment) {
        // temporarily return true
        return true;
    }
}
