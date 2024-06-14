package uno.dos.tres.dao;

import uno.dos.tres.bean.News;

import java.util.List;

public interface NewsDao {

    void addNews(News news) throws DaoException;
    void deleteNews(News news) throws DaoException;
    void updateNews(News news) throws DaoException;
    List<News> getNews() throws DaoException;


}
