import { Pipe, PipeTransform } from '@angular/core';
import { Employee } from './employee';

@Pipe({
  name: 'searchFilter'
})
export class SearchFilterPipe implements PipeTransform {

  transform(employees: Employee[], searchValue : string): Employee[] {
    if(!employees || !searchValue)
    {
      return employees;
    }
    return employees.filter(
      employee  => 
          employee.name.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()) ||
          employee.email.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()) ||
          employee.phone.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase())       
      );
  }

}
