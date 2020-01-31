package org.byters.model;

public enum ExploreItemEnum {
    TYPE_UNKNOWN(0),
    TYPE_NEWS(1),
    TYPE_SEARCH(2),
    TYPE_BLOCK(3),
    TYPE_REVIEWS(4);

    private final int type;

    ExploreItemEnum(int type) {
        this.type = type;
    }

    public int getValue() {
        return type;
    }
}
