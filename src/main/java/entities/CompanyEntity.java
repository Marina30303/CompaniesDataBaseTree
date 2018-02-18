package entities;

import java.time.LocalTime;

/**
 * Created by Марiна on 18.12.2017.
 */
public class CompanyEntity {

    private int id;
    private String companyName;
    private String companyFounder;
    private String companySpecialization;
    private LocalTime companyCreationDate;
    private int companyTeamNumber;
    private int parent;

    public CompanyEntity(int id, String companyName,
                         String companyFounder,
                         String companySpecialization,
                         LocalTime companyCreationDate,
                         int companyTeamNumber, int parent) {
        this.id = id;
        this.companyName = companyName;
        this.companyFounder = companyFounder;
        this.companySpecialization = companySpecialization;
        this.companyCreationDate = companyCreationDate;
        this.companyTeamNumber = companyTeamNumber;
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyFounder() {
        return companyFounder;
    }

    public void setCompanyFounder(String companyFounder) {
        this.companyFounder = companyFounder;
    }

    public String getCompanySpecialization() {
        return companySpecialization;
    }

    public void setCompanySpecialization(String companySpecialization) {
        this.companySpecialization = companySpecialization;
    }

    public LocalTime getCompanyCreationDate() {
        return companyCreationDate;
    }

    public void setCompanyCreationDate(LocalTime companyCreationDate) {
        this.companyCreationDate = companyCreationDate;
    }

    public int getCompanyTeamNumber() {
        return companyTeamNumber;
    }

    public void setCompanyTeamNumber(int companyTeamNumber) {
        this.companyTeamNumber = companyTeamNumber;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyFounder='" + companyFounder + '\'' +
                ", companySpecialization='" + companySpecialization + '\'' +
                ", companyCreationDate=" + companyCreationDate +
                ", companyTeamNumber=" + companyTeamNumber +
                '}';
    }

    public int getCompanyParent() {
        return parent;
    }

    public void setCompanyParent(int parent) {
        this.parent = parent;
    }
}
