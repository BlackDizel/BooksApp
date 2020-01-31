package org.byters.booksapp.view.ui.adapter.viewholder;

import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.api.view.presenter.IPresenterAdapterExplore;

import javax.inject.Inject;

public class ViewHolderExploreSearch extends ViewHolderBase {
    private final EditText etSeatch;

    @Inject
    IPresenterAdapterExplore presenter;

    public ViewHolderExploreSearch(ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_explore_search);
        BooksApplication.getComponent().inject(this);
        etSeatch = itemView.findViewById(R.id.etSearch);
        etSeatch.setOnEditorActionListener(new ListenerAction());
    }

    @Override
    public void setData(int position) {

    }

    private class ListenerAction implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
            if (actionId == EditorInfo.IME_ACTION_SEARCH)
                presenter.onSearch(etSeatch.getText().toString());
            return false;
        }
    }
}
