package org.byters.booksapp.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.booksapp.view.presenter.IPresenterExplore;
import org.byters.booksapp.view.presenter.listener.IPresenterMainListener;
import org.byters.booksapp.view.ui.adapter.AdapterExplore;

import javax.inject.Inject;

public class FragmentExplore extends Fragment implements View.OnClickListener {

    @Inject
    IPresenterExplore presenter;

    private TextView tvLibrary;
    private AdapterExplore adapter;
    private IPresenterMainListener listenerPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BooksApplication.getComponent().inject(this);
        presenter.setListener(listenerPresenter = new ListenerPresenter());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        initViews(view);
        presenter.onCreateView();
        return view;


    }

    private void initViews(View view) {
        RecyclerView rvItems = view.findViewById(R.id.rvItems);
        rvItems.setAdapter(adapter = new AdapterExplore());

        tvLibrary = view.findViewById(R.id.tvLibrary);
        tvLibrary.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tvLibrary)
            presenter.onClickLibrary();
    }

    private class ListenerPresenter implements IPresenterMainListener {
        @Override
        public void setLibrary(String library) {
            tvLibrary.setText(library);
        }
    }
}
