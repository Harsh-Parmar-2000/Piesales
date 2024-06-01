import { UserService } from 'src/app/services/user.service';
import { OrderService } from './../../services/order.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-myorder',
  templateUrl: './myorder.component.html',
  styleUrls: ['./myorder.component.css']
})
export class MyorderComponent {
  constructor( private orderService: OrderService, private userService: UserService, private router: Router) {}
  myOrders: any = [];
  currentStatus = 2
  showhide = 0;
  show(i:any){
    this.showhide = i;
  }

  ngOnInit(): void {
    console.log('Loading My Orders');
     let userId = this.userService.getUser().id;
     this.orderService.getMyOrders(userId).subscribe(
       (data: any) => {
         this.myOrders = data;
         console.log(this.myOrders);
       },
       (error:any) => {
         console.log(error);
         alert('error in loading cart');
       }
     );
  }
}
