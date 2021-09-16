import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../models/customer';
import { FilterCustomer } from '../models/filter-customer';
import { CountryService } from '../services/country-service';
import { CustomerServiceService } from '../services/customer-service';

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrls: ['./search-customer.component.css']
})
export class SearchCustomerComponent implements OnInit {

  customers:Customer[];
  countries: string[];
  filterCustomer: FilterCustomer = new FilterCustomer();

  constructor(private customerService : CustomerServiceService,
                 private countryService : CountryService,
                 private router : Router) { }

  ngOnInit(): void {
    this.getAllCustomers();
    this.getCountriesName();
  }

  onSubmit(){
    this.filterCustomers(this.filterCustomer);
    this.router.navigate(['/search-customers']);
  }

  private getAllCustomers(){
    this.customerService.getAllCustomers().subscribe(data =>{
      this.customers =data;
    })
  }

  private getCountriesName(){
    this.countryService.getCountryNames().subscribe(data =>{
      this.countries = data as string [];
    })
  }

  private filterCustomers(filterCustomer : FilterCustomer){
    this.customerService.filterCustomers(filterCustomer).subscribe(data => {
      this.customers = data;
    })
  }


}
