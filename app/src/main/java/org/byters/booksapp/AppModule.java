package org.byters.booksapp;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.byters.api.memorycache.ICacheBookSearch;
import org.byters.api.memorycache.ICacheExplore;
import org.byters.api.network.IApiBooks;
import org.byters.api.repository.IRepositoryBookRequest;
import org.byters.api.repository.IRepositoryBookSearch;
import org.byters.api.repository.IRepositoryExplore;
import org.byters.api.view.INavigator;
import org.byters.api.view.presenter.IPresenterAdapterBookSuggest;
import org.byters.api.view.presenter.IPresenterAdapterExplore;
import org.byters.api.view.presenter.IPresenterBookRequest;
import org.byters.api.view.presenter.IPresenterExplore;
import org.byters.api.view.presenter.IPresenterFragmentBook;
import org.byters.api.view.presenter.IPresenterProfile;
import org.byters.api.view.ui.util.IHelperPopup;
import org.byters.booksapp.network.util.ExploreItemDeserializer;
import org.byters.booksapp.view.presenter.PresenterBookRequest;
import org.byters.booksapp.view.ui.util.HelperPopup;
import org.byters.impl.memorycache.CacheBookSearch;
import org.byters.impl.memorycache.CacheExplore;
import org.byters.impl.repository.RepositoryBookRequest;
import org.byters.impl.repository.RepositoryBookSearch;
import org.byters.impl.repository.RepositoryExplore;
import org.byters.booksapp.view.presenter.PresenterAdapterBookSuggest;
import org.byters.booksapp.view.presenter.PresenterAdapterExplore;
import org.byters.booksapp.view.presenter.PresenterExplore;
import org.byters.booksapp.view.presenter.PresenterFragmentBook;
import org.byters.booksapp.view.presenter.PresenterProfile;
import org.byters.model.ExploreItem;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class AppModule {

    private static final String API_URL = ""; //todo implement

    @Provides
    @Singleton
    IPresenterExplore presenterMain() {
        return new PresenterExplore();
    }

    @Provides
    @Singleton
    IPresenterAdapterExplore presenterAdapterMain() {
        return new PresenterAdapterExplore();
    }

    @Provides
    @Singleton
    IPresenterProfile presenterProfile() {
        return new PresenterProfile();
    }

    @Provides
    @Singleton
    IPresenterFragmentBook presenterFragmentBook() {
        return new PresenterFragmentBook();
    }

    @Provides
    @Singleton
    IPresenterAdapterBookSuggest presenterAdapterBookSuggest() {
        return new PresenterAdapterBookSuggest();
    }

    @Provides
    @Singleton
    IPresenterBookRequest presenterBookRequest() {
        return new PresenterBookRequest();
    }

    @Provides
    @Singleton
    ICacheExplore cacheExplore() {
        return new CacheExplore();
    }

    @Provides
    @Singleton
    IRepositoryExplore repositoryExplore() {
        return new RepositoryExplore();
    }

    @Provides
    @Singleton
    IRepositoryBookSearch repositoryBookSearch() {
        return new RepositoryBookSearch();
    }

    @Provides
    @Singleton
    IRepositoryBookRequest repositoryBookRequest() {
        return new RepositoryBookRequest();
    }

    @Provides
    @Singleton
    INavigator navigator() {
        return new Navigator();
    }

    @Provides
    @Singleton
    IHelperPopup helperPopup(){
        return new HelperPopup();
    }

    @Singleton
    @Provides
    IApiBooks api() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES);
        OkHttpClient client = builder.build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ExploreItem.class, new ExploreItemDeserializer())
                .create();

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(API_URL)
                .client(client)
                .build()
                .create(IApiBooks.class);
    }

    @Singleton
    @Provides
    ICacheBookSearch cacheBookSearch(){
        return new CacheBookSearch();
    }
}
