package org.byters.booksapp;


import org.byters.api.memorycache.ICacheExplore;
import org.byters.api.repository.IRepositoryExplore;
import org.byters.api.view.INavigator;
import org.byters.api.view.presenter.IPresenterAdapterBookSuggest;
import org.byters.api.view.presenter.IPresenterAdapterExplore;
import org.byters.api.view.presenter.IPresenterExplore;
import org.byters.api.view.presenter.IPresenterFragmentBook;
import org.byters.api.view.presenter.IPresenterProfile;
import org.byters.impl.memorycache.CacheExplore;
import org.byters.impl.repository.RepositoryExplore;
import org.byters.booksapp.view.presenter.PresenterAdapterBookSuggest;
import org.byters.booksapp.view.presenter.PresenterAdapterExplore;
import org.byters.booksapp.view.presenter.PresenterExplore;
import org.byters.booksapp.view.presenter.PresenterFragmentBook;
import org.byters.booksapp.view.presenter.PresenterProfile;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

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
    INavigator navigator() {
        return new Navigator();
    }
}
