import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchCustomerComponent } from './search-customer/search-customer.component';


const routes: Routes = [
  {path :'search-customers' ,component :SearchCustomerComponent},
  {path :'' ,redirectTo : 'search-customers' ,pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
