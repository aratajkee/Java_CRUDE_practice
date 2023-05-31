package testgroup.petShop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testgroup.petShop.dao.PetDAO;
import testgroup.petShop.model.Pet;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class PetServiceImpl implements PetService{
    private PetDAO petDAO;
    @Autowired
    private void setPetDAO(PetDAO petDAO){
        this.petDAO = petDAO;
    }
    @Transactional
    public void add(Pet pet){
        petDAO.add(pet);
    }
    @Transactional
    public void delete(Pet pet){
       petDAO.delete(pet);
    }
    @Transactional
    public void edit(Pet pet){
        petDAO.edit(pet);
    }

    @Transactional
    public List<Pet> allPets(){
        return petDAO.allPets();
    }
    @Transactional
    public Pet getById(int id){
        return petDAO.getById(id);
    }
}
