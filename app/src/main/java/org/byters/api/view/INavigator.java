package org.byters.api.view;

import android.content.Context;
import android.support.v4.app.FragmentManager;

public interface INavigator {
    void set(FragmentManager supportFragmentManager, int flContainer, Context context);

    void navigateExplore();

    void navigateBookRequest();

    void navigateBook(String book_id);

    void navigateProfile();

    void navigateBookSearchResult();
}
