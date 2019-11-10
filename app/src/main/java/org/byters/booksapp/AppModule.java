package org.byters.booksapp;


import org.byters.booksapp.memorycache.CacheExplore;
import org.byters.booksapp.memorycache.ICacheExplore;
import org.byters.booksapp.repository.IRepositoryExplore;
import org.byters.booksapp.repository.RepositoryExplore;
import org.byters.booksapp.view.presenter.IPresenterAdapterBookSuggest;
import org.byters.booksapp.view.presenter.IPresenterAdapterExplore;
import org.byters.booksapp.view.presenter.IPresenterExplore;
import org.byters.booksapp.view.presenter.IPresenterFragmentBook;
import org.byters.booksapp.view.presenter.PresenterAdapterBookSuggest;
import org.byters.booksapp.view.presenter.PresenterAdapterExplore;
import org.byters.booksapp.view.presenter.PresenterExplore;
import org.byters.booksapp.view.presenter.PresenterFragmentBook;

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
    IPresenterFragmentBook presenterFragmentBook(){
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
