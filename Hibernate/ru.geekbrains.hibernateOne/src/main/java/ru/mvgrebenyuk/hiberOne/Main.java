package ru.mvgrebenyuk.hiberOne;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
            try {
                ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
                System.out.println(productDao.findById(2l));
                productDao.deleteById(2l);
                System.out.println(productDao.findAll());

                Product product = new Product("Meet", 2);
                productDao.saveOrUpdate(product);
                System.out.println(productDao.findAll());


            } catch (Exception e){
                e.printStackTrace();
            } finally {
                sessionFactoryUtils.shotdown();
            }
    }
}
