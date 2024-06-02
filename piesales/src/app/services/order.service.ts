import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  public getMyOrders(userId:any){
    return this.http.get(`http://localhost:9090/order/api/getMyOrders/${userId}`);
  }
}
