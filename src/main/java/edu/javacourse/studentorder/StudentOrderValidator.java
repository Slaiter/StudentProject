package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.children.AnswerChildren;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.wedding.AnswerWedding;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private final CityRegisterValidator cityRegisterValidator;
    private final ChildrenValidator childrenValidator;
    private final WeddingValidator weddingValidator;
    private final MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterValidator = new CityRegisterValidator();
        childrenValidator = new ChildrenValidator();
        weddingValidator = new WeddingValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {
        List<StudentOrder> soList = readStudentOrders();

        for (StudentOrder studentOrder : soList) {
            checkOneOrder(studentOrder);
        }

    }

    static List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            StudentOrder studentOrder = SaveStudentOrder.buildStudentOrder(i);
            soList.add(studentOrder);
        }

        return soList;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "Host1";

        CityRegisterValidator crv2 = new CityRegisterValidator();
        crv2.hostName = "Host2";
        AnswerCityRegister ans1 = crv1.checkCityRegister(studentOrder);
        AnswerCityRegister ans2 = crv1.checkCityRegister(studentOrder);
        return ans1;
    }

    public void checkOneOrder(StudentOrder studentOrder) {
        AnswerCityRegister cityAnswer = checkCityRegister(studentOrder);
    }

    private AnswerChildren checkChildren(StudentOrder so) {
        return childrenValidator.checkChildren(so);
    }

    private AnswerWedding checkWedding(StudentOrder so) {
        return weddingValidator.checkWedding(so);
    }

    private void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}
