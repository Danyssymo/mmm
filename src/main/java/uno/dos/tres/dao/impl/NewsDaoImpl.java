package uno.dos.tres.dao.impl;

import uno.dos.tres.bean.News;
import uno.dos.tres.dao.DaoException;
import uno.dos.tres.dao.NewsDao;

import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {
    @Override
    public void addNews(News news) throws DaoException {

    }

    @Override
    public void deleteNews(News news) throws DaoException {

    }

    @Override
    public void updateNews(News news) throws DaoException {

    }

    @Override
    public List<News> getNews() throws DaoException {
        List<News> list = new ArrayList<>();
        list.add(new News("Forest Exploration", "Discover the wonders of lush forests and immerse yourself in nature's beauty.", "images/camping-1.jpg"));
        list.add(new News("Forest Exploration", "Discover the wonders of lush forests and immerse yourself in nature's beauty.", "images/camping-2.jpg"));
        list.add(new News("Forest Exploration", "Discover the wonders of lush forests and immerse yourself in nature's beauty.", "images/camping-3.jpg"));
        return list;
    }
}
