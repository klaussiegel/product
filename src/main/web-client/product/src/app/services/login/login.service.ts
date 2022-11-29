import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(userName: string, password: string): Observable<any> {
    return this.http.post('/api/login/', { userName: userName, password: password });
  }

}
