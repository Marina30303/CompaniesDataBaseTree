package repository;

import entities.CompanyEntity;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марiна on 28.01.2018.
 */
public class CompanyRepository implements RepositoryInterface<CompanyEntity> {
    private Connection connection;

    public CompanyRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public CompanyEntity get(int id) {

        try(PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM companies WHERE id = ?;")) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return getCompanyEntity(resultSet);
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    @Override
    public void add(CompanyEntity companyEntity) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO companies (company_name, founder, spec, created, team, parent) VALUES(?, ?, ?, ?, ?, ?);")) {


            preparedStatement.setString(1, companyEntity.getCompanyName());
            preparedStatement.setString(2, companyEntity.getCompanyFounder());
            preparedStatement.setString(3, companyEntity.getCompanySpecialization());
            LocalDateTime now = LocalDateTime.now();
            preparedStatement.setTimestamp(4, Timestamp.valueOf(now.with(companyEntity.getCompanyCreationDate())));
            preparedStatement.setInt(5, companyEntity.getCompanyTeamNumber());
            preparedStatement.setInt(6, companyEntity.getCompanyParent());


            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    @Override
    public void remove(int id) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM companies WHERE id = ?;")) {
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(CompanyEntity companyEntity) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE companies SET company_name=?, founder=?, spec=?, created=?, team=?, parent=? WHERE id = ?;")) {


            preparedStatement.setString(1, companyEntity.getCompanyName());
            preparedStatement.setString(2, companyEntity.getCompanyFounder());
            preparedStatement.setString(3, companyEntity.getCompanySpecialization());
            LocalDateTime now = LocalDateTime.now();
            preparedStatement.setTimestamp(4, Timestamp.valueOf(now.with(companyEntity.getCompanyCreationDate())));
            preparedStatement.setInt(5, companyEntity.getCompanyTeamNumber());
            preparedStatement.setInt(6, companyEntity.getCompanyParent());
            preparedStatement.setInt(7, companyEntity.getId());

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<CompanyEntity> getAll() {


        try (Statement statement = this.connection.createStatement();

             ResultSet resultSet = statement.executeQuery("SELECT * FROM companies;")) {
            List<CompanyEntity> entitiesList = new ArrayList<>();

            while (resultSet.next()) entitiesList.add(getCompanyEntity(resultSet));

            return entitiesList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }







    private CompanyEntity getCompanyEntity(ResultSet resultSet) throws SQLException
    {
        int id = resultSet.getInt("id");
        String companyName = resultSet.getString("company_name");
        String companyFounder = resultSet.getString("founder");
        String companySpecialization = resultSet.getString("spec");
        LocalTime companyCreationDate = resultSet.getTime("created").toLocalTime().truncatedTo(ChronoUnit.DAYS);
        int companyTeamNumber = resultSet.getInt("team");
        int parent = resultSet.getInt("parent");

        return new CompanyEntity(id, companyName,companyFounder, companySpecialization, companyCreationDate, companyTeamNumber, parent);


    }



}
