package nl.aalten.mijnwinkelwagen.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "boodschappenlijst")
public class Boodschappenlijst {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "boodschappenlijst", orphanRemoval = true)
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void verwijderItem(Long itemId) {
        items.remove(itemId);
    }

    public void addUnit(Long itemId) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                item.addUnit();
            }
        }
    }

    public void subtractUnit(Long itemId) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                item.subtractUnit();
            }
        }
    }

    public void addItem(Item item) {
        items.add(item);
        item.setBoodschappenlijst(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
