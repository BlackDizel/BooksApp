package org.byters.booksapp;

import android.support.v4.app.FragmentManager;

import org.byters.api.view.INavigator;
import org.byters.booksapp.view.ui.fragment.FragmentBook;
import org.byters.booksapp.view.ui.fragment.FragmentBookRequest;
import org.byters.booksapp.view.ui.fragment.FragmentExplore;
import org.byters.booksapp.view.ui.fragment.FragmentProfile;

import java.lang.ref.WeakReference;

public class Navigator implements INavigator {

    private WeakReference<FragmentManager> refManager;
    private int layoutId;

    @Override
    public void set(FragmentManager supportFragmentManager, int flContainer) {
        this.refManager = new WeakReference<>(supportFragmentManager);
        this.layoutId = flContainer;
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
    public void navigateBook() {
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

}
