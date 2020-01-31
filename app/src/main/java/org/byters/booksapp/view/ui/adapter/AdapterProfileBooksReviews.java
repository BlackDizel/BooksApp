package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.byters.api.view.ui.adapter.AdapterBase;
import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.api.view.presenter.IPresenterProfile;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;

import javax.inject.Inject;

public class AdapterProfileBooksReviews extends AdapterBase {

    @Inject
    IPresenterProfile presenter;

    public AdapterProfileBooksReviews() {
        BooksApplication.getComponent().inject(this);
    }

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderReview(viewGroup);
    }

    @Override
    public int getItemCount() {
        return presenter.getReviewsNum();
    }

    private class ViewHolderReview extends ViewHolderBase implements View.OnClickListener {

        private final TextView tvBook, tvName, tvMessage;

        ViewHolderReview(ViewGroup viewGroup) {
            super(viewGroup, R.layout.view_explore_review);
            tvBook = itemView.findViewById(R.id.tvBook);
            tvName = itemView.findViewById(R.id.tvName);
            tvMessage = itemView.findViewById(R.id.tvMessage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void setData(int position) {
            tvMessage.setText(presenter.getReviewMessage(position));
            tvBook.setText(presenter.getReviewBook(position));
        }

        @Override
        public void onClick(View view) {
            presenter.onClickReview(getAdapterPosition());
        }
    }
}
