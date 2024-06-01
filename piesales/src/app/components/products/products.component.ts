import { UserService } from './../../services/user.service';
import { Component } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {

  productList:any;
  constructor( private productService: ProductService, private userService: UserService) {}

  ngOnInit(): void {
        console.log('Loading all the products');

        this.productService.getAllProducts().subscribe(
          (data: any) => {
            this.productList = data;
            console.log(this.productList);
          },
          (error:any) => {
            console.log(error);
            alert('error in loading all products');
          }
        );
  }

  addToCart(productId:any, quantity: any): void{
    let userId = this.userService.getUser().id;
    console.log("userId  "+userId);
    console.log(productId);
    let cart = {
      userId: userId,
      productId: productId,
      quantity: quantity
    };
    this.productService.addToCart(cart).subscribe(
      (data: any) => {
        alert('Product added to cart successfully');
      },
      (error:any) => {
        console.log(error);
        alert('error in loading all products');
      }
    );
  }

}
