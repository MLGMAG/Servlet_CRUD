package net.mlgmag.Servlets.dao.HibernateDAOImpl;

import net.mlgmag.Servlets.dao.ProductDAO;
import net.mlgmag.Servlets.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class ProductDAOImpl implements ProductDAO {
    public void save(Product product) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(product);

        transaction.commit();
        session.close();
    }

    public void update(Product product) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(product);

        transaction.commit();
        session.close();
    }

    public void delete(Product product) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(product);

        transaction.commit();
        session.close();
    }

    public List<Product> getAll() {
        Session session = HibernateInit.getSessionFactory().openSession();

        List<Product> list = session.createQuery("FROM Product").list();

        session.close();
        return list;
    }

    public Product getByID(UUID uuid) {

        Session session = HibernateInit.getSessionFactory().openSession();

        Query query = session.createQuery("FROM Product m WHERE m.id =:id");
        query.setParameter("id",uuid);

        Product product = (Product) query.uniqueResult();

        session.close();
        return product;
    }
}
