package org.byters.booksapp.view.ui.adapter.viewholder;

import android.graphics.Rect;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.byters.booksapp.R;
import org.byters.booksapp.view.ui.adapter.AdapterBase;

public class ViewHolderExploreCarouselBase extends ViewHolderBase {

    protected final AdapterBase adapter;
    private final TextView tvTitle;

    public ViewHolderExploreCarouselBase(ViewGroup viewGroup, @StringRes int titleRes, AdapterBase adapter) {
        super(viewGroup, R.layout.view_list);
        RecyclerView rvItems = itemView.findViewById(R.id.rvItems);
        rvItems.setAdapter(adapter);
        rvItems.addItemDecoration(new SpacesItemDecoration());
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

    private class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int divider = (int) itemView.getContext().getResources().getDimension(R.dimen.divider);

            if (parent.getChildAdapterPosition(view) != 0) {
                outRect.left = divider;

            }
        }
    }
}
