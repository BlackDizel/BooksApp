package org.byters.model;

import java.util.ArrayList;

public class ModelExplore {

    ArrayList<ExploreItem> data;

    public int newsSize() {
        return ((ExploreItemNews) get(ExploreItemEnum.TYPE_NEWS)).newsSize();
    }

    private ExploreItem get(ExploreItemEnum type) {
        for (ExploreItem item : data)
            if (item.getType() == type.getValue())
                return item;
        return null;
    }

    public String newsImage(int position) {
        return ((ExploreItemNews) get(ExploreItemEnum.TYPE_NEWS)).image(position);
    }

    public String newsTitle(int position) {
        return ((ExploreItemNews) get(ExploreItemEnum.TYPE_NEWS)).title(position);
    }

    public int blockItemsNum(int carouselPosition) {
        return ((ExploreItemBlock) data.get(carouselPosition)).size();
    }

    public int size() {
        return data.size();
    }

    public String blockItemImage(int carouselPosition, int position) {
        return ((ExploreItemBlock) data.get(carouselPosition)).itemImage(position);
    }

    public String blockItemTitle(int carouselPosition, int position) {
        return ((ExploreItemBlock) data.get(carouselPosition)).itemTitle(position);
    }

    public String blockItemId(int carouselPosition, int position) {
        return ((ExploreItemBlock) data.get(carouselPosition)).itemId(position);
    }

    public String blockTitle(int position) {
        return ((ExploreItemBlock) data.get(position)).title();
    }

    public int reviewsNum() {
        return ((ExploreItemReview) get(ExploreItemEnum.TYPE_REVIEWS)).size();
    }

    public String reviewUsername(int position) {
        return ((ExploreItemReview) get(ExploreItemEnum.TYPE_REVIEWS)).username(position);
    }

    public String reviewMessage(int position) {
        return ((ExploreItemReview) get(ExploreItemEnum.TYPE_REVIEWS)).review(position);
    }

    public String reviewBook(int position) {
        return ((ExploreItemReview) get(ExploreItemEnum.TYPE_REVIEWS)).book(position);
    }

    public int getType(int position) {
        return data.get(position).getType();
    }
}
