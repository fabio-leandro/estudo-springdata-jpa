package com.fabio.gymapi.repositories;

import com.fabio.gymapi.entities.AssessmentPhysical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssessmentRepository extends JpaRepository<AssessmentPhysical,Long> {

    List<AssessmentPhysical> findByStudentId(Long id);

    @Query(value = "SELECT * FROM tb_assessments ass INNER JOIN tb_students st ON ass.student_id = st.id WHERE st.name=?1", nativeQuery = true)
    List<AssessmentPhysical> findAssessmentByStudent(String name);

}
