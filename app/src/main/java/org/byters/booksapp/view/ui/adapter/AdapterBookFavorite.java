package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.byters.booksapp.R;
import org.byters.booksapp.view.ui.adapter.listener.IAdapterBookListener;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;

public class AdapterBookFavorite extends AdapterBase {

    private final IAdapterBookListener listener;

    public AdapterBookFavorite(IAdapterBookListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderBook(viewGroup);
    }

    @Override
    public int getItemCount() {
        return listener.getItemsNum();
    }

    private class ViewHolderBook extends ViewHolderBase implements View.OnClickListener {
        private final ImageView ivCover;
        private final TextView tvTitle;

        public ViewHolderBook(ViewGroup viewGroup) {
            super(viewGroup, R.layout.view_book);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivCover = itemView.findViewById(R.id.ivBook);
            itemView.setOnClickListener(this);
        }

        @Override
        public void setData(int position) {
            tvTitle.setText(listener.getTitle(position));
            Glide.with(itemView.getContext())
                    .load(listener.getCover(position))
                    .into(ivCover);
        }

        @Override
        public void onClick(View view) {
            listener.onClickItem(getAdapterPosition());
        }
    }
}
