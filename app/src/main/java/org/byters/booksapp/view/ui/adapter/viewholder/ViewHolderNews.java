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

public class ViewHolderNews extends ViewHolderBase implements View.OnClickListener {

    private final ImageView ivNews;
    private final TextView tvTitle;

    @Inject
    IPresenterAdapterExplore presenter;

    public ViewHolderNews(ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_news);
        BooksApplication.getComponent().inject(this);
        ivNews = itemView.findViewById(R.id.ivNews);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        itemView.setOnClickListener(this);
    }

    @Override
    public void setData(int position) {
        Glide.with(itemView.getContext())
                .load(presenter.getNewsImage(position))
                .into(ivNews);

        tvTitle.setText(presenter.getNewsTitle(position));
    }

    @Override
    public void onClick(View view) {
        presenter.onClickNews(getAdapterPosition());
    }
}
