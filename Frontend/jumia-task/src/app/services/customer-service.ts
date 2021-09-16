import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer';
import { FilterCustomer } from '../models/filter-customer';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  private baseURL = environment.jumiaTaskBackendURL;
  constructor(private httpclient: HttpClient) { }

  getAllCustomers() : Observable<Customer[]>{
    return this.httpclient.get<Customer[]>(`${this.baseURL}/customers`)
  }

  filterCustomers(filterCustomer : FilterCustomer) :Observable<Customer[]>{
    return this.httpclient.post<Customer[]>(`${this.baseURL}/search-customer`,filterCustomer);
  }


}
