package org.byters.booksapp.view.ui.adapter.viewholder;

import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.byters.booksapp.R;
import org.byters.api.view.ui.adapter.AdapterBase;
import org.byters.booksapp.view.ui.adapter.viewholder.util.SpacesItemDecoration;

public class ViewHolderExploreCarouselBase extends ViewHolderBase {

    protected final AdapterBase adapter;
    private final TextView tvTitle;

    public ViewHolderExploreCarouselBase(ViewGroup viewGroup, @StringRes int titleRes, AdapterBase adapter) {
        super(viewGroup, R.layout.view_list);
        RecyclerView rvItems = itemView.findViewById(R.id.rvItems);
        rvItems.setAdapter(adapter);
        rvItems.addItemDecoration(new SpacesItemDecoration(itemView.getContext()));
       // new PagerSnapHelper().attachToRecyclerView(rvItems);
//
        tvTitle = itemView.findViewById(R.id.tvTitle);
        setTitle(itemView.getContext().getString(titleRes));

        this.adapter = adapter;

    }

    protected void setTitle(String title) {
        tvTitle.setText(title);
        tvTitle.setVisibility(TextUtils.isEmpty(tvTitle.getText()) ? View.GONE : View.VISIBLE);
    }

    @Override
    public void setData(int position) {

    }

}
