package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.booksapp.view.presenter.IPresenterFragmentBook;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;

import javax.inject.Inject;

public class AdapterBookLibrary extends AdapterBase {

    @Inject
    IPresenterFragmentBook presenter;

    public AdapterBookLibrary() {
        BooksApplication.getComponent().inject(this);
    }

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderLibrary(viewGroup);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsNum();
    }

    private class ViewHolderLibrary extends ViewHolderBase {
        private final TextView tvTitle;
        private final TextView tvAvailable;

        ViewHolderLibrary(ViewGroup viewGroup) {
            super(viewGroup, R.layout.view_library);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAvailable = itemView.findViewById(R.id.tvAvailable);
        }

        @Override
        public void setData(int position) {
            tvTitle.setText(presenter.getLibraryTitle(position));
            tvAvailable.setText(presenter.getLibraryBookAvailable(position));
        }
    }
}
