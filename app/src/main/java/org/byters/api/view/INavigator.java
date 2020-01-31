package org.byters.api.view;

import android.support.v4.app.FragmentManager;

public interface INavigator {
    void navigateExplore();

    void set(FragmentManager supportFragmentManager, int flContainer);

    void navigateBookRequest();

    void navigateBook();

    void navigateProfile();
}
