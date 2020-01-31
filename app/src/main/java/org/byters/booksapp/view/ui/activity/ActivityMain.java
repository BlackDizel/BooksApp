package org.byters.booksapp.view.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.byters.booksapp.BooksApplication;
import org.byters.api.view.INavigator;
import org.byters.booksapp.R;

import javax.inject.Inject;

public class ActivityMain extends AppCompatActivity
        implements View.OnClickListener {

    @Inject
    INavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BooksApplication.getComponent().inject(this);
        navigator.set(getSupportFragmentManager(), R.id.flContainer);
        navigator.navigateExplore();

        findViewById(R.id.ivExplore).setOnClickListener(this);
        findViewById(R.id.ivProfile).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ivExplore)
            navigator.navigateExplore();
        if (view.getId() == R.id.ivProfile)
            navigator.navigateProfile();
    }
}
