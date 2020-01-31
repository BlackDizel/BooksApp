package org.byters.booksapp.view.presenter;

import org.byters.api.view.presenter.IPresenterProfile;
import org.byters.booksapp.BooksApplication;
import org.byters.api.view.INavigator;
import org.byters.booksapp.view.ui.adapter.listener.IAdapterBookInRentListener;
import org.byters.booksapp.view.ui.adapter.listener.IAdapterBookListener;

import javax.inject.Inject;

public class PresenterProfile implements IPresenterProfile {

    @Inject
    INavigator navigator;

    public PresenterProfile() {
        BooksApplication.getComponent().inject(this);
    }

    @Override
    public String getUsername() {
        return "Вася Вася";
    }

    @Override
    public String getBio() {
        return "Вася Петрович родился и вырос в Кондрово\\nУчился на отлично\\nХодит в библиотеки";
    }

    @Override
    public String getAvatar() {
        return "https://sun9-59.userapi.com/c830709/v830709622/fd8d5/fZodDrvkfJk.jpg";
    }

    @Override
    public int getReviewsNum() {
        return 3;
    }

    @Override
    public String getReviewMessage(int position) {
        return "Вдохновляющая книга, был рад прочитать ее. Надеюсь, автор напишет еще не одно достойное произвеление";

    }

    @Override
    public String getReviewBook(int position) {
        return "Город женщин";
    }

    @Override
    public void onClickReview(int adapterPosition) {
        navigator.navigateBook();
    }

    @Override
    public IAdapterBookListener getListenerFavorite() {
        return new ListenerFavorite();
    }

    @Override
    public IAdapterBookInRentListener getListenerBooksInRent() {
        return new ListenerBooksInRent();
    }

    private class ListenerFavorite implements IAdapterBookListener {
        @Override
        public int getItemsNum() {
            return 3;
        }

        @Override
        public void onClickItem(int adapterPosition) {
            navigator.navigateBook();
        }

        @Override
        public String getTitle(int position) {
            return "Книга обо все на свете";
        }

        @Override
        public String getCover(int position) {
            return "https://www.respublica.ru/uploads/01/00/00/1p/5j/large_6f80f36dc6cb0620.jpg";
        }
    }

    private class ListenerBooksInRent implements IAdapterBookInRentListener {
        @Override
        public String getReturnDate(int position) {
            return position == 0 ? "Вернуть завтра"
                    : position == 1 ? "Просрочено 1 день"
                    : "Вернуть 10 декабря";
        }

        @Override
        public int getItemsNum() {
            return 4;
        }

        @Override
        public void onClickItem(int adapterPosition) {
            navigator.navigateBook();
        }

        @Override
        public String getTitle(int position) {
            return position==0?"Город женщин"
                    :position==1?"Быть книголюбом"
                    :"Общество мертвых поэтов";
        }

        @Override
        public String getCover(int position) {
            return position==0?"https://j.livelib.ru/boocover/1003056421/200/795b/Elizabet_Gilbert__Gorod_zhenschin.jpg"
                    :position==1?"https://j.livelib.ru/boocover/1003237146/200/9fa3/Debbi_Tang__Byt_knigolyubom.jpg"
                    :"https://i.livelib.ru/boocover/1003034417/200/baf0/Nensi_GorovitsKlejnbaum__Obschestvo_mertvyh_poetov.jpg";
        }
    }
}
