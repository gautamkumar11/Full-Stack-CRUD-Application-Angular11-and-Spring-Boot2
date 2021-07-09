import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Employee Manager';

  public employees!: Employee[];
  public editEmployee! : Employee;
  public deleteEmployeeId! : number;
  public searchValue : string = '';

  constructor(private employeeService : EmployeeService){}

  ngOnInit(){
    this.getEmployees();
  }

  public getEmployees() : void{
    this.employeeService.getEmployees().subscribe(
      (response : Employee[]) => {
        this.employees = response ;
      },
      (error : HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }

  public onAddEmployee(addForm : NgForm) : void{
      this.employeeService.addEmployee(addForm.value).subscribe(
        (response : Employee) => {
          console.log(response);
          this.getEmployees();
        },
        (error : HttpErrorResponse) => {
          alert(error.message);
        }
      )
  }

  public onEdit(employeeId : number) : void{
     this.employeeService.getEmployeeById(employeeId).subscribe(
        (response : Employee) => {
          this.editEmployee = response;
        },
        (error : HttpErrorResponse) => {
          alert(error.message)
        }
      );
  }
  public onUpdateEmployee(editForm : NgForm) : void{
    this.employeeService.updateEmployee(editForm.value).subscribe(
      (response : Employee) =>{
        console.log(response);
        this.getEmployees();
      },
      (error : HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  onDelete(employeeId : number) : void{
    this.deleteEmployeeId = employeeId;
  }

  onDeleteEmployee(deleteEmployeeId : number) : void{
    this.employeeService.deleteEmployeeById(deleteEmployeeId).subscribe(
      (response : void) => {
        console.log("Employee has been deleted");
        this.getEmployees();
      },
      (error : HttpErrorResponse) => {
        alert(error.message);
        
      }
    )
  }
  
}
