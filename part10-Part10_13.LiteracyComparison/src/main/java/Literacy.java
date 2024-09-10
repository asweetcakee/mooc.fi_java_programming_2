/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Literacy{

    private String gender;
    private String country;
    private int year;
    private double literacyPercent;

    public Literacy(String gender, String country, int year, double literacyPercent) {
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public double getLiteracyPercent() {
        return literacyPercent;
    }

//    @Override
//    public int compareTo(Literacy o) {
//        return Double.compare(this.literacyPercent, o.getLiteracyPercent());
//    }

    @Override
    public String toString() {
        return this.getCountry()
                + " (" + this.getYear() + "), "
                + this.getGender() + ", "
                + this.getLiteracyPercent();
    }

}
