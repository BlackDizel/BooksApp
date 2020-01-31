package org.byters.api.view.ui.adapter;

import android.support.v7.widget.RecyclerView;

import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;

public abstract class AdapterBase extends RecyclerView.Adapter<ViewHolderBase> {

    @Override
    public void onBindViewHolder(ViewHolderBase holder, int position) {
        holder.setData(position);
    }

}
