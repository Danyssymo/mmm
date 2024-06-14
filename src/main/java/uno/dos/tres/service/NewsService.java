package uno.dos.tres.service;

import uno.dos.tres.bean.News;

import java.util.List;

public interface NewsService {

    List<News> getNews() throws ServiceException;

}
