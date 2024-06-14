//package uno.dos.tres.listener;
//
//import jakarta.servlet.ServletContextEvent;
//import jakarta.servlet.ServletContextListener;
//import uno.dos.tres.dao.ConnectionPool.ConnectionPool;
//
//public class MyContextListener implements ServletContextListener {
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        // Код, выполняющийся при старте приложения
//        System.out.println("Web application is starting up");
//        ConnectionPool.getInstance();
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        // Код, выполняющийся при завершении работы приложения
//        System.out.println("Web application is shutting down");
//        ConnectionPool.getInstance().dispose();
//
//    }
//
//}
