package org.byters.booksapp.network.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.byters.booksapp.model.ExploreItem;
import org.byters.booksapp.model.ExploreItemBlock;
import org.byters.booksapp.model.ExploreItemEnum;
import org.byters.booksapp.model.ExploreItemNews;
import org.byters.booksapp.model.ExploreItemReview;
import org.byters.booksapp.model.ExploreItemSearch;
import org.byters.booksapp.model.ExploreItemUnknown;

import java.lang.reflect.Type;

public class ExploreItemDeserializer implements JsonDeserializer<ExploreItem> {

    @Override
    public ExploreItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        int type = json.getAsJsonObject().getAsJsonPrimitive("type").getAsInt();

        if (type == ExploreItemEnum.TYPE_NEWS.getValue())
            return context.deserialize(json, ExploreItemNews.class);

        if (type == ExploreItemEnum.TYPE_BLOCK.getValue())
            return context.deserialize(json, ExploreItemBlock.class);

        if (type == ExploreItemEnum.TYPE_SEARCH.getValue())
            return context.deserialize(json, ExploreItemSearch.class);

        if (type == ExploreItemEnum.TYPE_REVIEWS.getValue())
            return context.deserialize(json, ExploreItemReview.class);

        return context.deserialize(json, ExploreItemUnknown.class);
    }
}