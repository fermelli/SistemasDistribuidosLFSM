/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

/**
 *
 * @author fermelli
 */
public class Alumno {
    public String names;
    public String paternalSurname;
    public String maternalSurname;
    public String collegeID;

    
    public Alumno(String names, String paternalSurname, String maternalSurname, String collegeID) {
        this.names = names;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
        this.collegeID = collegeID;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setPaternalSurname(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    public void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getNames() {
        return names;
    }

    public String getPaternalSurname() {
        return paternalSurname;
    }

    public String getMaternalSurname() {
        return maternalSurname;
    }

    public String getCollegeID() {
        return collegeID;
    }
}
