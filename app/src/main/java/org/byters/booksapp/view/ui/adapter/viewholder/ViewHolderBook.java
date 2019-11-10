package org.byters.booksapp.view.ui.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.booksapp.view.presenter.IPresenterAdapterExplore;

import javax.inject.Inject;

public class ViewHolderBook extends ViewHolderBase implements View.OnClickListener {

    private final ImageView ivBook;
    private final TextView tvTitle;
    private final int carouselPosition;

    @Inject
    IPresenterAdapterExplore presenter;

    public ViewHolderBook(ViewGroup viewGroup, int carouselPosition) {
        super(viewGroup, R.layout.view_book);
        BooksApplication.getComponent().inject(this);
        this.carouselPosition = carouselPosition;
        ivBook = itemView.findViewById(R.id.ivBook);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        itemView.setOnClickListener(this);
    }

    @Override
    public void setData(int position) {
        Glide.with(itemView.getContext())
                .load(presenter.getBookCover(carouselPosition, position))
                .into(ivBook);

        tvTitle.setText(presenter.getBookTitle(carouselPosition, position));
    }

    @Override
    public void onClick(View view) {
        presenter.onClickBook(carouselPosition, getAdapterPosition());
    }
}
