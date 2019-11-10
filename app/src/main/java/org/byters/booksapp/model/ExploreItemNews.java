package org.byters.booksapp.model;

import java.util.ArrayList;

public class ExploreItemNews extends ExploreItem{

    ArrayList<ExploreNews> news;

    public int newsSize() {
        return news == null ? 0 : news.size();
    }

    public String image(int position) {
        return news == null ? "" : news.get(position).image;
    }

    public String title(int position) {
        return news == null ? "" : news.get(position).title;
    }

    private class ExploreNews {
        private String image;
        private String url;
        private String title;
    }

}
