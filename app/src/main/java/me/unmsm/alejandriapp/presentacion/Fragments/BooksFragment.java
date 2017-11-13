package me.unmsm.alejandriapp.presentacion.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.core.BaseActivity;
import me.unmsm.alejandriapp.core.BaseFragment;
import me.unmsm.alejandriapp.data.entity.BooksEntity;
import me.unmsm.alejandriapp.presentacion.adapter.BookAdapter;
import me.unmsm.alejandriapp.presentacion.contract.BooksContract;
import me.unmsm.alejandriapp.presentacion.util.ProgressDialogCustom;


public class BooksFragment extends BaseFragment implements BooksContract.View {
    ListView list;
    @BindView(R.id.recycler_book)
    RecyclerView recyclerbooks;
    @BindView(R.id.tv_no_items)
    TextView tvNoItems;
    private LinearLayoutManager layoutManager;
    private ProgressDialogCustom mProgressDialogCustom;
    Unbinder unbinder;
    private BooksContract.Presenter presenter;
    private List<BooksEntity> booksEntityList;
    private BookAdapter bookAdapter;
    private LinearLayout linearLayout;


    public static BooksFragment newInstance() { return new BooksFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_books, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(),"Cargando...");
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerbooks.setLayoutManager(layoutManager);
        bookAdapter = new BookAdapter(getContext());
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void loadBookData(List<BooksEntity> list) {
        if(bookAdapter!=null){
            bookAdapter.setList(list);
            recyclerbooks.setAdapter(bookAdapter);
            bookAdapter.notifyDataSetChanged();
            tvNoItems.setVisibility(list.size()!=0?View.GONE:View.VISIBLE);
        }
    }
    @Override
    public void setLoadingIndicator(boolean active) {
        if (mProgressDialogCustom != null) {
            if (active) {
                mProgressDialogCustom.show();
            } else {
                mProgressDialogCustom.dismiss();
            }
        }
    }

    @Override
    public void setMessageError(String error) {
        ((BaseActivity)getActivity()).showMessageError(error);
    }

    @Override
    public void setDialogMessage(String message) {
        ((BaseActivity)getActivity()).showMessage(message);
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setPresenter(BooksContract.Presenter presenter) {
        this.presenter=presenter;
    }


}