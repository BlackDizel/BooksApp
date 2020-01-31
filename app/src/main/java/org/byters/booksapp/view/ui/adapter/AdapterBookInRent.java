package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.byters.api.view.ui.adapter.AdapterBase;
import org.byters.booksapp.R;
import org.byters.booksapp.view.ui.adapter.listener.IAdapterBookInRentListener;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;

public class AdapterBookInRent extends AdapterBase {

    private final IAdapterBookInRentListener listener;

    public AdapterBookInRent(IAdapterBookInRentListener listener) {
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
        private final TextView tvDate;

        public ViewHolderBook(ViewGroup viewGroup) {
            super(viewGroup, R.layout.view_book_in_rent);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivCover = itemView.findViewById(R.id.ivBook);
            tvDate = itemView.findViewById(R.id.tvReturnDate);
            itemView.setOnClickListener(this);
        }

        @Override
        public void setData(int position) {
            tvTitle.setText(listener.getTitle(position));
            tvDate.setText(listener.getReturnDate(position));
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
