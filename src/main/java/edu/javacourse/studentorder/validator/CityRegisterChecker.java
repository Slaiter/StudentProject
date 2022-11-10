package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.exception.TransportException;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;

public interface CityRegisterChecker {

    CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException;
}
