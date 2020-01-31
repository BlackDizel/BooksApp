package org.byters.booksapp.view.ui.adapter.viewholder;

import android.view.ViewGroup;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.api.view.presenter.IPresenterAdapterExplore;
import org.byters.booksapp.view.ui.adapter.AdapterExploreBooksCarousel;

import javax.inject.Inject;

public class ViewHolderExploreCarouselBooks extends ViewHolderExploreCarouselBase {

    @Inject
    IPresenterAdapterExplore presenter;

    public ViewHolderExploreCarouselBooks(ViewGroup viewGroup) {
        super(viewGroup, R.string.empty, new AdapterExploreBooksCarousel());
        BooksApplication.getComponent().inject(this);
    }

    @Override
    public void setData(int position) {
        setTitle(presenter.getCarouselTitle(position));
        ((AdapterExploreBooksCarousel) adapter).setPosition(position);
    }
}
