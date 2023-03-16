package StudentsDao;

import Students.Students;

import Students.Students;
import Connection.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentssDAO {
    public List<Students> getAll() {

        List<Students> StudentsList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM `students`";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students s = new Students();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBorn(rs.getString("born"));
                s.setAddress(rs.getString("address"));
                s.setPhone_number(rs.getInt("phone_number"));
                s.setEmail(rs.getString("email"));
                s.setGpa(rs.getFloat("gpa"));
                StudentsList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return StudentsList;
    }

    public Students getById(String id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql =  String.format("SELECT * FROM students WHERE id = '%s'", id);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Students s = null;
            if (rs.next()) {
                s = new Students();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBorn(rs.getString("born"));
                s.setAddress(rs.getString("address"));
                s.setPhone_number(rs.getInt("phone_number"));
                s.setEmail(rs.getString("email"));
                s.setGpa(rs.getFloat("gpa"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Students s) {
        final String sql = String.format("INSERT INTO `students` (`id`,`full_name`,`gender`,`born`,`address`,`phone_number`,`email`,`gpa`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%f')",
                s.getId(),
                s.getFull_name(),
                s.getGender(),
                s.getBorn(),
                s.getAddress(),
                s.getPhone_number(),
                s.getEmail(),
                s.getGpa()
        );

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Thêm thất bại!");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(Students s, String id) {
        Students tmp = getById(id);
        if (tmp == null) {
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE `students` SET `full_name` = '%s', `gender`= '%d' ,`born`='%s',`address`='%s',`phone_number`='%d',`email`='%s',`gpa`='%f' WHERE `id`='%s' ",
                s.getFull_name(),
                s.getGender(),
                s.getBorn(),
                s.getAddress(),
                s.getPhone_number(),
                s.getEmail(),
                s.getGpa(),
                id
        );

        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void delete(String id) {
        Students students = getById(id);
        if (students == null) {
            throw new RuntimeException("Sinh viên không tồn tại!");
        }

        final String sql = String.format("DELETE FROM students WHERE id = '%s'", id);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Students> getAllOrderByGpa() {
        List<Students> studentsList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students order by(diem_gpa) desc";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students s = new Students();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBorn(rs.getString("born"));
                s.setAddress(rs.getString("address"));
                s.setPhone_number(rs.getInt("phone_number"));
                s.setEmail(rs.getString("email"));
                s.setGpa(rs.getFloat("gpa"));
                studentsList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public static  List<Students> getStudentInHaNoi() {
        List<Students> studentsList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students where address = 'Ha Noi' and gpa > 2.6";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students students = new Students();
                students.setId(rs.getString("id"));
                students.setFull_name(rs.getString("full_name"));
                students.setGender(rs.getInt("gender"));
                students.setBorn(rs.getString("born"));
                students.setAddress(rs.getString("address"));
                students.setPhone_number(rs.getInt("phone_number"));
                students.setEmail(rs.getString("email"));
                students.setGpa(rs.getFloat("gpa"));
                studentsList.add(students);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }
    public List<Students> getStudentSapXepName() {
        List<Students> studentsList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM bkacad.students order by full_name asc";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students students = new Students();
                students.setId(rs.getString("id"));
                students.setFull_name(rs.getString("full_name"));
                students.setGender(rs.getInt("gender"));
                students.setBorn(rs.getString("ngay_sinh"));
                students.setAddress(rs.getString("dia_chi"));
                students.setPhone_number(rs.getInt("phone_number"));
                students.setEmail(rs.getString("email"));
                students.setGpa(rs.getFloat("gpa"));
                studentsList.add(students);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }
}
