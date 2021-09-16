import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class CountryService {
    private baseURL =environment.jumiaTaskBackendURL;
    constructor(private httpclient: HttpClient) { }
	
	
    getCountryNames() : Observable<string[]>{
      return this.httpclient.get<string[]>(`${this.baseURL}/country-names`)
    }
}
