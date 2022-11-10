package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.exception.TransportException;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;

public class CityRegisterValidator {

    public static final String IN_CODE = "NO_GRN";
    public String hostName;

    protected int port;

    String password;

    private String login;
    private final FakeCityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));
        for (Child child : so.getChildren()) {
            ans.addItem(checkPerson(child));
        }

        return ans;
        }

        private AnswerCityRegisterItem checkPerson (Person person){
            AnswerCityRegisterItem.CityStatus status = null;
            AnswerCityRegisterItem.CityError error = null;
            try {
                CityRegisterResponse tmp = personChecker.checkPerson(person);
                status = tmp.isExisting() ?
                        AnswerCityRegisterItem.CityStatus.YES :
                        AnswerCityRegisterItem.CityStatus.NO;
            } catch (CityRegisterException ex) {
                ex.printStackTrace(System.out);
                status = AnswerCityRegisterItem.CityStatus.ERROR;
                error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
            } catch (TransportException ex) {
                ex.printStackTrace(System.out);
                status = AnswerCityRegisterItem.CityStatus.ERROR;
                error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }

            AnswerCityRegisterItem and =
                    new AnswerCityRegisterItem(status, person, error);

            return null;
        }
    }
