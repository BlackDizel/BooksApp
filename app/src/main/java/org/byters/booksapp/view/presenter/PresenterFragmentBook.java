package org.byters.booksapp.view.presenter;

import org.byters.api.view.presenter.IPresenterFragmentBook;

public class PresenterFragmentBook implements IPresenterFragmentBook {

    @Override
    public String getBookImage() {
        //todo
        return "https://i.livelib.ru/boocover/1002914040/o/2a0f/Alan_Bredli__V_mogile_ne_opasen_sud_molvy.jpeg";
    }

    @Override
    public String getBookTitle() {
        //todo
        return "В могиле не опасен суд молвы";
    }

    @Override
    public String getBookAuthor() {
        //todo
        return "Алан Брэдли";
    }

    @Override
    public String getBookISBN() {
        //todo
        return " 978-5-17-111567-8";
    }

    @Override
    public void onClickReserve() {
        //todo
    }

    @Override
    public void onClickFavorite() {
//todo
    }

    @Override
    public void onClickReview() {
        //// TODO: 11/10/19
    }

    @Override
    public String getLibraryTitle(int position) {
        //// TODO: 11/10/19

        return position == 0 ? "Кондрово"
                : position == 1 ? "Дворцы"
                : position == 2 ? "Полотняный завод"
                : "";
    }

    @Override
    public String getLibraryBookAvailable(int position) {
        //// TODO: 11/10/19

        return position == 0 ? "Доступно"
                : position == 1 ? "Будет завтра"
                : "Нет в наличии";
    }

    @Override
    public int getItemsNum() {
        ////     TODO: 11/10/19
        return 3;
    }

    @Override
    public int getItemsNumReviews() {
        //todo
        return 4;
    }

    @Override
    public String getReviewAvatar(int position) {
        //todo
        return "https://sun9-59.userapi.com/c830709/v830709622/fd8d5/fZodDrvkfJk.jpg";
    }

    @Override
    public String getReviewUsername(int position) {
        //todo
        return "Вася Петрович";
    }

    @Override
    public String getReview(int position) {
        //todo
        return "Нет, ну какая красота!!! Зачем так со мной поступать? Только закончила книгу, а хочется тут же взяться за продолжение. Это восхитительно! В первую очередь, что мне безумно нравится в книгах про Флавию - это искрометный, гениальный, тонкий юмор! Ну вот только послушайте!";
    }
}
