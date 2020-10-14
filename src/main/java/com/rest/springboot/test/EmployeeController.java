package payroll;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.RepresentationModel;

@RestController
class EmployeeController {
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root.
    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee (@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
        // The exception will be catched as a HTTP 404.
        return repository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

//    /* A more RESTful approach. */
//    EntityModel<Employee> one_2(@PathVariable Long id) {
//        Employee employee = repository.findById(id)
//            .orElseThrow(() -> new EmployeeNotFoundException(id));
//
//        return EntityModel.of(employee,
//            linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
//            linkTo(methodOn(EmployeeController.class).all()).withRel("employees")
//            );
//    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repository.findById(id)
            .map(employee -> {
                employee.setName(newEmployee.getName());
                employee.setName(newEmployee.getRole());
                return repository.save(employee);
            })
            .orElseGet(() -> {
                newEmployee.setId(id);
                return repository.save(newEmployee);
            });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }


}