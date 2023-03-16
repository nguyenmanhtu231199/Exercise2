import Students.Students;
import StudentsDao.StudentssDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
        private static StudentssDAO studentsDAO = new StudentssDAO();
        private static void mainMenu() {
            System.out.println("--- QUẢN LÝ THÔNG TIN SINH VIÊN ---");
            System.out.println("1. Danh sách sinh viên theo bảng");
            System.out.println("2. Thêm một sinh viên mới");
            System.out.println("3. Xoá một sinh viên theo mã");
            System.out.println("4. Cập nhật thông tin sinh viên");
            System.out.println("5. Tìm một sinh viên theo họ tên hoặc mã");
            System.out.println("6. Sắp xếp sinh viên theo điểm số GPA tăng dần");
            System.out.println("7. In ra tất cả sinh viên nữ ở Hà Nội có GPA trên 2.5");
            System.out.println("8. Sắp xếp sinh viên theo họ tên, sắp xếp theo bảng chữ cái abc");
        }

        private static void option1() {
            List<Students> studentsList = studentsDAO.getAll();
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "STT","Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ", "Điềm GPA");
            System.out.println();
            for (int i = 0; i < studentsList.size(); i++) {
                Students s = studentsList.get(i);
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", (i+1), s.getId(), s.getFull_name(), s.getGender(), s.getAddress(), s.getGpa());
            };
        }

        private static void option2(Scanner in){
            Students students = new Students();
            System.out.print("Nhập ID Sinh Viên : ");
            students.setId(in.nextLine());
            System.out.print("Nhập Họ Và Tên : ");
            students.setFull_name(in.nextLine());
            System.out.print("Nhập Giới Tính : ");
            students.setGender(Integer.parseInt(in.nextLine()));
            System.out.print("Nhập Ngày Sinh : ");
            students.setBorn(in.nextLine());
            System.out.print("Nhập Địa Chỉ : ");
            students.setAddress(in.nextLine());
            System.out.print("Nhập Phone Number : ");
            students.setPhone_number(Integer.parseInt(in.nextLine()));
            System.out.print("Nhập Email : ");
            students.setEmail(in.nextLine());
            System.out.print("Nhập Điểm GPA : ");
            students.setGpa(Float.parseFloat(in.nextLine()));
            studentsDAO.insert(students);
        }

        private static void option3(Scanner in) {
            Students s = new Students();
            System.out.print("Nhập id muốn xóa: ");
            String id = in.nextLine();
            studentsDAO.delete(id);
        }

        private static void option4(Scanner in){
            Students s = new Students();
            System.out.print("Nhập id product cần cập nhật : ");
            String id = in.nextLine();
            System.out.print("Nhập Họ Và Tên : ");
            s.setFull_name(in.nextLine());
            System.out.print("Nhập Giới Tính : ");
            s.setGender(Integer.parseInt(in.nextLine()));
            System.out.print("Nhập Ngày Sinh : ");
            s.setBorn(in.nextLine());
            System.out.print("Nhập Địa Chỉ : ");
            s.setAddress(in.nextLine());
            System.out.print("Nhập Phone Number : ");
            s.setPhone_number(Integer.parseInt(in.nextLine()));
            System.out.print("Nhập Email : ");
            s.setEmail(in.nextLine());
            System.out.print("Nhập Điểm GPA : ");
            s.setGpa(Float.parseFloat(in.nextLine()));
            studentsDAO.update(s, id);
        }
    private static void option6() {
        List<Students> stdList1 = StudentssDAO.getAllOrderByGpa();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "STT","Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ", "Điểm GPA");
        System.out.println();
        for (int i = 0; i < stdList1.size(); i++) {
            Students s = stdList1.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", (i+1), s.getId(), s.getFull_name(), s.getGender(), s.getAddress(),s.getGpa());
        };
    }

    private static void option7() {
        List<Students> stdList2 = StudentssDAO.getStudentInHaNoi();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "STT","Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ", "Điểm GPA");
        System.out.println();
        for (int i = 0; i < stdList2.size(); i++) {
            Students s = stdList2.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", (i+1), s.getId(), s.getFull_name(), s.getGender(), s.getAddress(),s.getGpa());
        };
    }
    private static void option8() {
        List<Students> stdList3 = studentsDAO.getStudentSapXepName();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "STT","Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ", "Điểm GPA");
        System.out.println();
        for (int i = 0; i < stdList3.size(); i++) {
            Students s = stdList3.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", (i+1), s.getId(), s.getFull_name(), s.getGender(), s.getAddress(),s.getGpa());
        };
    }

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            int option = -1;

            do {
                mainMenu();
                System.out.print("Nhập lựa chọn: ");
                option = Integer.parseInt(in.nextLine());
                // Làm thêm phàn try-catch khi người dùng nhập lỗi
                if (option < 1 || option > 9) {
                    System.out.println("Vui lòng nhập lại!");
                    continue;
                }
                switch (option) {
                    case 1:
                        option1();
                        break;
                    case 2:
                        option2(in);
                        break;
                    case 3:
                        option3(in);
                        break;
                    case 4:
                        option4(in);
                        break;
                    case 5:
                        break;
                    case 6:
                        option6();
                        break;
                    case 7:
                        option7();
                        break;
                    case 8:
                        option8();
                        break;
                    case 9:
                        break;
                }

            }
            while (option != 0);
            in.close();

        }
    }
