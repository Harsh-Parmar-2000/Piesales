import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './components/products/products.component';
import { ShoppingcartComponent } from './components/shoppingcart/shoppingcart.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { MyorderComponent } from './components/myorder/myorder.component';

const routes: Routes = [

  { path: '',component: LoginComponent},
  { path: 'product', component: ProductsComponent },
  { path: 'register',component: RegisterComponent},
  { path: 'mycart', component: ShoppingcartComponent },
  { path: 'myorders',component: MyorderComponent},
  { path: '**',component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
