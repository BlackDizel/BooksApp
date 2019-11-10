package org.byters.booksapp.view.presenter;

public class PresenterAdapterBookSuggest implements IPresenterAdapterBookSuggest {
    @Override
    public int getItemsNum() {
        //todo
        return 5;
    }

    @Override
    public String getBookTitle(int position) {
        //todo
        return "Растениеводство от А до Я";
    }

    @Override
    public String getImage(int position) {
        //todo
        return "https://cdn.f.kz/prod/1332/1331228_550.jpg";
    }

    @Override
    public String getBookStore(int position) {
        //todo
        return position == 0 ? "OZON"
                : position == 1 ? "Wildberries"
                : position == 2 ? "BERU"
                : "BOOK24";
    }

    @Override
    public String getBookPrice(int position) {
        //todo
        return position == 0 ? "200P"
                : position == 1 ? "300P"
                : position == 2 ? "250P"
                : "300P";
    }

    @Override
    public void onClickBook(int adapterPosition) {
//todo
    }
}
