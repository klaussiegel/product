import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoryTO } from 'src/app/shared/model/category-t-o';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('/api/categories')
  }

  getById(id: number): Observable<any> {
    return this.http.get('/api/categories/' + id)
  }

  create(category: CategoryTO): Observable<any> {
    return this.http.post<CategoryTO>('/api/categories/create/', category);
  }

  delete(id: number): Observable<any> {
    return this.http.delete('/api/categories/' + id)
  }

}
