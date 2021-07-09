import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Employee } from "./employee";

@Injectable({
    providedIn : 'root'
})
export class EmployeeService{
    
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http : HttpClient){}

    getEmployees() : Observable<Employee[]>{
        return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`);
    }

    getEmployeeById(employeeId : number) : Observable<Employee>{
       return this.http.get<Employee>(`${this.apiServerUrl}/employee/find/${employeeId}`);
    }

    addEmployee(employee : Employee) : Observable<Employee>{
       return this.http.post<Employee>(`${this.apiServerUrl}/employee/add`, employee);
    }

    updateEmployee(employee : Employee) : Observable<Employee>{
        return this.http.put<Employee>(`${this.apiServerUrl}/employee/update`, employee);
    }

    deleteEmployeeById(employeeId : number) : Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}/employee/delete/${employeeId}`);
    }
}