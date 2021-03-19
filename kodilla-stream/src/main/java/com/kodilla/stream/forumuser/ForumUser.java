package com.kodilla.stream.forumuser;

import java.time.LocalDate;

import static com.kodilla.stream.forumuser.Sex.F;

public class ForumUser {
    private final int uniqueID;
    private final String username;
    private final Sex sex;
    private final LocalDate dateOfBirth;
    private final int numberOfPublishedPosts;

    public ForumUser(final int uniqueID, final String username, final Sex sex, final int year, final int month, final int day, final int numberOfPublishedPosts) {
        this.uniqueID = uniqueID;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.numberOfPublishedPosts = numberOfPublishedPosts;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public String getUsername() {
        return username;
    }

    public Sex getSex() {
        return sex;
    }

    public String displaySex() {
        String result;
        switch (sex) {
            case M:
                result = "Alpha Male";
                break;
            case F:
                result = "Beta Female";
                break;
            case L:
                result = "Lesbian";
                break;
            case G:
                result = "Gay";
                break;
            case B:
                result = "Bisexual";
                break;
            case T:
                result = "Transgenda";
                break;
            case Q:
                result = "Questionable?";
                break;
            default:
                result = "Unknown Gender";
                break;
        }
        return result;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getYear() {
        return dateOfBirth.getYear();
    }

    public int getNumberOfPublishedPosts() {
        return numberOfPublishedPosts;
    }

    @Override
    public String toString() {
        return "[ Forum User: " +
                ", username = '" + username + '\'' +
                ", sex = " + displaySex() +
                ", dateOfBirth = " + dateOfBirth +
                ", numberOfPublishedPosts = " + numberOfPublishedPosts +
                " ]";
    }
}
