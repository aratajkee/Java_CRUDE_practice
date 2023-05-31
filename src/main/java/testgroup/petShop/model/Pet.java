package testgroup.petShop.model;

import jakarta.persistence.*;


@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;

    @Override
    public String toString(){
        return "id: " + id +
                " Type: " + type +
                " Name: " + name;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }

}
