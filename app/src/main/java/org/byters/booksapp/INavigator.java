package org.byters.booksapp;

import android.support.v4.app.FragmentManager;

public interface INavigator {
    void navigateExplore();

    void set(FragmentManager supportFragmentManager, int flContainer);

    void navigateBookRequest();

    void navigateBook();
}
