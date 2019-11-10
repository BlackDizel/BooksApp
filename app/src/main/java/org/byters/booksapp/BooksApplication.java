package org.byters.booksapp;

import android.app.Application;
import android.content.Context;

public class BooksApplication extends Application {

    private static AppComponent component;
    private static BooksApplication app;

    public static AppComponent getComponent() {
        return component;
    }

    public static Context context() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        component = buildComponent();
    }

    private AppComponent buildComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule())
                .build();
    }
}
