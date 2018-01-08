package net.mlgmag.Servlets.dao.HibernateDAOImpl;

import net.mlgmag.Servlets.dao.ManufacturerDAO;
import net.mlgmag.Servlets.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class ManufacturerDaoImpl implements ManufacturerDAO {
    public ManufacturerDaoImpl() {
    }

    public void save(Manufacturer manufacturer) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(manufacturer);

        transaction.commit();
        session.close();
    }

    public void update(Manufacturer manufacturer) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(manufacturer);

        transaction.commit();
        session.close();
    }

    public void delete(Manufacturer manufacturer) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(manufacturer);

        transaction.commit();
        session.close();
    }

    public List<Manufacturer> getAll() {
        Session session = HibernateInit.getSessionFactory().openSession();

        List<Manufacturer> list = session.createQuery("FROM Manufacturer").list();

        session.close();
        return list;
    }

    public Manufacturer getByID(UUID uuid) {
        Session session = HibernateInit.getSessionFactory().openSession();

        Query query = session.createQuery("FROM Manufacturer m WHERE m.id =:id");
        query.setParameter("id", uuid);

        Manufacturer manufacturer = (Manufacturer) query.uniqueResult();

        session.close();
        return manufacturer;
    }

    public Manufacturer getByName(String name){
        Session session = HibernateInit.getSessionFactory().openSession();

        Query query = session.createQuery("FROM Manufacturer m WHERE m.name =:name");
        query.setParameter("name", name);

        Manufacturer manufacturer = (Manufacturer) query.uniqueResult();

        session.close();
        return manufacturer;
    }
}
