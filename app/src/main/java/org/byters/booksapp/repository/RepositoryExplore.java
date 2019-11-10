package org.byters.booksapp.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.booksapp.memorycache.ICacheExplore;
import org.byters.booksapp.model.ExploreItem;
import org.byters.booksapp.model.ModelExplore;
import org.byters.booksapp.network.util.ExploreItemDeserializer;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

public class RepositoryExplore implements IRepositoryExplore {

    @Inject
    ICacheExplore cacheExplore;

    public RepositoryExplore() {
        BooksApplication.getComponent().inject(this);
    }

    @Override
    public void request() {

        String json = null;
        try {
            InputStream is = BooksApplication.context().getResources().openRawResource(R.raw.explore);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
        }


        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ExploreItem.class, new ExploreItemDeserializer())
                .create();

        ModelExplore data = gson
                .fromJson(json, ModelExplore.class);
        cacheExplore.setData(data);

    }
}
