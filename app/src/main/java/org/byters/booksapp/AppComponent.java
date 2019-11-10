package org.byters.booksapp;


import org.byters.booksapp.repository.RepositoryExplore;
import org.byters.booksapp.view.presenter.PresenterAdapterExplore;
import org.byters.booksapp.view.presenter.PresenterExplore;
import org.byters.booksapp.view.ui.activity.ActivityMain;
import org.byters.booksapp.view.ui.adapter.AdapterExplore;
import org.byters.booksapp.view.ui.adapter.AdapterExploreBooksCarousel;
import org.byters.booksapp.view.ui.adapter.AdapterExploreNews;
import org.byters.booksapp.view.ui.adapter.AdapterExploreReviewsCarousel;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBook;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreCarouselBase;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreCarouselBooks;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreSearch;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderNews;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderReview;
import org.byters.booksapp.view.ui.fragment.FragmentExplore;

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
}
