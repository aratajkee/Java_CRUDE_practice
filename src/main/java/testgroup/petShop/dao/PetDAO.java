package testgroup.petShop.dao;

import testgroup.petShop.model.Pet;

import java.util.List;

public interface PetDAO {
    void add(Pet pet);
    void delete(Pet pet);
    void edit(Pet pet);
    List<Pet> allPets();
    Pet getById(int id);
}
