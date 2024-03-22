package tp.rammour.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp.rammour.demo.models.Site;

public interface SiteDao extends JpaRepository<Site, Integer> {

    @Query("SELECT SUM(t.temps) FROM Operation o JOIN o.task t WHERE o.site.id = :siteId")
    Integer findTotalTimeBySiteId(@Param("siteId") Integer siteId);
}
