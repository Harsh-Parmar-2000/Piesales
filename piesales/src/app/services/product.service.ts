import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import gatewayUrl from './helper';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {

  }

  public getAllProducts(){
    return this.http.get(`http://localhost:9090/product/api/getAllProducts`);
  }

  public addToCart(cart: any) {
    return this.http.post(`http://localhost:9090/cart/api/addToCart`,cart);
  }

}
