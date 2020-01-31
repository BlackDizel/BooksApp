package org.byters.booksapp.view.ui.util;

import android.content.Context;
import android.widget.Toast;

import org.byters.api.view.ui.util.IHelperPopup;

import java.lang.ref.WeakReference;

public class HelperPopup implements IHelperPopup {

    private WeakReference<Context> refContext;

    public HelperPopup() {
    }

    @Override
    public void setContext(Context context) {
        this.refContext = new WeakReference<>(context);
    }

    @Override
    public void showMessage(int messageRes) {
        if (refContext == null || refContext.get() == null) return;
        Toast.makeText(refContext.get(), messageRes, Toast.LENGTH_SHORT).show();
    }
}
