package org.byters.booksapp;


import org.byters.booksapp.view.presenter.PresenterBookRequest;
import org.byters.booksapp.view.ui.fragment.FragmentBookRequest;
import org.byters.impl.repository.RepositoryBookRequest;
import org.byters.impl.repository.RepositoryBookSearch;
import org.byters.impl.repository.RepositoryExplore;
import org.byters.booksapp.view.presenter.PresenterAdapterExplore;
import org.byters.booksapp.view.presenter.PresenterExplore;
import org.byters.booksapp.view.presenter.PresenterProfile;
import org.byters.booksapp.view.ui.activity.ActivityMain;
import org.byters.booksapp.view.ui.adapter.AdapterBookRequest;
import org.byters.booksapp.view.ui.adapter.AdapterBookReview;
import org.byters.booksapp.view.ui.adapter.AdapterExplore;
import org.byters.booksapp.view.ui.adapter.AdapterExploreBooksCarousel;
import org.byters.booksapp.view.ui.adapter.AdapterExploreNews;
import org.byters.booksapp.view.ui.adapter.AdapterExploreReviewsCarousel;
import org.byters.booksapp.view.ui.adapter.AdapterBookFavorite;
import org.byters.booksapp.view.ui.adapter.AdapterProfileBooksReviews;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBook;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreCarouselBase;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreCarouselBooks;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreSearch;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderNews;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderReview;
import org.byters.booksapp.view.ui.adapter.AdapterBookLibrary;
import org.byters.booksapp.view.ui.fragment.FragmentBook;
import org.byters.booksapp.view.ui.fragment.FragmentExplore;
import org.byters.booksapp.view.ui.fragment.FragmentProfile;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(AdapterExplore adapterMain);

    void inject(FragmentExplore fragmentMain);

    void inject(ViewHolderExploreSearch viewHolderExploreSearch);

    void inject(PresenterAdapterExplore presenterAdapterExplore);

    void inject(ViewHolderExploreCarouselBase param);

    void inject(ViewHolderExploreCarouselBooks param);

    void inject(AdapterExploreNews adapterExploreNews);

    void inject(AdapterExploreBooksCarousel adapterExploreBooksCarousel);

    void inject(ViewHolderBook viewHolderBook);

    void inject(AdapterExploreReviewsCarousel adapterExploreReviewsCarousel);

    void inject(ViewHolderReview viewHolderReview);

    void inject(PresenterExplore presenterExplore);

    void inject(RepositoryExplore repositoryExplore);

    void inject(ActivityMain activityMain);

    void inject(ViewHolderNews viewHolderNews);

    void inject(AdapterBookRequest adapterBookRequest);

    void inject(FragmentBook fragmentBook);

    void inject(AdapterBookLibrary adapterBookLibrary);

    void inject(AdapterBookReview adapterBookReview);

    void inject(FragmentProfile fragmentProfile);

    void inject(AdapterBookFavorite adapterProfileBooksFavorite);

    void inject(AdapterProfileBooksReviews adapterProfileBooksReviews);

    void inject(PresenterProfile presenterProfile);

    void inject(RepositoryBookSearch repositoryBookSearch);

    void inject(FragmentBookRequest fragmentBookRequest);

    void inject(PresenterBookRequest presenterBookRequest);

    void inject(Navigator navigator);

    void inject(RepositoryBookRequest repositoryBookRequest);
}
