import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/';
import { ProductTO } from 'src/app/shared/model/product-t-o';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('/api/products')
  }

  delete(id: number): Observable<any> {
    return this.http.delete('/api/products/' + id)
  }

  create(product: ProductTO): Observable<any> {
    console.log(product)
    return this.http.post<ProductTO>('/api/products/create/', product);
  }

}
