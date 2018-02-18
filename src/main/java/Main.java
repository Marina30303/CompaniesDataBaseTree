import entities.CompanyEntity;
import repository.CompanyRepository;
import util.DbConnector;

import java.sql.Connection;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Марiна on 28.01.2018.
 */
public class Main


{

    public static void main(String[] args) {




        DbConnector dbConnector = DbConnector.getINSTANCE();
        Connection connection = dbConnector.getConnection();
        System.out.println(connection == null ? "NO CONNECTION !" : "CONNECTION SUCCESS !\n");


        CompanyRepository companyRepository = new CompanyRepository(connection);

      //  companyRepository.add(new CompanyEntity(5,"X-WEB", "Cory Well", "Space Exploration - WEB", LocalTime.now(), 300,1));
       // companyRepository.add(new CompanyEntity(6,"X-Equipment", "Dave Greg", "Space Exploration- Equipment", LocalTime.now(), 400,1));
        companyRepository.add(new CompanyEntity(6,"Apple", "Steve Jobs", "Hardware&Software", LocalTime.now(), 18000,0));

        List<CompanyEntity> all = companyRepository.getAll();
        all.forEach(System.out::println);
    }
}
