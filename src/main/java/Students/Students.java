package Students;

public class Students  implements  Comparable<Students>{
    private String id;
    private String full_name;
    private int gender;
    private String born;
    private String address;
    private int phone_number;
    private String email;
    private double gpa;

    public Students() {
    }

    public Students(String id, String full_name, int gender, String born,
                    String address, int phone_number, String email, double gpa) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.born = born;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender=" + gender +
                ", born='" + born + '\'' +
                ", address='" + address + '\'' +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Students o) {
        if (this.gpa > o.gpa) {
            return 1;
        } else if (this.gpa < o.gpa) {
            return -1;
        }
        return 0;
    }
}
