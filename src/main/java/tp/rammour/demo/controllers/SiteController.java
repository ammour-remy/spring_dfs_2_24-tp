package tp.rammour.demo.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tp.rammour.demo.dao.SiteDao;
import tp.rammour.demo.models.Site;
import tp.rammour.demo.views.SiteView;

import java.util.List;

@RestController
public class SiteController {

    @Autowired
    private SiteDao siteDao;

    @GetMapping("/admin/chantier/list")
    @JsonView(SiteView.class)
    public List<Site> getAllSites() {
        return siteDao.findAll();
    }

    @GetMapping("/admin/chantier/{siteId}/total-time")
    public ResponseEntity<?> getTotalTimeForSite(@PathVariable Integer siteId) {
        Integer totalTime = siteDao.findTotalTimeBySiteId(siteId);
        if (totalTime == null) {
            return new ResponseEntity<>("No tasks found for the given site, or site does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(totalTime + " minutes", HttpStatus.OK);
    }

}
