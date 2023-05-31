package testgroup.petShop.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.petShop.model.Pet;
import java.util.List;

@Repository
public class PetsDAOTestImplement implements PetDAO {

    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Pet pet) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(pet);
    }

    @Override
    public void delete(Pet pet) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(pet);
    }

    @Override
    public void edit(Pet pet) {
        Session session = sessionFactory.getCurrentSession();
        session.update(pet);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pet> allPets() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Pet").list();
    }

    @Override
    public Pet getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Pet.class, id);
    }
}
