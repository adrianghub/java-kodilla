package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(1011, "ziemniak123", Sex.Q, 1996, 8, 11, 44));
        forumUserList.add(new ForumUser(1088, "teleranek92", Sex.F, 2008, 12, 2, 0));
        forumUserList.add(new ForumUser(1091, "koldzazty1", Sex.M, 1972, 3, 20, 5));
        forumUserList.add(new ForumUser(1021, "quarantinejazz1", Sex.G, 2010, 6, 13, 112));
        forumUserList.add(new ForumUser(9001, "kolorovy25", Sex.M, 1987, 1, 15, 0));
        forumUserList.add(new ForumUser(1221, "squirrel88", Sex.M, 1949, 9, 22, 29));
        forumUserList.add(new ForumUser(1151, "papasmurfff9", Sex.L, 2009, 1, 13, 0));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }
}
