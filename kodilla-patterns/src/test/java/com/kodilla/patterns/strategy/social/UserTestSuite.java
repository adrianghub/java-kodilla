package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    public static final String FB_SHARE_RESPONSE =  "[fb] Shared on facebook";
    public static final String TWITTER_SHARE_RESPONSE =  "[twit] Shared on twitter";
    public static final String SNAPCHAT_SHARE_RESPONSE =  "[snap] Shared on snapchat";

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User oldWoman = new YGeneration("Krystyna Czubówna");
        User adultWoman = new Millenials("Barbara Nowak");
        User youngMan = new ZGeneration("Igor Wozniak");

        //When
        String oldWomanSharePost = oldWoman.sharePost();
        System.out.println("Old woman sharing post... " + oldWomanSharePost);
        String adultWomanSharePost = adultWoman.sharePost();
        System.out.println("Adult woman sharing post... " + adultWomanSharePost);
        String youngManSharePost = youngMan.sharePost();
        System.out.println("Young man sharing post... " + youngManSharePost);

        //Then
        assertEquals(FB_SHARE_RESPONSE, oldWomanSharePost);
        assertEquals(TWITTER_SHARE_RESPONSE, adultWomanSharePost);
        assertEquals(SNAPCHAT_SHARE_RESPONSE, youngManSharePost);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User oldMan = new YGeneration("Krzysztof Krawczyk");

        //When
        String oldManSharePost = oldMan.sharePost();
        System.out.println("Old man sharing post... " + oldManSharePost);
        oldMan.setShareMethod(new SnapchatPublisher());
        oldManSharePost = oldMan.sharePost();
        System.out.println(oldMan.getName() + " now sharing on his grandson account... " + oldManSharePost);

        //Then
        assertEquals(SNAPCHAT_SHARE_RESPONSE, oldManSharePost);
    }
}
