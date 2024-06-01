import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-shoppingcart',
  templateUrl: './shoppingcart.component.html',
  styleUrls: ['./shoppingcart.component.css']
})
export class ShoppingcartComponent {
  cartItems:any;
  coupon:any;
  constructor( private cartService: CartService, private userService: UserService, private router: Router) {}

  ngOnInit(): void {
       console.log('Loading shopping cart');
        let userId = this.userService.getUser().id;
        this.cartService.getMyCart(userId).subscribe(
          (data: any) => {
            this.cartItems = data;
            console.log(this.cartItems);
          },
          (error:any) => {
            console.log(error);
            alert('error in loading cart');
          }
        );
  }

  checkOut(item:any) {
    let discountPercentage:any = 0;
    if(this.coupon==50){
      discountPercentage = 50;
    }
    let wrapItem: any = {
      discount: discountPercentage,
      checkoutOrders: item
    };
    let userId = this.userService.getUser().id;

    console.log("wrap "+wrapItem);
    this.cartService.checkOut(userId,wrapItem).subscribe(
      (data:any)=>{
        alert("Thank You For Purchasing")
        this.router.navigate(['myorders']);
      },
      (error:any) => {
        console.log('Error !');
        console.log(error);
      }
    )
  }

  applyCoupon(){
    if(this.coupon==null || this.coupon == ''){
      alert("Pls Enter Coupon Code");
      return;
    }
    if(this.coupon == "Piesales50"){
      this.coupon = 50;
    }
    else{
      this.coupon = 0;
      alert("In-Valid Coupon Code");
      return;
    }
  }

  removeFromCart(productId:any){
    let userId = this.userService.getUser().id;
    this.cartService.removeFromCart(userId,productId).subscribe(
      (data:any)=>{
        alert("Item Removed Successfully")
        this.router.navigate(['myorder']);
      },
      (error:any) => {
        console.log('Error !');
        console.log(error);
      }
    )
  }

}
