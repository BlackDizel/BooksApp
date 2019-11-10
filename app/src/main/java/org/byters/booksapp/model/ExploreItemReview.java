package org.byters.booksapp.model;

import java.util.ArrayList;

public class ExploreItemReview extends ExploreItem {

    ArrayList<ExploreReview> reviews;

    public int size() {
        return reviews == null ? 0 : reviews.size();
    }

    public String username(int position) {
        return reviews == null ? "" : reviews.get(position).username;
    }

    public String review(int position) {
        return reviews == null ? "" : reviews.get(position).review;
    }

    public String book(int position) {
        return reviews == null ? "" : reviews.get(position).book;
    }

    private class ExploreReview {
        private String bookId;
        private String book;
        private String username;
        private String review;
    }
}
