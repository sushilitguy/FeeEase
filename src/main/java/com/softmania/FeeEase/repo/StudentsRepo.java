package com.softmania.FeeEase.repo;

import com.softmania.FeeEase.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer> {
    @Query("SELECT s FROM Students s " +
            "WHERE s.id NOT IN " +
            "(SELECT f.student.id FROM Fees f " +
            "WHERE f.depositMonthYear = :depositMonthYear) AND s.school.id = :schoolId")
    public List<Students> getFeesNotPaidByStudentByMonthYear(int schoolId, String depositMonthYear);

    Students findBySession(String session);

    Students findBySessionAndSchoolClass(String session, String schoolClass);
}
