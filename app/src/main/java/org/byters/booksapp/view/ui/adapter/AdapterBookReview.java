package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.booksapp.view.presenter.IPresenterFragmentBook;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;

import javax.inject.Inject;

public class AdapterBookReview extends AdapterBase {

    @Inject
    IPresenterFragmentBook presenter;

    public AdapterBookReview() {
        BooksApplication.getComponent().inject(this);
    }

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderReviewFull(viewGroup);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsNumReviews();
    }

    private class ViewHolderReviewFull extends ViewHolderBase {
        private final ImageView ivAvatar;
        private final TextView tvUsername;
        private final TextView tvReview;

        public ViewHolderReviewFull(ViewGroup viewGroup) {
            super(viewGroup, R.layout.view_book_review);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvReview = itemView.findViewById(R.id.tvReview);
        }

        @Override
        public void setData(int position) {
            Glide.with(itemView.getContext())
                    .load(presenter.getReviewAvatar(position))
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivAvatar);

            tvUsername.setText(presenter.getReviewUsername(position));

            tvReview.setText(presenter.getReview(position));
        }
    }
}
