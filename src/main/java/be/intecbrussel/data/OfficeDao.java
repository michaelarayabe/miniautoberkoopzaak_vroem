package be.intecbrussel.data;

import be.intecbrussel.entities.Office;

public interface OfficeDao {

    void createOffice(Office office);
    Office readOffice(String officeCode);
    void updateOffice(Office office);
    void deleteOffice(Office office);

}
