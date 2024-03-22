package tp.rammour.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tp.rammour.demo.models.Operation;

import java.util.List;

public interface OperationDao extends JpaRepository<Operation, Integer> {
    @Query("SELECT o FROM Operation o JOIN FETCH o.site WHERE o.user.id = :userId")
    List<Operation> findOperationsWithSiteByUserId(Integer userId);
}