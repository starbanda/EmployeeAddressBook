package com.capgemini.EmployeeAddressBook.Repository;

import com.capgemini.EmployeeAddressBook.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Integer> {

}
