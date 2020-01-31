package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.byters.api.view.ui.adapter.AdapterBase;
import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.api.view.presenter.IPresenterAdapterBookSuggest;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;

import javax.inject.Inject;

public class AdapterBookRequest extends AdapterBase {

    @Inject
    IPresenterAdapterBookSuggest presenter;

    public AdapterBookRequest() {
        BooksApplication.getComponent().inject(this);
    }

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderBookSuggest(viewGroup);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsNum();
    }

    private class ViewHolderBookSuggest extends ViewHolderBase
            implements View.OnClickListener {

        private final ImageView ivBook;
        private final TextView tvTitle, tvStore, tvPrice;

        public ViewHolderBookSuggest(ViewGroup viewGroup) {
            super(viewGroup, R.layout.view_book_suggest);

            ivBook = itemView.findViewById(R.id.ivBook);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvStore = itemView.findViewById(R.id.tvStore);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void setData(int position) {
            Glide.with(itemView.getContext())
                    .load(presenter.getImage(position))
                    .into(ivBook);

            tvTitle.setText(presenter.getBookTitle(position));
            tvStore.setText(presenter.getBookStore(position));
            tvPrice.setText(presenter.getBookPrice(position));

        }

        @Override
        public void onClick(View view) {
            presenter.onClickBook(getAdapterPosition());
        }
    }
}
