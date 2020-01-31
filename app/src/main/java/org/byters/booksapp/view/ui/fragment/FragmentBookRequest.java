package org.byters.booksapp.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.byters.api.view.presenter.IPresenterBookRequest;
import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;

import javax.inject.Inject;

public class FragmentBookRequest extends Fragment implements View.OnClickListener {

    @Inject
    IPresenterBookRequest presenter;

    private EditText etBookTitle;
    private EditText etBookAuthor;
    private EditText etBookISBN;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BooksApplication.getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_request, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        etBookTitle = view.findViewById(R.id.etBookTitle);
        etBookAuthor = view.findViewById(R.id.etBookAuthor);
        etBookISBN = view.findViewById(R.id.etBookISBN);
        view.findViewById(R.id.tvBookRequest).setOnClickListener(this);
        /*RecyclerView rvItems = view.findViewById(R.id.rvBookSuggest);
        rvItems.setAdapter(new AdapterBookRequest());
        rvItems.addItemDecoration(new SpacesItemDecoration(view.getContext()));*/
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tvBookRequest)
            presenter.onClickRequest(etBookTitle.getText().toString(),
                    etBookAuthor.getText().toString(),
                    etBookISBN.getText().toString());
    }
}
