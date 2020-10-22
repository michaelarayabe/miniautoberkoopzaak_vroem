package be.intecbrussel.testapps;

import be.intecbrussel.data.OfficeDao;
import be.intecbrussel.data.OfficeDaoImpl;
import be.intecbrussel.entities.Office;

public class OfficeApp {
    public static void main(String[] args) {

        OfficeDao officeDao = new OfficeDaoImpl();

        //#################### Creating new Office ###################################

        Office office = new Office();
        office.setOfficeCode("8");
        office.setAddressLine1("Leiekaai");
        office.setCity("Addis Ababa");
        office.setAddressLine2("Groene Valley");
        office.setCountry("Ethiopia");
        office.setPhone("123 123 123");
        office.setPostalCode("102122");
        office.setState("Tigray");
        office.setTerritory("Africa");

        officeDao.createOffice(office); //-----------WORKS




        //#################### Read Office using office code ###################################

        //System.out.println(officeDao.readOffice("1")); //----------------WORKS

        //#################### Update Office###################################

        Office officeToBeUpdated = officeDao.readOffice("8");

        officeToBeUpdated.setCity("Mekelle");

        officeDao.updateOffice(officeToBeUpdated); //----------------WORKS





        //#################### Delete Office ###################################


        Office officeToBeDeleted = officeDao.readOffice("8");

        officeDao.deleteOffice(officeToBeDeleted); //----------------WORKS





    }
}
