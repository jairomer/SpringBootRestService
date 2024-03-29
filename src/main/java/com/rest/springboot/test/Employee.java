package payroll;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    public String getName() {return name;}

    public String getRole() {return role;}

    public void setName(String name) {this.name = name;}

    public void setRole(String role) {this.role = role;}

    public Long getId() { return id; }

    public void setId(Long id) {this.id = id;}

    Employee() {}

    Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (!(o instanceof Employee))
        return false;
      Employee employee = (Employee) o;
      return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
          && Objects.equals(this.role, employee.role);
    }

    @Override
    public String toString() {
        return String.format("Employee{id={}, name={}\\, role={}\\}", this.id, this.name, this.role);
    }
}