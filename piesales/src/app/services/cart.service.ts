import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) {

  }

  public getMyCart(userId:any){
    return this.http.get(`http://localhost:9093/cart/api/getMyCart/${userId}`);
  }

  public checkOut(userId:any,cart:any){
    return this.http.post(`http://localhost:9094/order/api/checkout/${userId}`,cart);
  }

  public removeFromCart(userId:any,productId:any){
    return this.http.get(`http://localhost:9093/cart/api/removeFromCart/${userId}/${productId}`);
  }
}
