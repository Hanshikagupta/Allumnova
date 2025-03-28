package com.allumnova.allumnova.company;

import com.allumnova.allumnova.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateCompany(
                                                 @RequestBody Company updatedCompany,@PathVariable Integer id){
        return ResponseEntity.ok(companyService.updateCompany(updatedCompany,id));
    }
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Integer id){
        boolean isDel=companyService.deleteCompanyById(id);
        if (isDel) {
            return new ResponseEntity<>("Company deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Integer id){

        Company company=companyService.getCompanyById(id);
        if (company!=null)
            return new ResponseEntity<>(company, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND );
    }
}
