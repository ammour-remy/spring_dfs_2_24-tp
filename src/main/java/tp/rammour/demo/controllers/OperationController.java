package tp.rammour.demo.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import tp.rammour.demo.dao.OperationDao;
import tp.rammour.demo.models.Operation;
import tp.rammour.demo.views.OperationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OperationController {

    @Autowired
    private OperationDao operationDao;

    @GetMapping("/ouvrier/{ouvrierId}")
    @JsonView(OperationView.class)
    public ResponseEntity<List<Operation>> getOperationsForOuvrierWithSite(@PathVariable Integer ouvrierId) {
        List<Operation> operations = operationDao.findOperationsWithSiteByUserId(ouvrierId);
        return ResponseEntity.ok(operations);
    }

}
