package org.byters.model;

import java.util.ArrayList;

public class ExploreItemBlock extends ExploreItem {

    private String title;
    private ArrayList<ExploreBlockItem> items;

    public int size() {
        return items == null ? 0 : items.size();
    }

    public String itemImage(int position) {
        return items == null
                || items.get(position) == null
                ? ""
                : items.get(position).image;
    }

    public String itemTitle(int position) {
        return items == null
                || items.get(position) == null
                ? ""
                : items.get(position).title;
    }

    public String title() {
        return title;
    }

    private class ExploreBlockItem {
        private String blockId;
        private String title;
        private String image;
    }
}
