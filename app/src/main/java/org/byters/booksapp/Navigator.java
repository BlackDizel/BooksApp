package org.byters.booksapp;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import org.byters.api.view.INavigator;
import org.byters.api.view.ui.util.IHelperPopup;
import org.byters.booksapp.view.ui.fragment.FragmentBook;
import org.byters.booksapp.view.ui.fragment.FragmentBookRequest;
import org.byters.booksapp.view.ui.fragment.FragmentExplore;
import org.byters.booksapp.view.ui.fragment.FragmentListBooks;
import org.byters.booksapp.view.ui.fragment.FragmentProfile;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class Navigator implements INavigator {

    @Inject
    IHelperPopup helperPopup;

    private WeakReference<FragmentManager> refManager;
    private int layoutId;

    public Navigator() {
        BooksApplication.getComponent().inject(this);
    }

    @Override
    public void set(FragmentManager supportFragmentManager, int flContainer, Context context) {
        this.refManager = new WeakReference<>(supportFragmentManager);
        this.layoutId = flContainer;
        helperPopup.setContext(context);
    }

    @Override
    public void navigateExplore() {
        if (refManager == null || refManager.get() == null) return;
        refManager.get().beginTransaction()
                .replace(layoutId, new FragmentExplore())
                .commit();
    }

    @Override
    public void navigateBookRequest() {
        if (refManager == null || refManager.get() == null) return;
        refManager.get().beginTransaction()
                .replace(layoutId, new FragmentBookRequest())
                .commit();
    }

    @Override
    public void navigateBook(String book_id) {
        if (refManager == null || refManager.get() == null) return;
        refManager.get().beginTransaction()
                .replace(layoutId, new FragmentBook())
                .commit();
    }

    @Override
    public void navigateProfile() {
        if (refManager == null || refManager.get() == null) return;
        refManager.get().beginTransaction()
                .replace(layoutId, new FragmentProfile())
                .commit();
    }

    @Override
    public void navigateBookSearchResult() {
        if (refManager == null || refManager.get() == null) return;
        refManager.get().beginTransaction()
                .replace(layoutId, new FragmentListBooks())
                .commit();
    }

}
