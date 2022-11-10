package edu.javacourse.studentorder;

import edu.javacourse.studentorder.dao.StudentOrderDao;
import edu.javacourse.studentorder.dao.StudentOrderDaoImpl;
import edu.javacourse.studentorder.domain.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder
{
    public static void main(String[] args) throws Exception {
        StudentOrderDao dao = new StudentOrderDaoImpl();

        List<StudentOrder> soList = dao.getStudentOrders();
        for(StudentOrder so : soList) {
            System.out.println(so.getStudentOrderId());
        }
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder");

        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudentOrderId(id);
        studentOrder.setMarriageCertificateId("" + (123456000 + id));
        studentOrder.setMarriageDate(LocalDate.of(2016, 7, 4));

        RegisterOffice ro = new RegisterOffice(1L, "", "");
        studentOrder.setMarriageOffice(ro);

        Street street = new Street(1L, "First street");

        Address address = new Address("195000", street, "12", "777", "142");

        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L, ""));
        husband.setStudentId("GG7799");

        Adult wife = new Adult("Петрова", "Вероника", "Алекссевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice passportOffice = new PassportOffice(2L, "", "");
        wife.setIssueDepartment(passportOffice);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));
        wife.setStudentId("HH2277");

        Child firstChild = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        firstChild.setCertificateNumber("" + (300000 + id));
        firstChild.setIssueDate(LocalDate.of(2018, 6, 11));
        RegisterOffice registerOffice = new RegisterOffice(2L, "", "");
        firstChild.setIssueDepartment(registerOffice);
        firstChild.setAddress(address);

        Child secondChild = new Child("Петров", "Евгений", "Викторович", LocalDate.of(2018, 6, 29));
        secondChild.setCertificateNumber("" + (400000 + id));
        secondChild.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro3 = new RegisterOffice(3L, "", "");
        secondChild.setIssueDepartment(ro3);
        secondChild.setAddress(address);

        studentOrder.setHusband(husband);
        studentOrder.setWife(wife);
        studentOrder.addChild(firstChild);
        studentOrder.addChild(secondChild);

        return studentOrder;
    }
}