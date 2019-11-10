package org.byters.booksapp.view.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.INavigator;
import org.byters.booksapp.R;

import javax.inject.Inject;

public class ActivityMain extends AppCompatActivity {

    @Inject
    INavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BooksApplication.getComponent().inject(this);
        navigator.set(getSupportFragmentManager(), R.id.flContainer);
        navigator.navigateExplore();

    }
}
