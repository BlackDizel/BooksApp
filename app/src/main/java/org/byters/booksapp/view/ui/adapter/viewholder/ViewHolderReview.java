package org.byters.booksapp.view.ui.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.booksapp.view.presenter.IPresenterAdapterExplore;

import javax.inject.Inject;

public class ViewHolderReview extends ViewHolderBase implements View.OnClickListener {

    private final TextView tvBook, tvName, tvMessage;

    @Inject
    IPresenterAdapterExplore presenter;

    public ViewHolderReview(ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_explore_review);
        BooksApplication.getComponent().inject(this);
        tvBook = itemView.findViewById(R.id.tvBook);
        tvName = itemView.findViewById(R.id.tvName);
        tvMessage = itemView.findViewById(R.id.tvMessage);
        itemView.setOnClickListener(this);
    }

    @Override
    public void setData(int position) {
        tvName.setText(presenter.getReviewUsername(position));
        tvMessage.setText(presenter.getReviewMessage(position));
        tvBook.setText(presenter.getReviewBook(position));
    }

    @Override
    public void onClick(View view) {
        presenter.onClickReview(getAdapterPosition());
    }
}
