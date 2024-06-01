import { Router } from '@angular/router';
import { UserService } from './../../services/user.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private userService:UserService,private router: Router){

  }
  user = {
    email: '',
    password: ''
  };

  ngOnInit(){

  }

  login(){
    if(this.user.email == '' || this.user.email == null){
      alert("Email is required");
      return;
    }
    this.userService.login(this.user).subscribe(
      (data:any)=>{
        this.userService.setTokenToLocalStorage(data.token);

        this.userService.getCurrentUser().subscribe((user: any) => {
          this.userService.setUser(user);
          console.log("user is coming "+JSON.stringify(user));
          console.log(this.userService.getUserRole());
          if (this.userService.getUserRole() == 'ROLE_ADMIN') {
            this.router.navigate(['admin']);
            this.userService.loginStatusSubject.next(true);
          } else if (this.userService.getUserRole() == 'ROLE_NORMAL') {
            this.router.navigate(['product']);
            this.userService.loginStatusSubject.next(true);
          } else {
            this.userService.logout();
          }
        });
      },
      (error) => {
        console.log('Error !');
        console.log(error);
      }
    )
  }


}
