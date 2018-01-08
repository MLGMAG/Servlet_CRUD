package net.mlgmag.Servlets;

import net.mlgmag.Servlets.dao.HibernateDAOImpl.ManufacturerDaoImpl;
import net.mlgmag.Servlets.dao.HibernateDAOImpl.ProductDAOImpl;
import net.mlgmag.Servlets.dao.ManufacturerDAO;
import net.mlgmag.Servlets.dao.ProductDAO;

public enum EnumSingletonDAO {
    INSTANCE;
    ProductDAO productDAO;
    ManufacturerDAO manufacturerDAO;

    EnumSingletonDAO() {
        productDAO = new ProductDAOImpl();
        manufacturerDAO = new ManufacturerDaoImpl();
    }

    public  EnumSingletonDAO getInstance(){
        return INSTANCE;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public ManufacturerDAO getManufacturerDAO() {
        return manufacturerDAO;
    }
}
