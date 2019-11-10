package org.byters.booksapp.view.ui.adapter.viewholder.util;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.byters.booksapp.R;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreCarouselBase;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private Context context;

    public SpacesItemDecoration(Context context) {
        this.context = context;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int divider = (int) context.getResources().getDimension(R.dimen.divider);

        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.left = divider;

        }
    }
}
