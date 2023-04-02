package com.solutionchallenge.entertainment.domain.significant;

import com.solutionchallenge.entertainment.domain.guardian.Guardian;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignificantRepository extends JpaRepository<Significant,Long> {
    List<Significant> findByTutor(Tutor tutor);
    List<Significant> findByTutorOrderByCreateDateDesc(Tutor tutor);

    List<Significant> findByGuardian(Guardian guardian);

    List<Significant> findByGuardianOrderByCreateDateDesc(Guardian guardian);

}
