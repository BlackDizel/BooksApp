package org.byters.booksapp.view.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class ViewHolderBase extends RecyclerView.ViewHolder {

    public ViewHolderBase(ViewGroup container, int layoutRes) {
        super(LayoutInflater.from(container.getContext()).inflate(layoutRes, container, false));
    }

    public abstract void setData(int position);
}
