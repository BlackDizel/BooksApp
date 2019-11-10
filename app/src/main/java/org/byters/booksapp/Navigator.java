package org.byters.booksapp;

import android.support.v4.app.FragmentManager;

import org.byters.booksapp.view.ui.fragment.FragmentExplore;

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

}
